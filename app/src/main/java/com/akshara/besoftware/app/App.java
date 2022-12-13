package com.akshara.besoftware.app;

import android.app.Application;

import com.akshara.besoftware.database.AppDatabase;
import com.akshara.besoftware.database.dao.TaskDao;

public class App extends Application {
    public static AppDatabase db;
    public static TaskDao taskDao;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        db = AppDatabase.getInstance(getApplicationContext());
        taskDao = db.taskDao();
    }
}
