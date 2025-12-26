// Student Records
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class student {
    public static void main(String [] args){
        JFrame frame = new JFrame("Student Record");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

     
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 500, 350);
        
        frame.add(panel);

        
        JLabel lblTerm1 = new JLabel("First Term Marks :");
        lblTerm1.setBounds(20, 30, 120, 20);
        panel.add(lblTerm1);

        JTextField txtTerm1 = new JTextField();
        txtTerm1.setBounds(150, 30, 100, 20);
        panel.add(txtTerm1);

        JLabel lblStream = new JLabel("Stream");
        lblStream.setBounds(270, 20, 80, 20);
        panel.add(lblStream);

        JRadioButton rbMedical = new JRadioButton("Medical");
        rbMedical.setBounds(270, 40, 80, 20);
        JRadioButton rbNonMedical = new JRadioButton("Non-Medical");
        rbNonMedical.setBounds(270, 60, 100, 20);
        ButtonGroup bgStream = new ButtonGroup();
        bgStream.add(rbMedical);
        bgStream.add(rbNonMedical);
        panel.add(rbMedical);
        panel.add(rbNonMedical);

        JLabel lblTerm2 = new JLabel("Second Term Marks :");
        lblTerm2.setBounds(20, 60, 130, 20);
        panel.add(lblTerm2);

        JTextField txtTerm2 = new JTextField();
        txtTerm2.setBounds(150, 60, 100, 20);
        panel.add(txtTerm2);

        JLabel lblPerc = new JLabel("Percentage :");
        lblPerc.setBounds(20, 90, 100, 20);
        panel.add(lblPerc);

        JTextField txtPercentage = new JTextField();
        txtPercentage.setBounds(150, 90, 100, 20);
        txtPercentage.setEditable(false);
        panel.add(txtPercentage);

        JButton btnCalcPerc = new JButton("Calculate Percentage");
        btnCalcPerc.setBounds(260, 90, 150, 20);
        panel.add(btnCalcPerc);

        JLabel lblGrade = new JLabel("Grade :");
        lblGrade.setBounds(20, 120, 100, 20);
        panel.add(lblGrade);

        JTextField txtGrade = new JTextField();
        txtGrade.setBounds(150, 120, 100, 20);
        txtGrade.setEditable(false);
        panel.add(txtGrade);

        JButton btnCalcGrade = new JButton("Calculate Grade");
        btnCalcGrade.setBounds(260, 130, 150, 20);
        panel.add(btnCalcGrade);

    
        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(80, 170, 80, 25);
        panel.add(btnClear);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(180, 170, 80, 25);
        panel.add(btnExit);

    
        btnCalcPerc.addActionListener(e -> {
            try {
                int m1 = Integer.parseInt(txtTerm1.getText());
                int m2 = Integer.parseInt(txtTerm2.getText());
                double perc = (m1 + m2) / 2.0;
                txtPercentage.setText(String.format("%.2f", perc));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enter valid marks");
            }
        });

        btnCalcGrade.addActionListener(e -> {
            try {
                double perc = Double.parseDouble(txtPercentage.getText());
                String grade = "Fail";
                if (rbMedical.isSelected()) {
                    if (perc >= 80) grade = "A";
                    else if (perc >= 60 && perc < 80) grade = "B";
                    else if (perc < 60) grade = "C";
                } else if (rbNonMedical.isSelected()) {
                    if (perc >= 75) grade = "A";
                    else if (perc >= 50 && perc < 75) grade = "B";
                    else if (perc < 550) grade = "C";
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a stream!");
                    return;
                }
                txtGrade.setText(grade);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Calculate percentage first!");
            }
        });

        btnClear.addActionListener(e -> {
            txtTerm1.setText("");
            txtTerm2.setText("");
            txtPercentage.setText("");
            txtGrade.setText("");
            bgStream.clearSelection();
        });

        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?");
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        frame.setVisible(true);

    }
}
