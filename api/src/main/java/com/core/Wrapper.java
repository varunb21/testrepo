package com.core;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Wrapper {

    public void holdOn(int i) {
        try {
            Thread.sleep((long)i);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }

    public String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
}
