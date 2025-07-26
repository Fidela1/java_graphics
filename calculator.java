import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class calculator {
    public static void main(String [] args){
        JFrame frame = new JFrame("Swing Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);

        Container cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());

        JTextField tfDisplay = new JTextField("0");
        tfDisplay.setEditable(false);
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        cp.add(tfDisplay, BorderLayout.NORTH);


        JPanel panelButtons = new JPanel(new GridLayout(4, 4, 5, 5));
        cp.add(panelButtons, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "C", "0", "=", "/"
        };

        final String[] current = {""};            
        final double[] result = {0};             
        final String[] previousOperator = {""};  
        final boolean[] isFirst = {true};         

        ActionListener numberListener = e -> {
            String cmd = e.getActionCommand();  
            current[0] += cmd;                 
            tfDisplay.setText(current[0]);      
        };

       
        ActionListener operatorListener = e -> {
            String cmd = e.getActionCommand(); 

            if (!current[0].isEmpty()) {
                double number = Double.parseDouble(current[0]);

                if (isFirst[0]) {
                    result[0] = number;  
                    isFirst[0] = false;
                } else {
                    
                    switch (previousOperator[0]) {
                        case "+": result[0] += number; break;
                        case "-": result[0] -= number; break;
                        case "*": result[0] *= number; break;
                        case "/": result[0] = number != 0 ? result[0] / number : 0; break;
                        case "%": result[0] %= number; break;
                    }
                }

                tfDisplay.setText(String.valueOf(result[0]));
                current[0] = ""; 
            }

            previousOperator[0] = cmd; 
        };

     
        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
            panelButtons.add(btn);

            if (label.matches("\\d")) {
                btn.addActionListener(numberListener); 
            } else if (label.equals("+") || label.equals("-") ||
                       label.equals("*") || label.equals("/") || label.equals("%") || label.equals("=")) {
                btn.addActionListener(operatorListener);
            } else if (label.equals("C")) {
             
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        current[0] = "";
                        result[0] = 0;
                        previousOperator[0] = "";
                        isFirst[0] = true;
                        tfDisplay.setText("");
                    }
                });
            }
        }

        frame.setVisible(true);
     }
}