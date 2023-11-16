package com.example.quizapp2.Quiz.QuizAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.Quiz.MainActivity;
import com.example.quizapp2.Quiz.model.AnswerDataModel;
import com.example.quizapp2.Quiz.model.QuestionDataModel;
import com.example.quizapp2.R;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

    private final Context context;
    private final List<QuestionDataModel> quizDataList;
    private final AnswerAdapter.OptionSelectedInterface optionSelectedListener;
    private String question;
    private List<AnswerDataModel> optionsDataModels;
    private String correctAnswer;

    public QuestionsAdapter(Context context, List<QuestionDataModel> quizDataList, MainActivity optionSelectedListener) {
        this.context = context;
        this.quizDataList = quizDataList;
        this.optionSelectedListener = optionSelectedListener;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_answer,parent,false);
        return  new QuestionViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        QuestionDataModel quizDataModel = quizDataList.get(position);
        holder.bind(quizDataModel);
    }

    @Override
    public int getItemCount() {
        return quizDataList.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        private final TextView questionTextView;
        private final RadioGroup rdGroup;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            rdGroup = itemView.findViewById(R.id.optionsRadioGroup);
        }

        public void bind(QuestionDataModel quizDataModel) {
            questionTextView.setText(quizDataModel.getQuestion());

            // Clear existing radio buttons and add new ones
            rdGroup.removeAllViews();
            List<AnswerDataModel> options = quizDataModel.getOptionsDataModels();
            for (int i = 0; i < options.size(); i++) {
                AnswerDataModel option = options.get(i);
                RadioButton radioButton = new RadioButton(context);
                radioButton.setId(i);
                radioButton.setText(option.getOptionText());
                rdGroup.addView(radioButton);
            }

            // Set the selected option if available
            String selectedOption = quizDataModel.getSelectedOption();
            if (selectedOption != null) {
                int selectedOptionIndex = options.indexOf(new AnswerDataModel(selectedOption, false));
                if (selectedOptionIndex >= 0) {
                    ((RadioButton) rdGroup.getChildAt(selectedOptionIndex)).setChecked(true);
                }
            }

            // Listen for option selection changes
            rdGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
                RadioButton selectedRadioButton = itemView.findViewById(checkedId);
                if (selectedRadioButton != null) {
                    String selectedOptionText = selectedRadioButton.getText().toString();
                    optionSelectedListener.optionSelected(selectedOptionText);
                }
            });

        }
    }
}
