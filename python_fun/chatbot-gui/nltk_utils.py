import numpy as np
#NLTK là gì? NLTK là một thư viện python tiêu chuẩn với các chức năng và tiện ích được tạo sẵn để dễ sử dụng và triển khai. Nó là một trong những thư viện được sử dụng nhiều nhất để xử lý ngôn ngữ tự nhiên và ngôn ngữ học tính toán.
import nltk
# nltk.download('punkt')
from nltk.stem.porter import PorterStemmer
stemmer = PorterStemmer()

def tokenize(sentence):
    """
    tách câu thành một mảng từ / mã thông báo
    mã thông báo có thể là một từ hoặc ký tự dấu câu, hoặc số
    """
    return nltk.word_tokenize(sentence)


def stem(word):
    """
    stemming = tìm dạng gốc của từ
    ví dụ:
    từ = ["tổ chức", "tổ chức", "tổ chức"]
    words = [gốc (w) cho w trong từ]
    -> ["organ", "organ", "organ"]
    """
    return stemmer.stem(word.lower())


def bag_of_words(tokenized_sentence, words):
    """
    trả về mảng các từ:
    1 cho mỗi từ đã biết tồn tại trong câu, 0 nếu không
    thí dụ:
    câu = ["xin chào", "như thế nào", "là", "bạn"]
    words = ["xin chào", "xin chào", "tôi", "bạn", "tạm biệt", "cảm ơn", "tuyệt"]
    bog = [0, 1, 0, 1, 0, 0, 0]
    """
    # ngắt từng từ
    sentence_words = [stem(word) for word in tokenized_sentence]
    # khởi tạo túi với 0 cho mỗi từ
    bag = np.zeros(len(words), dtype=np.float32)
    for idx, w in enumerate(words):
        if w in sentence_words: 
            bag[idx] = 1

    return bag