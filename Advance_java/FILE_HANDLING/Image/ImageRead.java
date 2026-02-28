package Image;
import java.io.*;

public class ImageRead {
    public static void main(String[] args) {
        String path="Image/copied.png";
        try(FileInputStream fs= new FileInputStream(path)){
            int size=0;
            while (fs.read()!=-1){
                size++;
            }
            System.out.println("Image read succesfullly");
            System.out.println("Image Size: "+size+" bytes");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
