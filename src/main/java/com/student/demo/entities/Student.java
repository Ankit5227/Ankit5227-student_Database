package com.student.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_Records")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "dob_Day", nullable = false)
    private int dobDay;

    @Column(name = "dob_Month", nullable = false)
    private int dobMonth;

    @Column(name = "dob_Year", nullable = false)
    private int dobYear;

    @Column(name = "Age", nullable = false)
    private int age;

    public Student(String name, int dobDay, int dobMonth, int dobYear) {
        this.name = name;
        this.dobDay = dobDay;
        this.dobMonth = dobMonth;
        this.dobYear = dobYear;
        this.age = calculateAge();
    }


    public int calculateAge() {
        LocalDate dob = LocalDate.of(dobYear, dobMonth, dobDay);
        return Period.between(dob, LocalDate.now()).getYears();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
