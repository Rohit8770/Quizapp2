package com.example.quizapp2.Quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2.Quiz.Fragment.QuizResultDialogFragment;
import com.example.quizapp2.Quiz.QuizAdapter.AnswerAdapter;
import com.example.quizapp2.Quiz.QuizAdapter.QuestionsAdapter;
import com.example.quizapp2.R;
import com.example.quizapp2.Quiz.model.AnswerDataModel;
import com.example.quizapp2.Quiz.model.QuestionDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements AnswerAdapter.OptionSelectedInterface, QuizResultDialogFragment.OnDialogButtonClickListener {


    List<QuestionDataModel> quizDataList;
    QuestionsAdapter questionsAdapter;
    boolean isLastItem = false;
    int rightAnswerCount;
    int wrongAnswerCount;
    int skippedQuestionCount;
    int currentQuestionIndex = 0; // Current question index
    String option;
    LinearLayoutManager layoutManager;

    TextView tx1,tx2,tx3;

    RecyclerView Ques;
    Button cSkip,Final;

    ImageView Next,Back;
    private CountDownTimer countDownTimer;
    TextView timerTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ques=findViewById(R.id.Ques);
        Next=findViewById(R.id.Next);
        Back=findViewById(R.id.Back);
        cSkip=findViewById(R.id.cSkip);

        timerTextView=findViewById(R.id.timerTextView);

        layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);

        CountDownTimer();
        init();
    }
    private void CountDownTimer(){

        CountDownTimer countDownTimer =new CountDownTimer(50000,1000) {

            @Override
            public void onTick(long l) {
                String text = String.format(Locale.getDefault(), "%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l) % 60, TimeUnit.MILLISECONDS.toSeconds(l) % 60
                );
                timerTextView.setText("Time: " + text);
            }
            @Override
            public void onFinish() {
                finishQuiz();
            }
        };
        countDownTimer.start();
    }
    private List<QuestionDataModel> QuestionData() {

        List<QuestionDataModel> quizList = new ArrayList<>();

        List<AnswerDataModel> Quiz1 = new ArrayList<>();
        Quiz1.add(new AnswerDataModel("a) 1", false));
        Quiz1.add(new AnswerDataModel("b) 2", false));
        Quiz1.add(new AnswerDataModel("c) 3", false));
        Quiz1.add(new AnswerDataModel("d) 4", false));
        quizList.add(new QuestionDataModel("1)  15-12= ?", Quiz1, "c) 3"));

        List<AnswerDataModel> Quiz2 = new ArrayList<>();
        Quiz2.add(new AnswerDataModel("a) 100", false));
       Quiz2.add(new AnswerDataModel("b) 200", false));
        Quiz2.add(new AnswerDataModel("c) 300", false));
        Quiz2.add(new AnswerDataModel("d) 400", false));
        quizList.add(new QuestionDataModel("2)  20*2*5+200= ?", Quiz2, "d) 400"));

        List<AnswerDataModel> Quiz3 = new ArrayList<>();
       Quiz3.add(new AnswerDataModel("a) 122", false));
        Quiz3.add(new AnswerDataModel("b) 133", false));
        Quiz3.add(new AnswerDataModel("c) 144", false));
        Quiz3.add(new AnswerDataModel("d) 155", false));
        quizList.add(new QuestionDataModel("3)  11*11+33= ?", Quiz3, "d) 155"));

        List<AnswerDataModel> Quiz4 = new ArrayList<>();
        Quiz4.add(new AnswerDataModel("a) 1000", false));
        Quiz4.add(new AnswerDataModel("b) 2000", false));
        Quiz4.add(new AnswerDataModel("c) 3000", false));
        Quiz4.add(new AnswerDataModel("d) 4000", false));
        quizList.add(new QuestionDataModel("4)  10*100+1000+1000-1000= ?",Quiz4, "b) 2000"));

        List<AnswerDataModel> Quiz5 = new ArrayList<>();
        Quiz5.add(new AnswerDataModel("a) 2222", false));
        Quiz5.add(new AnswerDataModel("b) 3333", false));
        Quiz5.add(new AnswerDataModel("c) 4444", false));
    Quiz5.add(new AnswerDataModel("d) 5555", false));
        quizList.add(new QuestionDataModel("5)  100*100-5000+555= ?", Quiz5, "d) 5555"));

        List<AnswerDataModel> Quiz6 = new ArrayList<>();
        Quiz6.add(new AnswerDataModel("a) 70", false));
      Quiz6.add(new AnswerDataModel("b) 80", false));
        Quiz6.add(new AnswerDataModel("c) 90", false));
 Quiz6.add(new AnswerDataModel("d) 140", false));
        quizList.add(new QuestionDataModel("6)  2*10+10-60-50 = ?",Quiz6, "c) 90"));

        List<AnswerDataModel> Quiz7 = new ArrayList<>();
       Quiz7.add(new AnswerDataModel("a) 10", false));
        Quiz7.add(new AnswerDataModel("b) 15", false));
       Quiz7.add(new AnswerDataModel("c) 20", false));
       Quiz7.add(new AnswerDataModel("d) 40", false));
        quizList.add(new QuestionDataModel("7)  3*20-10-10-20-5 = ?",Quiz7, "b) 15"));

        List<AnswerDataModel> Quiz8 = new ArrayList<>();
        Quiz8.add(new AnswerDataModel("a) 20000", false));
       Quiz8.add(new AnswerDataModel("b) 15000", false));
       Quiz8.add(new AnswerDataModel("c) 10000", false));
     Quiz8.add(new AnswerDataModel("d) 12000", false));
        quizList.add(new QuestionDataModel("8)  100*20*5+2000 = ?",Quiz8, "d) 12000"));

        List<AnswerDataModel> Quiz9 = new ArrayList<>();
        Quiz9.add(new AnswerDataModel("a) 500", false));
        Quiz9.add(new AnswerDataModel("b) 550", false));
      Quiz9.add(new AnswerDataModel("c) 600", false));
    Quiz9.add(new AnswerDataModel("d) 650", false));
        quizList.add(new QuestionDataModel("9)   100+200+300-100 = ?", Quiz9, "a) 500"));

        List<AnswerDataModel> Quiz10 = new ArrayList<>();
        Quiz10.add(new AnswerDataModel("a) 60000", false));
     Quiz10.add(new AnswerDataModel("b) 70000", false));
        Quiz10.add(new AnswerDataModel("c) 80000", false));
       Quiz10.add(new AnswerDataModel("d) 90000", false));
        quizList.add(new QuestionDataModel("10)   5000*5+20000-5000+20000+10000 = ?", Quiz10, "b) 70000"));

        return quizList;
    }
    @SuppressLint("ClickableViewAccessibility")
    private void init() {

        quizDataList = new ArrayList<>();
        quizDataList = QuestionData();

        layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        Ques.setLayoutManager(layoutManager);
        questionsAdapter = new QuestionsAdapter(MainActivity.this, quizDataList, this);
        Ques.setAdapter(questionsAdapter);
        Ques.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int findLastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                isLastItem = findLastCompletelyVisibleItemPosition == questionsAdapter.getItemCount() - 1;
                int findFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition == 0) {
                } else {
                }

            }
        });
        Next.setOnClickListener(v -> {
            int currentPosition = layoutManager.findFirstVisibleItemPosition();
            if (currentPosition < quizDataList.size() - 1) {
                QuestionDataModel nextQuizItem = quizDataList.get(currentPosition /+ 1);
                String selectedOption = nextQuizItem.getSelectedOption();
                if (selectedOption != null) {
                    option = selectedOption;
                } else {
                    Toast.makeText(this, "Please select an option.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            if (isLastItem) {
                if (validation()) {
                    option = null;
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        layoutManager.scrollToPosition(currentPosition + 1);
                    }
                    finishQuiz();
                }
            } else {
                if (validation()) {
                    option = null;
                    // Perform forward scrolling logic here
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        layoutManager.scrollToPosition(currentPosition + 1);
                    }
                }
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = layoutManager.findFirstVisibleItemPosition();
                if (currentPosition > 0) {
                    QuestionDataModel previousQuizItem = quizDataList.get(currentPosition - 1);
                    String selectedOption = previousQuizItem.getSelectedOption();
                    if (selectedOption != null) {
                        option = selectedOption;
                    }
                    layoutManager.scrollToPosition(currentPosition - 1);
                }
            }
        });
        cSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLastItem) {
                    int currentPosition = layoutManager.findFirstVisibleItemPosition();
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        layoutManager.scrollToPosition(currentPosition + 1);
                    }

                } else {
                    int currentPosition = layoutManager.findFirstVisibleItemPosition();
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        layoutManager.scrollToPosition(currentPosition + 1);
                    }
                }
            }
        });
        int totalQuestions = quizDataList.size();
    }
    private void showQuestionAtIndex(int index) {
        QuestionDataModel question = quizDataList.get(index);
        String questionText = question.getQuestion();
        List<AnswerDataModel> options = question.getOptionsDataModels();
    }
    private void finishQuiz() {
        int totalQuestions = quizDataList.size();
        rightAnswerCount = 0;
        wrongAnswerCount = 0;
        skippedQuestionCount = 0;

        for (QuestionDataModel quizData : quizDataList) {
            String selectedOption = quizData.getSelectedOption();
            if (selectedOption == null) {
                skippedQuestionCount++;
            } else if (selectedOption.equals(quizData.getCorrectAnswer())) {
                rightAnswerCount++;
            } else {
                wrongAnswerCount++;
            }
        }
 /*       FragmentManager fragmentManager = getSupportFragmentManager();
        QuizResultDialogFragment quizResultDialogFragment = QuizResultDialogFragment.newInstance();*/



        QuizResultDialogFragment dialogFragment = new QuizResultDialogFragment();
        Bundle args = new Bundle();
        args.putString("totalQues", String.valueOf(totalQuestions));
        args.putString("right", String.valueOf(rightAnswerCount));
        args.putString("wrongA", String.valueOf(wrongAnswerCount));
        args.putString("skipQues", String.valueOf(skippedQuestionCount));
//        dialogFragment.setArguments(args);
        dialogFragment.setButtonClickListener(new QuizResultDialogFragment.OnDialogButtonClickListener() {
            @Override
            public void onPositiveButtonClick() {
                finish();
            }
        });
        dialogFragment.show(getSupportFragmentManager(), "QuizResultDialog");
    }


    @Override
    public void onCreate2(Bundle savedInstanceState) {
    }
    @Override
    public void optionSelected(String option) {
        this.option = option;
        int currentPosition = layoutManager.findFirstVisibleItemPosition();
        QuestionDataModel currentQuizItem = quizDataList.get(currentPosition);
        currentQuizItem.setSelectedOption(option);
    }
    public boolean validation() {
        boolean isSelected;
        String selectedOption = option;
        if (selectedOption != null) {
            isSelected = true;
        } else {
            isSelected = false;
            Toast.makeText(this, "Please select option or skip the question", Toast.LENGTH_SHORT).show();
        }
        return isSelected;
    }
    @Override
    public void onPositiveButtonClick() {
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}
