package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recruitingsystem.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void addQuestions(String questions) {
        this.questions.add(questions);
    }
    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    private ArrayList<String> questions;

    public QuestionAdapter(ArrayList<String> questions) {
        this.questions = questions;
    }


    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_of_questions, parent, false);
        QuestionAdapter.ViewHolder viewHolder = new QuestionAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.question_checkBox.setText(questions.get(position));
    }


    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox question_checkBox;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            question_checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
