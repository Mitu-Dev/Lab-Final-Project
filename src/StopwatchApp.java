import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JComboBox<String> comboBox;
    private JRadioButton radioButton;
    private JCheckBox checkBox;
    private JPanel mainPanel;

    private Timer timer;
    private long elapsedTime;
    private boolean isRunning;

    public StopwatchApp() {
        setTitle("Stopwatch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.WHITE);
        timeLabel = new JLabel("00:00:00.000");
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 32));
        timePanel.add(timeLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.WHITE);
        comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        radioButton = new JRadioButton("Enable Timer");
        checkBox = new JCheckBox("Show Timer");
        optionsPanel.add(comboBox);
        optionsPanel.add(radioButton);
        optionsPanel.add(checkBox);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(timePanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(optionsPanel);
        mainPanel.add(Box.createVerticalGlue());

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    timeLabel.setVisible(true);
                } else {
                    timeLabel.setVisible(false);
                }
            }
        });

        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    startButton.setEnabled(true);
                    stopButton.setEnabled(true);
                    resetButton.setEnabled(true);
                } else {
                    startButton.setEnabled(false);
                    stopButton.setEnabled(false);
                    resetButton.setEnabled(false);
                }
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Selected Option: " + selectedOption);
            }
        });

        add(mainPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        // Set the default state of the checkbox and radiobutton
        radioButton.setSelected(true);
        checkBox.setSelected(true);
    }

    private void start() {
        if (!isRunning) {
            timer = new Timer(1, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    elapsedTime++;
                    updateTime();
                }
            });

            timer.start();
            isRunning = true;
        }
    }

    private void stop() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
    }

    private void reset() {
        stop();
        elapsedTime = 0;
        updateTime();
    }

    private void updateTime() {
        long hours = elapsedTime / 3600000;
        long minutes = (elapsedTime % 3600000) / 60000;
        long seconds = (elapsedTime % 60000) / 1000;
        long milliseconds = elapsedTime % 1000;

        String time = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StopwatchApp();
            }
        });
    }
}
