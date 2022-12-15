package com.akshara.besoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.akshara.besoftware.adapter.TaskAdapter;
import com.akshara.besoftware.app.App;
import com.akshara.besoftware.database.model.Task;
import com.akshara.besoftware.databinding.ActivityAllTaskBinding;

import java.util.ArrayList;

public class AllTaskActivity extends AppCompatActivity {
    ActivityAllTaskBinding binding;
    private TaskAdapter adapter;
    private ArrayList<Task> taskArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllTaskBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setAppBar();
        binding.btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllTaskActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        binding.rvTask.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new TaskAdapter(this, taskArrayList);
        binding.rvTask.setAdapter(adapter);
    }

    private void setAppBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.txtTask);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.update((ArrayList<Task>) App.taskDao.getAllTask());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}