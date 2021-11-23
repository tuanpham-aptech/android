package com.example.cuoiki;

import java.util.List;

public class Question {
    private int number;
    private String content;
    private List<Answer> ListAnswer;
    public  Question(int number,String content,List<Answer> ListAnswer){
        this.number=number;
        this.content=content;
        this.ListAnswer=ListAnswer;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(){
        this.number=number;
    }
    public String getContent(){
        return content;

    }
    public void setContent(){
        this.content=content;
    }

    public List<Answer> getListAnswer() {
        return ListAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.ListAnswer = listAnswer;
    }
}
