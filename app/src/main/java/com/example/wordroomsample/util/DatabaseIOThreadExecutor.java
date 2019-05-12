package com.example.wordroomsample.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseIOThreadExecutor implements Executor {

    private final Executor mDatabaseIO;

    public DatabaseIOThreadExecutor() {
        mDatabaseIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(Runnable command) {
        mDatabaseIO.execute(command);
    }
}
