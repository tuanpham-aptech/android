package com.example.cuoiki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
private TextView tvQuestion,tvContentQuesion;
TextView tvAnswer1,tvAnswer2,tvAnswer3,tvAnswer4;
private List<Question> mListQuestion;
private Question mQuestion;
private int currentQuestion =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUi();
        mListQuestion=getListQuestion();//check loi data dau vao
        if(mListQuestion.isEmpty()){
            return;
        }
        setDataQuestion(mListQuestion.get(currentQuestion));
    }

    private void setDataQuestion(Question question) {
        if(question==null){
            return;
        }
        mQuestion = question;
        tvAnswer1.setBackgroundResource(R.drawable.bg_blue_corner_30);
        tvAnswer2.setBackgroundResource(R.drawable.bg_blue_corner_30);
        tvAnswer3.setBackgroundResource(R.drawable.bg_blue_corner_30);
        tvAnswer4.setBackgroundResource(R.drawable.bg_blue_corner_30);

        String titleQuestion ="Question"+question.getNumber();
        tvQuestion.setText(titleQuestion);
        tvContentQuesion.setText(question.getContent());
        tvAnswer1.setText(question.getListAnswer().get(0).getContent());
        tvAnswer2.setText(question.getListAnswer().get(1).getContent());
        tvAnswer3.setText(question.getListAnswer().get(2).getContent());
        tvAnswer4.setText(question.getListAnswer().get(3).getContent());
//xu li chon dap an
        //xu ly mau sac khi chon dung
        tvAnswer1.setOnClickListener(this);
        tvAnswer2.setOnClickListener(this);
        tvAnswer3.setOnClickListener(this);
        tvAnswer4.setOnClickListener(this);


    }


    private void initUi(){
        tvQuestion=(TextView)findViewById(R.id.tv_question);
        tvContentQuesion=(TextView)findViewById(R.id.tv_content_question);
        tvAnswer1=(TextView)findViewById(R.id.tv_answer1);//reset lai mau khi chon dug
        tvAnswer2=(TextView)findViewById(R.id.tv_answer2);
        tvAnswer3=(TextView)findViewById(R.id.tv_answer3);
        tvAnswer4=(TextView)findViewById(R.id.tv_answer4);


    }
    private List<Question> getListQuestion(){
        List<Question> list = new ArrayList<>();
        List<Answer> answersList1=new ArrayList<>();
        answersList1.add(new Answer("Gà",true));
        answersList1.add(new Answer("Cá",false));
        answersList1.add(new Answer("Bò",false));
        answersList1.add(new Answer("",false));
        List<Answer> answersList2=new ArrayList<>();
        answersList2.add(new Answer("Sỏi",false));
        answersList2.add(new Answer("Đá",true));
        answersList2.add(new Answer("Nước",false));
        answersList2.add(new Answer("Gối",false));
        List<Answer> answersList3=new ArrayList<>();
        answersList3.add(new Answer("Thai Nguyen",false));
        answersList3.add(new Answer("Da Nang",false));
        answersList3.add(new Answer("Ha Noi",true));
        answersList3.add(new Answer("Ha Tinh",false));

        list.add(new Question(1,"Con nào là gia cầm ?",answersList1));
        list.add(new Question(2,"Chân cứng ,... mềm ?",answersList2));
        list.add(new Question(3,"Thủ đô của Việt Nam là gì  ?",answersList3));
        return list;
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.tv_answer1 :
               tvAnswer1.setBackgroundResource(R.drawable.vg_blue_corner_10);
           checkAnswer(tvAnswer1,mQuestion,mQuestion.getListAnswer().get(0));
               break;
           case R.id.tv_answer2 :
               tvAnswer2.setBackgroundResource(R.drawable.vg_blue_corner_10);
               checkAnswer(tvAnswer2,mQuestion,mQuestion.getListAnswer().get(1));
               break;
           case R.id.tv_answer3 :
               tvAnswer3.setBackgroundResource(R.drawable.vg_blue_corner_10);
               checkAnswer(tvAnswer3,mQuestion,mQuestion.getListAnswer().get(2));
               break;
           case R.id.tv_answer4 :
               tvAnswer4.setBackgroundResource(R.drawable.vg_blue_corner_10);
               checkAnswer(tvAnswer4,mQuestion,mQuestion.getListAnswer().get(3));
               break;


       }

    }//check dap an dung hay k thay doi mau lenh checkanswer
    private  void checkAnswer(final TextView textView,Question question,Answer answer){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
if(answer.isCorrect()){
    textView.setBackgroundResource(R.drawable.bg_green_corner_30);
  nextQuestion();//tra loi dung next sang cau khac
}else {
     textView.setBackgroundResource(R.drawable.bg_red_corner_30);
  showAnserCorrect(question);//show ra tl dung
   gameOver();//tl loi sai se hien
}
        }


    },1000);
    }
    private void gameOver() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("Game over");
            }
        },1000);

    }

    private void showAnserCorrect(Question question) {
if(question==null || question.getListAnswer()==null || question.getListAnswer().isEmpty()){
    return;
}if(question.getListAnswer().get(0).isCorrect()){
  tvAnswer1.setBackgroundResource(R.drawable.bg_green_corner_30);
        }else if(question.getListAnswer().get(1).isCorrect()) {
            tvAnswer2.setBackgroundResource(R.drawable.bg_green_corner_30);
        }else if(question.getListAnswer().get(2).isCorrect()) {
            tvAnswer3.setBackgroundResource(R.drawable.bg_green_corner_30);
        }else if(question.getListAnswer().get(3).isCorrect()) {
            tvAnswer4.setBackgroundResource(R.drawable.bg_green_corner_30);
        }
}

    private void nextQuestion() {
        if(currentQuestion==mListQuestion.size()-1){
            showDialog("You win");//neu la cau cuoi cung
        }else {
            currentQuestion++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion(mListQuestion.get(currentQuestion));
                }
            },1000);
            setDataQuestion(mListQuestion.get(currentQuestion));

        }
    }
    private  void showDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);//tao nut thoat yes khi game over
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               currentQuestion = 0;
               setDataQuestion(mListQuestion.get(currentQuestion));
               dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}// doi mau trong vao 1s