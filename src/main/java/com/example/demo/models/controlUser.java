package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
public class controlUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FIO;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private LocalDateTime start_time = LocalDateTime.now();
    private LocalDateTime end_time;
    private boolean isTimeEnd;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public boolean isTimeEnd() {
        return isTimeEnd;
    }

    public void setTimeEnd(boolean timeEnd) {
        isTimeEnd = timeEnd;
    }

    public controlUser(String FIO, LocalDateTime end_time) {
        this.FIO = FIO;
        this.end_time = end_time;
    }

    public controlUser(String FIO, LocalDateTime start_time, LocalDateTime end_time) {
        this.FIO = FIO;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public controlUser() {
    }
}
