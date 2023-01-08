package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Shubko Denis Nikolaevich");
        student.setGroup("PVS");
        student.setAdmission(new Date());

        System.out.println(student.getFio()
                + " study in group - " + student.getGroup()
                + " : " + student.getAdmission());
    }
}
