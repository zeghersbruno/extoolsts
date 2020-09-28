package be.abis.courseadmin.test.ExF4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String instFirstName;
    private String instLastName;
    private LocalDate instBirthDate;
    private LocalDate instEntryDate;
    private double firstSalaris;

    public Instructor() {
    }

    public Instructor(String instFirstName, String instLastName, LocalDate instBirthDate, LocalDate instEntryDate, double firstSalaris) {
        this.instFirstName = instFirstName;
        this.instLastName = instLastName;
        this.instBirthDate = instBirthDate;
        this.instEntryDate = instEntryDate;
        this.firstSalaris = firstSalaris;
    }

    public String getInstFirstName() {
        return instFirstName;
    }

    public void setInstFirstName(String instFirstName) {
        this.instFirstName = instFirstName;
    }

    public String getInstLastName() {
        return instLastName;
    }

    public void setInstLastName(String instLastName) {
        this.instLastName = instLastName;
    }

    public LocalDate getInstBirthDate() {
        return instBirthDate;
    }

    public void setInstBirthDate(LocalDate instBirthDate) {
        this.instBirthDate = instBirthDate;
    }

    public LocalDate getInstEntryDate() {
        return instEntryDate;
    }

    public void setInstEntryDate(LocalDate instEntryDate) {
        this.instEntryDate = instEntryDate;
    }

    public double getFirstSalaris() {
        return firstSalaris;
    }

    public void setFirstSalaris(double firstSalaris) {
        this.firstSalaris = firstSalaris;
    }

    public int calculateAge() {
        int ageInst;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        currentDate.format(dtf);
        instBirthDate.format(dtf);
        int i1 = currentDate.getYear();
        int i2 = instBirthDate.getYear();
        ageInst = i1-i2;
        return ageInst;
    }

    public int calculateStartingAge() {
        int startingAge;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        instEntryDate.format(dtf);
        instBirthDate.format(dtf);
        int i1 = instEntryDate.getYear();
        int i2 = instBirthDate.getYear();
        startingAge = i1-i2;
        return startingAge;
    }

    public List<String> printSalaryHistory() {
        List<String> listLine = new ArrayList<>();
        double salary= firstSalaris;
        int seniority;
        for (int i=calculateStartingAge(); i<= calculateAge();i+=5) {
            seniority = i-calculateStartingAge();
            if (seniority<36) {
                System.out.println("Salary of "+ instFirstName+" at " + i + " is " + salary);
                listLine.add("Salary of "+ instFirstName+ "at " + i + " is " + salary + "\n");
                salary *= 1.03;
            } else {
                System.out.println("Maximum salary reached");
                listLine.add("Maximum salary reached");
            }
        }
        return listLine;
    }
}
