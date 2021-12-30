package be.johannes.whiskey.service;

import net.bytebuddy.utility.RandomString;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDateTime;

public class ImageSaveService {

    public static String saveImageFromUrl(String urlOfImage) throws Exception {
        try {
            URL url = new URL(urlOfImage);
            InputStream input = url.openStream();
            String fileName = "src/main/resources/static/images/" + RandomString.make(5) + LocalDateTime.now().hashCode() + ".jpg";
            OutputStream output = new FileOutputStream(fileName);

            byte[] byteArray = new byte[2048];
            int length;

            while ((length = input.read(byteArray)) != -1) {
                output.write(byteArray, 0, length);
            }

            input.close();
            output.close();

            return fileName;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return null;
    }
}
