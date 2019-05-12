package com.example.wordroomsample.util;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

public class AppExecutors {
    private final Executor databaseIO;
    private final Executor mainThread;

    private AppExecutors(@NonNull Executor databaseIO, @NonNull Executor mainThread) {
        this.databaseIO = databaseIO;
        this.mainThread = mainThread;
    }

    public AppExecutors() {
        this(new DatabaseIOThreadExecutor(), new MainThreadExecutor());
    }

    public Executor databaseIO() {
        return databaseIO;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
