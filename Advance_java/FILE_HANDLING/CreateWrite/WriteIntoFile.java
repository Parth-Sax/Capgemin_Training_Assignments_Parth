package CreateWrite;
import java.io.*;

public class WriteIntoFile {
    public static void main(String[] args) {
        try{
            doWrite();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void doWrite() throws IOException{
        FileWriter writer = new FileWriter("data/student.txt", true);

        writer.write("Name : Jones");
        writer.write("Course : Golang");
        writer.write("Marks : 85");

        writer.close();
        System.out.println("Data appended successfully");
    }
}
