import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class SwingProject extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel idLabel;
    private JTextField idTextField;
    private JLabel cityLabel;
    private JRadioButton sylhetRadioButton;
    private JRadioButton dhakaRadioButton;
    private JRadioButton comillaRadioButton;
    private JRadioButton chittagongRadioButton;
    private ButtonGroup cityButtonGroup;
    private JLabel seasonLabel;
    private JCheckBox summerCheckBox;
    private JCheckBox winterCheckBox;
    private JCheckBox rainyCheckBox;
    private JCheckBox autumnCheckBox;
    private JCheckBox springCheckBox;
    private JButton submitButton;
    private ImageIcon image;

    public SwingProject() {
        // Set up the JFrame
        setTitle("Swing Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        int desiredHeight = 1000; // Set desired height to 1000 pixels
        setSize(600, desiredHeight);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Initialize the components
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        idLabel = new JLabel("ID:");
        idTextField = new JTextField(10);
        cityLabel = new JLabel("What city do you live in?");
        sylhetRadioButton = new JRadioButton("Sylhet");
        dhakaRadioButton = new JRadioButton("Dhaka");
        comillaRadioButton = new JRadioButton("Comilla");
        chittagongRadioButton = new JRadioButton("Chittagong");
        cityButtonGroup = new ButtonGroup();
        cityButtonGroup.add(sylhetRadioButton);
        cityButtonGroup.add(dhakaRadioButton);
        cityButtonGroup.add(comillaRadioButton);
        cityButtonGroup.add(chittagongRadioButton);
        seasonLabel = new JLabel("What is your favorite season?");
        summerCheckBox = new JCheckBox("Summer");
        winterCheckBox = new JCheckBox("Winter");
        rainyCheckBox = new JCheckBox("Rainy");
        autumnCheckBox = new JCheckBox("Autumn");
        springCheckBox = new JCheckBox("Spring");
        submitButton = new JButton("Submit");

        // Load the image from the URL and set its size
        try {
            URL imageUrl = new URL("https://images.unsplash.com/photo-1682688759157-57988e10ffa8" +
                    "?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80");
            Image loadedImage = ImageIO.read(imageUrl);
            image = new ImageIcon(loadedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add components to the JFrame using GridBagLayout
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(idLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(idTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(cityLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(sylhetRadioButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        add(dhakaRadioButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(comillaRadioButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        add(chittagongRadioButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(seasonLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(summerCheckBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        add(winterCheckBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(rainyCheckBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        add(autumnCheckBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(springCheckBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        add(new JLabel(image), constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(submitButton, constraints);

        // Add an action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String id = idTextField.getText();
                String city = "";
                if (sylhetRadioButton.isSelected()) {
                    city = "Sylhet";
                } else if (dhakaRadioButton.isSelected()) {
                    city = "Dhaka";
                } else if (comillaRadioButton.isSelected()) {
                    city = "Comilla";
                } else if (chittagongRadioButton.isSelected()) {
                    city = "Chittagong";
                }
                StringBuilder season = new StringBuilder();
                if (summerCheckBox.isSelected()) {
                    season.append("Summer, ");
                }
                if (winterCheckBox.isSelected()) {
                    season.append("Winter, ");
                }
                if (rainyCheckBox.isSelected()) {
                    season.append("Rainy, ");
                }
                if (autumnCheckBox.isSelected()) {
                    season.append("Autumn, ");
                }
                if (springCheckBox.isSelected()) {
                    season.append("Spring");
                }
                String message = "Name: " + name + "\nID: " + id + "\nCity: " + city + "\nFavorite Season: " + season.toString();
                JOptionPane.showMessageDialog(SwingProject.this, message);
            }
        });

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingProject();
            }
        });
    }
}
