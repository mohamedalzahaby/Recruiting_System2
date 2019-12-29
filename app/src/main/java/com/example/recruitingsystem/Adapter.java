//package com.example.recruitingsystem;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//import classes.Board;
//
//public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{
//
//
//    ArrayList<Board> boards = new ArrayList<>();
//
//    public Adapter(ArrayList<Board> boards) {
//        this.boards = boards;
//    }
//
//    @NonNull
//    @Override
//    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Log.d("adapter", "onCreateViewHolder: start ");
//
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem = layoutInflater.inflate(R.layout.recyclerview_boards_list, parent, false);
//        ViewHolder viewHolder = new ViewHolder(listItem);
//
//        Log.d("adapter", "onCreateViewHolder: end ");
//
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
//
//        Log.d("adapter", "onBindViewHolder: start");
////        listData ListDaTa=listdata[i];
//        holder.btn_Year.setText(boards.get(position).getName());
//
//        Log.d("adapter", "onBindViewHolder: end");
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return boards.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public Button btn_Year;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.btn_Year = itemView.findViewById(R.id.BoardYearItem);
//        }
//    }
//}
