package com.abrahambueno.cars;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class CarsLog implements Serializable {
    private final String text;
    private final String formattedDate;
    public CarsLog() {
        this.text = "Looked up cars";
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        formattedDate = dateFormat.format(date);
//        printOut();
    }
    public void printOut() {
        log.info("msg", this.text, "date", this.formattedDate);
    }
}
