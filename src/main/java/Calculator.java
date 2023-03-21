import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            ".", "0", "=", "/",
            "x!", "x^y", "sqrt", "ln"
    };

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        // Add text field for input and display
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        // Add number pad buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();

        // Handle number pad input
        if (label.matches("\\d") || label.equals(".")) {
            textField.setText(textField.getText() + label);
        } else {
            // Parse input number
            double num = Double.parseDouble(textField.getText());

            // Perform selected operation
            switch (label) {
                case "+":
                    textField.setText("");
                    textField.setText(String.valueOf(num + Double.parseDouble(textField.getText())));
                    break;
                case "-":
                    textField.setText("");
                    textField.setText(String.valueOf(num - Double.parseDouble(textField.getText())));
                    break;
                case "*":
                    textField.setText("");
                    textField.setText(String.valueOf(num * Double.parseDouble(textField.getText())));
                    break;
                case "/":
                    textField.setText("");
                    textField.setText(String.valueOf(num / Double.parseDouble(textField.getText())));
                    break;
                case "x!":
                    textField.setText("");
                    textField.setText(String.valueOf(factorial(num)));
                    break;
                case "x^y":
                    textField.setText("");
                    textField.setText(String.valueOf(Math.pow(num, Double.parseDouble(textField.getText()))));
                    break;
                case "sqrt":
                    textField.setText("");
                    textField.setText(String.valueOf(Math.sqrt(num)));
                    break;
                case "ln":
                    textField.setText("");
                    textField.setText(String.valueOf(Math.log(num)));
                    break;
                case "=":
                    // Do nothing
                    break;
                default:
                    // Do nothing
                    break;
            }
        }
    }

    public static double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
