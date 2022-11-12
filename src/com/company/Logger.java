package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private static Logger instance = null;
    private int num = 1;

    public List<String> getListLog() {
        return listLog;
    }

    private final List<String> listLog = new ArrayList();
    private final Date date = new Date();

    private Logger() {
    }

    public static Logger get() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ' ' HH:mm:ss ");
        System.out.println("[" + formatForDateNow.format(date).toString() + " " + num + "] " + msg);
        listLog.add("[" + formatForDateNow.format(date).toString() + " " + num++ + "] " + msg);

    }
}
