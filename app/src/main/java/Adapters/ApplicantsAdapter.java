package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recruitingsystem.R;

import java.util.ArrayList;

import classes.Applicant;

public class ApplicantsAdapter extends RecyclerView.Adapter<ApplicantsAdapter.ViewHolder> {
    @NonNull

    ArrayList<Applicant> Applicants;
    public ApplicantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.list_of_forms, parent, false);
        ApplicantsAdapter.ViewHolder viewHolder = new ApplicantsAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicantsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
      return Applicants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
