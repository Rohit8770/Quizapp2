package com.example.quizapp2.Quiz.model;

public class AnswerDataModel {

    private final String optionText;
    private final boolean isCorrect;

    public AnswerDataModel(String optionText, boolean isCorrect) {
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

    public String getOptionText() {
        return optionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean isSelected() {
        return false;
    }

    public void setSelected(boolean b) {

    }
}
