package CreateWrite;
import java.io.*;
public class FileDemo {
    public static void main(String[] args) {
        // create
        File folder = new File("data");

        if(!folder.exists()) {
            boolean created = folder.mkdir();

            if(created) {
                System.out.println("Folder created successfully");
            } else {
                System.out.println("Folder creation failed");
            }
        } else {
            System.out.println("Folder already exists");
        }
    }
}
