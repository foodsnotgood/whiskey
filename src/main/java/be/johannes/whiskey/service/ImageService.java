package be.johannes.whiskey.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Component
public class ImageService {

    public String saveImageFromUrl(String urlOfImage) throws Exception {
        Path imageDirectory = Paths.get("uploads");
        if (!Files.exists(imageDirectory)) {
            Files.createDirectories(imageDirectory);
        }
        try {
            String newFilePath = imageDirectory.toString() + "/" + RandomString.make(5) + LocalDateTime.now().hashCode() + ".jpg";
            URL url = new URL(urlOfImage);
            ImageIO.write(getBufferedImageFrom(url), "jpg", new File(newFilePath));
            return newFilePath;
        } catch (Exception e) {
            throw new Exception("Could not save image file");
        }
    }

    private BufferedImage getBufferedImageFrom(URL url) throws IOException {
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new IOException("Could not retreive image from " + url);
        }
    }

    private BufferedImage getBufferedImageFrom(String path) throws IOException {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new IOException("Could not retreive image from " + path);
        }
    }
}
