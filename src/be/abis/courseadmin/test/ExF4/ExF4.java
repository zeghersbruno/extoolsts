package be.abis.courseadmin.test.ExF4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import be.abis.courseadmin.test.utilities.UtilityClass;

public class ExF4 {
    public static void main(String[] args) {

        // Add some instructors
        List<Instructor> instructors = new ArrayList<>();
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate iBiDa = LocalDate.parse("20.10.1960", dtf);
            LocalDate iEnDa = LocalDate.parse("03.04.1980", dtf);
            Instructor i1 = new Instructor("Jean", "Pierre", iBiDa, iEnDa, 2000.0);
            instructors.add(i1);
            System.out.println("Starting age of " + i1.getInstFirstName() + " " + i1.calculateStartingAge());
            System.out.println("Current age of " + i1.getInstFirstName() + " " + i1.calculateAge());
            iBiDa = LocalDate.parse("15.08.1956", dtf);
            iEnDa = LocalDate.parse("03.04.1989", dtf);
            Instructor i2 = new Instructor("Peter", "Frampton", iBiDa, iEnDa, 1500.0);
            instructors.add(i2);
            System.out.println("Starting age of " + i1.getInstFirstName() + " " + i1.calculateStartingAge());
            System.out.println("Current age of " + i1.getInstFirstName() + " " + i1.calculateAge());
            i2.printSalaryHistory();

            List<String> listInst = UtilityClass.readFromFile("C:\\Users\\bruno\\IdeaProjects\\exjava\\resources\\instructorsData.txt");

            // read instructors file
            for (String line:listInst) {
                StringBuilder strLine = new StringBuilder();
                strLine.append(line);
                int pString = 0;
                int iString = strLine.indexOf(";");
                String date;
                Instructor inst = new Instructor();
                // fill each instructor property in from the file
                for (int i=1; i<6;i++) {
                    switch (i) {
                        case 1:
                            inst.setInstFirstName(strLine.substring(pString, iString));
                            break;
                        case 2:
                            inst.setInstLastName(strLine.substring(pString, iString));
                            break;
                        case 3:
                            date = strLine.substring(pString, iString);
                            inst.setInstBirthDate(LocalDate.parse(date, dtf));
                            break;
                        case 4:
                            date = strLine.substring(pString, iString);
                            inst.setInstEntryDate(LocalDate.parse(date, dtf));
                            break;
                        case 5:
                            inst.setFirstSalaris(Double.parseDouble(strLine.substring(pString, iString)));
                            break;
                    }
                    pString = iString+1;
                    iString = strLine.indexOf(";",pString);
                }
                instructors.add(inst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    // Add some courses
    List<Course> courses = new ArrayList<>();
        try {
        Course c1 = new Course("java", 28, 200.00, true, instructors);
        courses.add(c1);
        c1.printInfos();
        Course c2 = new Course();
        c2.setTitle("C++");
        c2.setNumberOfDays(4);
        c2.setPricePerDay(50.50);
        c2.setPriorKnowledge(false);
        c2.setInstructors(instructors);
        c2.printInfos();
        courses.add(c2);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
