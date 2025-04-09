import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class imageGenerator {
    public static void generate(Person person) {
        int width = 500, height = 300;
        BufferedImage card = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = card.createGraphics();

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Border
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, width - 20, height - 20);

        // Image
        try {
            BufferedImage photo = ImageIO.read(new File(person.getImagePath()));
            Image resized = photo.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
            g.drawImage(resized, 20, 40, null);
        } catch (IOException e) {
            System.out.println("Image not found.");
        }

        // Text Info
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        int x = 140, y = 50;
        g.drawString("Name: " + person.getName(), x, y);
        g.drawString("Age: " + person.getAge(), x, y + 20);
        g.drawString("Dept: " + person.getDepartment(), x, y + 40);
        g.drawString("Joined: " + person.getYear(), x, y + 60);
        g.drawString("Blood Group: " + person.getBloodGroup(), x, y + 80);
        g.drawString("Mobile: " + person.getMobile(), x, y + 100);
        g.drawString("Address: " + person.getAddress(), x, y + 120);

        g.dispose();

        // Save as image
        try {
            File output = new File("generated_id.png");
            ImageIO.write(card, "png", output);
            System.out.println("ID Card generated: " + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
