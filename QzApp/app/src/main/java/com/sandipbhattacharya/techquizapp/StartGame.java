package com.sandipbhattacharya.techquizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StartGame extends AppCompatActivity {
    TextView tvTimer;
    TextView tvResult;
    ImageView ivShowImage;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> techList = new ArrayList<>();
    int index;
    Button btn1, btn2, btn3, btn4;
    // Một TextView để hiển thị điểm
    TextView tvPoints;
    // Một biến số nguyên để lưu trữ điểm
    int points;
    // Tham chiếu đối tượng CountDownTimer
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);
        // Đặt chế độ xem nội dung bằng tệp bố cục.
        tvTimer = findViewById(R.id.tvTimer);
        // Nhận các chốt cho Chế độ xem
        tvResult = findViewById(R.id.tvResult);
        ivShowImage = findViewById(R.id.ivShowImage);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        // Khởi tạo chỉ mục = 0
        index = 0;
        // Điền vào danh sách công nghệ với tất cả các tên công nghệ
        techList.add("Bootstrap");
        techList.add("C");
        techList.add("Codeigniter");
        techList.add("Cplusplus");
        techList.add("Csharp");
        techList.add("Css3");
        techList.add("Github");
        techList.add("Html5");
        techList.add("Java");
        techList.add("jQuery");
        techList.add("MySQL");
        techList.add("Nodejs");
        techList.add("Php");
        techList.add("Python");
        techList.add("Wordpress");
        techList.add("Android");
        // Đưa tất cả các tên công nghệ có id tài nguyên hình ảnh công nghệ lên bản đồ.
        map.put(techList.get(0), R.drawable.bootstrap);
        map.put(techList.get(1), R.drawable.c);
        map.put(techList.get(2), R.drawable.codeigniter);
        map.put(techList.get(3), R.drawable.cplusplus);
        map.put(techList.get(4), R.drawable.csharp);
        map.put(techList.get(5), R.drawable.css3);
        map.put(techList.get(6), R.drawable.github);
        map.put(techList.get(7), R.drawable.html5);
        map.put(techList.get(8), R.drawable.java);
        map.put(techList.get(9), R.drawable.jquery);
        map.put(techList.get(10), R.drawable.mysql);
        map.put(techList.get(11), R.drawable.nodejs);
        map.put(techList.get(12), R.drawable.php);
        map.put(techList.get(13), R.drawable.python);
        map.put(techList.get(14), R.drawable.wordpress);
        map.put(techList.get(15), R.drawable.android);
        Collections.shuffle(techList);
        millisUntilFinished = 10000;
        // Khởi tạo điểm = 0
        points = 0;
        // Gọi phương thức startGame () chịu trách nhiệm bắt đầu bài kiểm tra.
        startGame();
    }

    private void startGame() {
        // Khởi tạo 10000 mili giây
        millisUntilFinished = 10000;
        // Đặt textView cho hẹn giờ
        tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
        // Đặt textview cho điểm
        tvPoints.setText(points + " / " + techList.size());

        generateQuestions(index);

        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // Cập nhật tvTimer cứ sau 1 giây để hiển thị số giây còn lại.
                tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                index++;
                if (index > techList.size() - 1){
                    // Nếu đúng, hãy ẩn ImageView và Buttons.
                    ivShowImage.setVisibility(View.GONE);
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    // Chuyển đến màn hình GameOver với các điểm bằng Intent
                    Intent intent = new Intent(StartGame.this, GameOver.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                    finish();
                } else {
                    countDownTimer = null;
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int index) {
        // Sao chép techList vào một ArrayList mới có tên techListTemp.
        ArrayList<String> techListTemp = (ArrayList<String>) techList.clone();
        String correctAnswer = techList.get(index);
        techListTemp.remove(correctAnswer);
        Collections.shuffle(techListTemp);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(techListTemp.get(0));
        newList.add(techListTemp.get(1));
        newList.add(techListTemp.get(2));
        // Cũng thêm câu trả lời đúng vào newList
        newList.add(correctAnswer);
        Collections.shuffle(newList);

        btn1.setText(newList.get(0));
        btn2.setText(newList.get(1));
        btn3.setText(newList.get(2));
        btn4.setText(newList.get(3));
        // Ngoài ra, đặt ImageView với hình ảnh hiện tại từ bản đồ
        ivShowImage.setImageResource(map.get(techList.get(index)));
    }

    public void nextQuestion(View view) {

        btn1.setBackgroundColor(Color.parseColor("#2196f3"));
        btn2.setBackgroundColor(Color.parseColor("#2196f3"));
        btn3.setBackgroundColor(Color.parseColor("#2196f3"));
        btn4.setBackgroundColor(Color.parseColor("#2196f3"));
        //Bật các nút
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        // Hủy countDownTimer
        countDownTimer.cancel();
        index++;
        // Kiểm tra xem tất cả các câu hỏi đã được hỏi chưa.
        if (index > techList.size() - 1){
            // Nếu đúng, hãy ẩn ImageView và Buttons.
            ivShowImage.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            // Chuyển đến màn hình GameOver với điểm
            Intent intent = new Intent(StartGame.this, GameOver.class);
            intent.putExtra("points", points);
            startActivity(intent);
            // Kết thúc Hoạt động StartGame
            finish();
        } else {
            countDownTimer = null;
            startGame();
        }
    }

    public void answerSelected(View view) {
        // Thay đổi màu nền của Nút đã nhấp
        view.setBackgroundColor(Color.parseColor("#17243e"));
        // Disable all four Buttons
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        // Người dùng đã chọn một câu trả lời, vì vậy, hãy hủy countDownTimer
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = techList.get(index);

        if(answer.equals(correctAnswer)){
            // Nếu đúng, người dùng đã chọn câu trả lời đúng. Vì vậy, tăng điểm.
            points++;
            tvPoints.setText(points + " / " + techList.size());
            tvResult.setText("Correct");
        } else {
            tvResult.setText("Wrong");
        }
    }
}
