import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inputField, outputField;
    private JButton factorialButton, sqrtButton, powerButton, logButton;

    public Calculator() {
        super("Calculator");

        // create the input and output fields
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        // create the buttons
        factorialButton = new JButton("Factorial");
        sqrtButton = new JButton("Square Root");
        powerButton = new JButton("Power");
        logButton = new JButton("Natural Log");

        // add action listeners to the buttons
        factorialButton.addActionListener(this);
        sqrtButton.addActionListener(this);
        powerButton.addActionListener(this);
        logButton.addActionListener(this);

        // create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter a number:"));
        inputPanel.add(inputField);

        // create the output panel
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Result:"));
        outputPanel.add(outputField);

        // create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(factorialButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(logButton);

        // add the panels to the frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(inputPanel);
        contentPane.add(buttonPanel);
        contentPane.add(outputPanel);

        // set the size and show the frame
        setSize(300, 200);
        setVisible(true);
    }

    // handle button clicks
    public void actionPerformed(ActionEvent event) {
        try {
            // get the input number
            double input = Double.parseDouble(inputField.getText());

            // calculate and display the result
            if (event.getSource() == factorialButton) {
                long result = factorial((int)input);
                outputField.setText(Long.toString(result));
            } else if (event.getSource() == sqrtButton) {
                double result = Math.sqrt(input);
                outputField.setText(Double.toString(result));
            } else if (event.getSource() == powerButton) {
                double result = Math.pow(input, 2);
                outputField.setText(Double.toString(result));
            } else if (event.getSource() == logButton) {
                double result = Math.log(input);
                outputField.setText(Double.toString(result));
            }
        } catch (NumberFormatException e) {
            // display an error message if the input is not a number
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    // calculate the factorial of a number
    private long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
