package com.example.TaskScheduler.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate deadline;
    private int priority;
    private String note;
    private boolean done;

    public Task(String name, LocalDate deadline, int priority, String note) {
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
        this.note = note;
        this.done = false;
    }

    public Task() {
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getUkrainianFormattedDeadline() {
        Locale ukrainianLocale = new Locale("uk");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", ukrainianLocale);
        return getDeadline().format(formatter);
    }
    public String getEnglishFormattedDeadline() {
        Locale englishLocale = new Locale("en");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMM", englishLocale);
        return getDeadline().format(formatter);
    }
}
