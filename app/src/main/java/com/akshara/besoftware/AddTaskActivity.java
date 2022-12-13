package com.akshara.besoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akshara.besoftware.app.App;
import com.akshara.besoftware.database.model.Task;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText etTaskTitle, etTaskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        initVars();
        setOnClickListener();
    }

    private void setOnClickListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = etTaskTitle.getText().toString();
                String taskDescription = etTaskDescription.getText().toString();

                Task task = new Task();
                task.setTask_title(taskTitle);
                task.setTask_description(taskDescription);
                task.setTask_time("12:00 AM");

                App.db.taskDao().insert(task);

                Toast.makeText(AddTaskActivity.this, "Task added", Toast.LENGTH_SHORT).show();
                Log.d("DB_TEST", "Database Size ==> "+App.db.taskDao().getAllTask().size());
            }
        });
    }

    private void initVars() {
        etTaskTitle = findViewById(R.id.etTaskTitle);
        etTaskDescription = findViewById(R.id.etTaskDescription);
        btnAdd = findViewById(R.id.btnAddTask);
    }
}