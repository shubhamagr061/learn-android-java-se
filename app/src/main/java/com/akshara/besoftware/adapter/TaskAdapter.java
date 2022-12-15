package com.akshara.besoftware.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshara.besoftware.R;
import com.akshara.besoftware.database.model.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
   private Context context;
   private ArrayList<Task> taskArrayList;

   public TaskAdapter(Context context, ArrayList<Task> taskArrayList){
       this.context =context;
       this.taskArrayList = taskArrayList;
   }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_task,parent,false);
       return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task item = taskArrayList.get(position);
        holder.tvName.setText(item.getTask_title());
        holder.tvDescription.setText(item.getTask_description());
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
       private TextView tvName, tvDescription;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

    public void update(ArrayList<Task> updateList){
       taskArrayList.clear();
       taskArrayList.addAll(updateList);
       this.notifyDataSetChanged();
    }
}
