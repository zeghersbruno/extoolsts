package be.abis.courseadmin.test.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UtilityClass {
    public static double average(int[] arrayInt) {
        double totalInt=0;
        for (int i:arrayInt) {
            totalInt+=i;
        }
        if (arrayInt.length == 0) return 0;
        return totalInt/arrayInt.length;
    }

    /** writes the content of a list of strings to a file
     *
     * @param content the list of strings
     * @param fileName the name of the output file
     */
    public static void writeToFile(List<String> content, String fileName) {
        Path pathToFile= Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile)){
            for(String line: content) {
                writer.write(line);
            }
            System.out.println("Content written to " + pathToFile  );
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            e.printStackTrace();
        }
    }

    /** reads the list of strings from a file and put it into content
     *
     * @param fileName input file
     * @return list of strings
     */
    public static List<String> readFromFile(String fileName) {
        List<String> content = new ArrayList<>();
        Path pathToFile= Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)){
            while (reader.ready()) {
                content.add(reader.readLine());

            }
            System.out.println("Content read from "+pathToFile+":\n");
            for (String line:content) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            e.printStackTrace();
        }
        return content;
    }
}