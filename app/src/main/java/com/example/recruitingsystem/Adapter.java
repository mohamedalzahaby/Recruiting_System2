package com.example.recruitingsystem;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import classes.Form;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{


    ArrayList<Form> forms;

    public Adapter(ArrayList<Form> forms) {
        this.forms = forms;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.list_of_forms, parent, false);

        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(listItem);
        return viewHolder;

//
//        myadaptor1.ViewHolder viewHolder = new myadaptor1.ViewHolder(listItem);
//        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.formItem.setText(forms.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button formItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.formItem = itemView.findViewById(R.id.formItem);
        }
    }
}
