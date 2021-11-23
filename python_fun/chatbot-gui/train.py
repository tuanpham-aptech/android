import numpy as np
import random
import json

import torch
import torch.nn as nn
from torch.utils.data import Dataset, DataLoader

from nltk_utils import bag_of_words, tokenize, stem
from model import NeuralNet

with open('intents.json', 'r',encoding='utf-8') as f:
    intents = json.load(f)

all_words = []
tags = []
xy = []
# lặp lại từng câu trong các mẫu ý định của chúng tôi
for intent in intents['intents']:
    tag = intent['tag']
    # thêm vào danh sách thẻ
    tags.append(tag)
    for pattern in intent['patterns']:
        # mã hóa từng từ trong câu
        w = tokenize(pattern)
        # thêm vào danh sách từ của chúng tôi
        all_words.extend(w)
        # thêm vào cặp xy
        xy.append((w, tag))

# gốc và hạ thấp mỗi từ
ignore_words = ['?', '.', '!']
all_words = [stem(w) for w in all_words if w not in ignore_words]
# loại bỏ các bản sao và sắp xếp
all_words = sorted(set(all_words))
tags = sorted(set(tags))
# in ra chiều dài và nội dung người hỏi 
print(len(xy), "patterns")
print(len(tags), "tags:", tags)
print(len(all_words), "unique stemmed words:", all_words)

# Tạo dữ liệu đào tạo 
X_train = []
y_train = []
for (pattern_sentence, tag) in xy:
    # X: Truy xuất thông tin và lưu vào bag
    bag = bag_of_words(pattern_sentence, all_words)
    X_train.append(bag)
    # y: PyTorch CrossEntropyLoss chỉ cần nhãn lớp, không phải nhãn một lớp
    label = tags.index(tag)
    y_train.append(label)

X_train = np.array(X_train)
y_train = np.array(y_train)

# Siêu tham số
num_epochs = 1000
batch_size = 8
learning_rate = 0.001
input_size = len(X_train[0])
hidden_size = 8
output_size = len(tags)
print(input_size, output_size)

class ChatDataset(Dataset):

    def __init__(self):
        self.n_samples = len(X_train)
        self.x_data = X_train
        self.y_data = y_train

    # hỗ trợ lập chỉ mục để tập dữ liệu [i] có thể được sử dụng để lấy mẫu thứ i
    def __getitem__(self, index):
        return self.x_data[index], self.y_data[index]

    # chúng ta có thể gọi len (dataset) để trả về kích thước
    def __len__(self):
        return self.n_samples

dataset = ChatDataset()
train_loader = DataLoader(dataset=dataset,
                          batch_size=batch_size,
                          shuffle=True,
                          num_workers=0)

device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')

model = NeuralNet(input_size, hidden_size, output_size).to(device)

# Mất mát và tối ưu hóa
criterion = nn.CrossEntropyLoss()
optimizer = torch.optim.Adam(model.parameters(), lr=learning_rate)

# Đào tạo mô hình
for epoch in range(num_epochs):
    for (words, labels) in train_loader:
        words = words.to(device)
        labels = labels.to(dtype=torch.long).to(device)
        
        # Chuyển tiếp qua
        outputs = model(words)
        # nếu bạn là một người nóng, chúng ta phải đăng ký
        # tag = torch.max (tag, 1) [1]
        loss = criterion(outputs, labels)
        
        # Lùi lại và tối ưu hoá 
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
        
    if (epoch+1) % 100 == 0:
        print (f'Epoch [{epoch+1}/{num_epochs}], Loss: {loss.item():.4f}')


print(f'final loss: {loss.item():.4f}')

data = {
"model_state": model.state_dict(),
"input_size": input_size,
"hidden_size": hidden_size,
"output_size": output_size,
"all_words": all_words,
"tags": tags
}

FILE = "data.pth"
torch.save(data, FILE)

print(f'training complete. file saved to {FILE}')
