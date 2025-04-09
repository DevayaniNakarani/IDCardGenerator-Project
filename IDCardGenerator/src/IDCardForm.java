import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class IDCardForm extends JFrame {
    JTextField nameField, ageField, deptField, yearField, bloodField, addressField, mobileField;
    JLabel imageLabel;
    String imagePath = "";

    public IDCardForm() {
        setTitle("ID Card Generator");
        setLayout(new GridLayout(10, 2, 5, 5));
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameField = new JTextField();
        ageField = new JTextField();
        deptField = new JTextField();
        yearField = new JTextField();
        bloodField = new JTextField();
        addressField = new JTextField();
        mobileField = new JTextField();
        imageLabel = new JLabel("No Image Selected");

        JButton uploadButton = new JButton("Upload Photo");
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imagePath = file.getAbsolutePath();
                imageLabel.setText(file.getName());
            }
        });

        JButton generateButton = new JButton("Generate ID Card");
        generateButton.addActionListener(e -> {
            Person p = new Person(
                nameField.getText(), ageField.getText(), deptField.getText(),
                yearField.getText(), bloodField.getText(), addressField.getText(),
                mobileField.getText(), imagePath
            );
            imageGenerator.generate(p);
        });

        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Age:")); add(ageField);
        add(new JLabel("Department:")); add(deptField);
        add(new JLabel("Year of Joining:")); add(yearField);
        add(new JLabel("Blood Group:")); add(bloodField);
        add(new JLabel("Address:")); add(addressField);
        add(new JLabel("Mobile Number:")); add(mobileField);
        add(uploadButton); add(imageLabel);
        add(generateButton);

        setVisible(true);
    }
}
