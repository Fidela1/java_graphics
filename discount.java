
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class discount {
    public static void main(String[] args) {
        
        JFrame discount_frame = new JFrame("Glamour Garments");
        discount_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        discount_frame.setSize(400, 300);
        discount_frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name of Customer");
        nameLabel.setBounds(20,20,150,25);
        JTextField nametextField = new JTextField();
        nametextField.setBounds(150,20,100,25);

        JLabel billLabel = new JLabel("Bill Amount");
        billLabel.setBounds(20,60,150,25);
        JTextField billtextField = new JTextField();
        billtextField.setBounds(150,60,100,25);

        JLabel paymentLabel = new JLabel("Mode of Payment");
        paymentLabel.setBounds(20,100,150,25);

        String [] payment = {"Cash", "Cheque","Credit Cards"};
        JComboBox<String> comboBox = new JComboBox<>(payment);
        comboBox.setBounds(150,100,100,25);



        JLabel discountLabel = new JLabel("Discount");
        discountLabel.setBounds(20,190,150,25);
        JTextField discounttextField = new JTextField();
        discounttextField.setBounds(150,190,100,25);
        discounttextField.setEditable(false);

        JLabel amountLabel = new JLabel("Net Amount");
        amountLabel.setBounds(20,230,150,25);
        JTextField amounttextField = new JTextField();
        amounttextField.setBounds(150,230,100,25);
        amounttextField.setEditable(false);


        JButton discountButton = new JButton("Calculate Discount");
        discountButton.setBounds(20,150,150,25);
        discountButton.addActionListener((ActionEvent e) ->{
            int billAmount;
            String method;
            int discount =0 ;
            billAmount = Integer.parseInt(billtextField.getText());
            method = (String) comboBox.getSelectedItem();



            if(method.equalsIgnoreCase("cash")){
                discount +=8;
            }
            else if(method.equalsIgnoreCase("cheque")) {
                discount +=7;
            }
            else if(method.equalsIgnoreCase("Credit Cards")) {
                discount =0;
            }

            if(billAmount > 15000){
                discount +=10;
            }

            int discountAmount = billAmount * discount/100;
            discounttextField.setText(""+discountAmount);




        });

        JButton amountButton = new JButton("Calculate Net Amount");
        amountButton.setBounds(190,150,180,25);

        amountButton.addActionListener((ActionEvent e) ->{
            int billAmount;
            String method;
            int discount =0 ;
            billAmount = Integer.parseInt(billtextField.getText());
            method = (String) comboBox.getSelectedItem();



            if(method.equalsIgnoreCase("cash")){
                discount +=8;
            }
            else if(method.equalsIgnoreCase("cheque")) {
                discount +=7;
            }
            else if(method.equalsIgnoreCase("Credit Cards")) {
                discount =0;
            }

            if(billAmount > 15000){
                discount +=10;
            }

            int discountAmount = billAmount * discount/100;

            int netAmount = billAmount - discountAmount;
            amounttextField.setText(""+netAmount);

        });
        JButton stopButton = new JButton("STOP");
        stopButton.setBounds(250,270,100,25);

        stopButton.addActionListener((ActionEvent e) ->{
            discount_frame.dispose();
        });
        discount_frame.add(nameLabel);
        discount_frame.add(nametextField);
        discount_frame.add(billLabel);
        discount_frame.add(billtextField);
        discount_frame.add(paymentLabel);
        discount_frame.add(comboBox);
        discount_frame.add(discountButton);
        discount_frame.add(amountButton);
        discount_frame.add(discountLabel);
        discount_frame.add(discounttextField);
        discount_frame.add(amountLabel);
        discount_frame.add(amounttextField);
        discount_frame.add(stopButton);

discount_frame.setVisible(true);

    }
}
