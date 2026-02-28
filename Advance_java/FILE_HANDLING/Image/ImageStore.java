package Image;
import java.io.*;

public class ImageStore {
    public static void main(String[] args) {
        String sourcePath = "E:/coding/CapgeminiJava/src/Image/im1.jpg";
        String destinationPath = "E:/coding/CapgeminiJava/src/Image/copies.jpg";

        try {
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fis.close();
            fos.close();

            System.out.println("Image Stored Successfully");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
