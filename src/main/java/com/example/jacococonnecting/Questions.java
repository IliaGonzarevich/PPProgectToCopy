package com.example.jacococonnecting;

public class Questions {

    private String answer;
    private String question;
    private boolean choosen = true;


    public Questions( String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }


    public String getQuestion() { return question;}


    public boolean isChoosen() {
        return choosen;
    }

    public void setChoosen(boolean choosen) {
        this.choosen = choosen;
    }
}
