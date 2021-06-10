package ru.task.clickerapplication.service;

import com.sun.istack.NotNull;

public interface ClickService {
    @NotNull
    String getCounter();

    @NotNull String increment();
}
