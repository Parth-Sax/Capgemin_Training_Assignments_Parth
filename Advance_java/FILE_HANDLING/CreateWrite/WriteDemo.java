package CreateWrite;
import java.util.*;
import java.io.*;

public class WriteDemo {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/student.txt"));

            writer.write("Name : Rahul");
            writer.newLine();
            writer.write("Course : Spring");
            writer.newLine();
            writer.write("Marks : 90");
            writer.close();

            System.out.println("Data written using BufferedWriter");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
