package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текущая дата: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущая дата/время: " + currentDateTime.format(formatter));
    }
}
