package com.example.quizapp2.Quiz.QuizAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quizapp2.Quiz.model.AnswerDataModel;
import com.example.quizapp2.R;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private final Context context;
    private final List<AnswerDataModel> answerDataModelList;
    private final OptionSelectedInterface optionSelectedListener;

    public AnswerAdapter(Context context, List<AnswerDataModel> answerDataModelList, OptionSelectedInterface optionSelectedListener) {
        this.context = context;
        this.answerDataModelList = answerDataModelList;
        this.optionSelectedListener = optionSelectedListener;
    }


    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_question1,parent,false);
        return  new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        AnswerDataModel option = answerDataModelList.get(position);
        holder.btnRadio.setText(option.getOptionText());
        holder.btnRadio.setChecked(option.isSelected());

        holder.btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option.setSelected(true);
                for (AnswerDataModel otherOption : answerDataModelList) {
                    if (otherOption != option) {
                        otherOption.setSelected(false);
                    }
                }
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return answerDataModelList.size();
    }
    public class AnswerViewHolder extends RecyclerView.ViewHolder {
        private final RadioButton btnRadio;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            btnRadio = itemView.findViewById(R.id.btnRadio);
        }
        public void bind(AnswerDataModel optionsDataModel) {
            btnRadio.setText(optionsDataModel.getOptionText());
            btnRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    optionSelectedListener.optionSelected(optionsDataModel.getOptionText());
                }
            });
        }
    }






/*
  @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, @SuppressLint("RecyclerView") int position) {
        QuizAnswerModel quizAnswerModel=quizAnswerModelList.get(position);
        holder.rd1.setText(quizAnswerModel.getQuizAnswer().toString().trim());

       holder.rd1.setChecked(position == selectedPosition);

                holder.rd1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        selectedPosition = position;
        notifyDataSetChanged();
        }
        });
      holder.rd1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            selectedPosition = position;
            notifyDataSetChanged();
            }
            });
*/
    public interface OptionSelectedInterface {
        void onCreate2(Bundle savedInstanceState);

        void optionSelected(String option);

        void onPositiveButtonClick();
    }
}
