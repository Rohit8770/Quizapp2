package com.example.quizapp2.Quiz.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.quizapp2.R;

public class QuizResultDialogFragment extends DialogFragment {

    private OnDialogButtonClickListener buttonClickListener;

    public interface OnDialogButtonClickListener {
        void onPositiveButtonClick();
    }

    public void setButtonClickListener(OnDialogButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_quiz_result_dialog, null);

        builder.setView(dialogView);

        TextView resultTextView = dialogView.findViewById(R.id.resultTextView);
        Button closeButton = dialogView.findViewById(R.id.btnClose);

        Bundle args = getArguments();
        if (args != null) {
            String total = args.getString("totalQues", "");
            String right = args.getString("right", "");
            String wrong = args.getString("wrongA", "");
            String skipQues = args.getString("skipQues", "");

            String result = "\n"
                    + "TotalQuestion : " + total + "\n"
                    + "Correct_Answer : " + right + "\n"
                    + "Wrong_Answer : " + wrong + "\n"
                    + "Skip_Question: " + skipQues;

            resultTextView.setText(result);
        }

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify the parent activity/fragment when the close button is clicked
                if (buttonClickListener != null) {
                    buttonClickListener.onPositiveButtonClick();
                }
                dismiss();
            }
        });

        return builder.create();
    }
}
