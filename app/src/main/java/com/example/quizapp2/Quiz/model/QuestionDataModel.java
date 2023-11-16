package com.example.quizapp2.Quiz.model;

import java.util.List;

public class QuestionDataModel { private final String question;
    private final List<AnswerDataModel> optionsDataModels;
    private String selectedOption;
    private final String correctAnswer;

    public QuestionDataModel(String question, List<AnswerDataModel> optionsDataModels, String correctAnswer) {
        this.question = question;
        this.optionsDataModels = optionsDataModels;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<AnswerDataModel> getOptionsDataModels() {
        return optionsDataModels;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
