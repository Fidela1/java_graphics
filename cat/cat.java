import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class cat {
      public static void main(String[] args) {
      
        JFrame loginFrame=new JFrame("Login Form");


        JLabel username_label=new JLabel("Username:");
        JTextField username_field=new JTextField();
        JLabel password_label=new JLabel("Password:");
        JTextField password_field=new JTextField();
        JButton connect_button=new JButton("Connect");
        JButton cancel_button=new JButton("Cancel");


        username_label.setBounds(50,50,200,25);
        username_field.setBounds(140,50,200,25);
        password_label.setBounds(50,80,200,25);
        password_field.setBounds(140,80,200,25);
        connect_button.setBounds(50,120,140,25);
        cancel_button.setBounds(200,120,140,25);
        connect_button.setBackground(Color.lightGray);
        cancel_button.setBackground(Color.lightGray);

        cancel_button.addActionListener((ActionEvent e) ->{
                          loginFrame.dispose();
                    });

        loginFrame.add(username_label);
        loginFrame.add(username_field);
        loginFrame.add(password_label);
        loginFrame.add(password_field);
        loginFrame.add(connect_button);
        loginFrame.add(cancel_button);
        connect_button.addActionListener((ActionEvent logging)->{
            if(username_field.getText().isEmpty() || password_field.getText().isEmpty()){
                JOptionPane.showMessageDialog(loginFrame,"All fields must be filled");
            }
            else{
                if(username_field.getText().equals("admin") ||username_field.getText().equals("Admin") && password_field.getText().equals("123")){
                    JFrame landingPage=new JFrame("Main Form");


                    JMenuBar menuBar=new JMenuBar();
                    landingPage.setJMenuBar(menuBar);


                    JMenu file=new JMenu("File");
                    JMenu view=new JMenu("View");
                    JMenu edit=new JMenu("Edit");
                    JMenu help=new JMenu("Help");


                    JMenuItem anew=new JMenuItem("New");
                    JMenu open=new JMenu("Open");
                    JMenuItem exit=new JMenuItem("Exit");

                    

                    exit.addActionListener((ActionEvent e) ->{
                      System.exit(0);
                    });

                    

                    JMenuItem pos_neg=new JMenuItem("Check Pos & Neg");
                    JMenuItem sum_avg=new JMenuItem("Find Sum & Average");
                    JMenuItem per_gra=new JMenuItem("Find % and Grade");
                    JMenuItem payment_method=new JMenuItem("Payment mode");
                    JMenuItem companys=new JMenuItem("Company");
                    JMenuItem StudentGrading=new JMenuItem("Student Grading");
                    JMenuItem ElectrogazBilling=new JMenuItem("Electrogaz Billing");




                    open.add(pos_neg);
                    open.add(sum_avg);
                    open.add(per_gra);
                    open.add(payment_method);
                    open.add(companys);
                    open.add(StudentGrading);
                    open.add(ElectrogazBilling);


                    pos_neg.addActionListener((ActionEvent posNeg)->{
                        pos_neg form=new pos_neg();
                    });
                    sum_avg.addActionListener((ActionEvent sumAvg)->{
                        sum_avg form=new sum_avg();
                    });
                    per_gra.addActionListener((ActionEvent perGra)->{
                        per_gra form=new per_gra();
                    });
                    payment_method.addActionListener((ActionEvent pay_mode )->{
                        payment_method form=new payment_method();
                    });
                    companys.addActionListener((ActionEvent manufacture )->{
                        companys form=new companys();
                    });
                    StudentGrading.addActionListener((ActionEvent grading )->{
                        StudentGrading form=new StudentGrading();
                    });
                    ElectrogazBilling.addActionListener((ActionEvent electrogaze )->{
                        ElectrogazBilling form=new ElectrogazBilling();
                    });
                    


                    file.add(anew);
                    file.add(open);
                    file.add(help);
                    file.add(exit);


                    menuBar.add(file);
                    menuBar.add(view);
                    menuBar.add(edit);
                    menuBar.add(help);


                    landingPage.setSize(600,600);
                    landingPage.setLayout(null);
                    landingPage.setVisible(true);
                    loginFrame.setVisible(false);

                }
                else{
                    JOptionPane.showMessageDialog(loginFrame,"Invalid Username or Password");
                }
            }

        });


        loginFrame.setSize(400,300);
        loginFrame.setLayout(null);
        loginFrame.getContentPane().setBackground(Color.cyan);
        loginFrame.setVisible(true);
    }

}

class pos_neg extends JFrame{
    public pos_neg(){
        JFrame pos_neg=new JFrame("Checking positive negative");


        JLabel number_label=new JLabel("Enter any number:");
        JTextField number_field=new JTextField();
        JLabel result_label=new JLabel("Positive/Negative:");
        JTextField result_field =new JTextField();
        JButton check_pos_neg=new JButton("Check");


        number_label.setBounds(50,100,200,25);
        number_field.setBounds(180,100,180,25);
        result_label.setBounds(50,135,200,25);
        result_field.setBounds(180,130,180,40);
        check_pos_neg.setBounds(100,175,200,25);


        pos_neg.add(number_label);
        pos_neg.add(number_field);
        pos_neg.add(result_label);
        pos_neg.add(result_field);
        pos_neg.add(check_pos_neg);


        check_pos_neg.addActionListener((ActionEvent checking)->{
            int num;
            num=Integer.parseInt(number_field.getText());
            if(num > 0){
                result_field.setText("Number is positive");
            }
            else if(num < 0){
                result_field.setText("Number is Negative");
            }
            else{
                result_field.setText("Number is Zero");
            }
        });


        pos_neg.setSize(400,300);
        pos_neg.setLayout(null);
        pos_neg.setVisible(true);
    }

}
class sum_avg extends JFrame {
    public sum_avg() {
        JFrame sum_avg = new JFrame("Calculate sum and average");

        JLabel number1_label = new JLabel("Number 1");
        JTextField number1_field = new JTextField();
        JLabel number2_label = new JLabel("Number 2");
        JTextField number2_field = new JTextField();
        JLabel sum_label = new JLabel("Sum");
        JTextField sum_field = new JTextField();
        JLabel avg_label = new JLabel("Avg");
        JTextField avg_field = new JTextField();

        JButton addition = new JButton("Add");
        addition.addActionListener((ActionEvent e) -> {
            int num1, num2, sum;
            num1 = Integer.parseInt(number1_field.getText());
            num2 = Integer.parseInt(number2_field.getText());

            sum = num1 + num2;
            sum_field.setText("Sum: " + sum);

        });
        JButton average = new JButton("Avg");
        average.addActionListener((ActionEvent e) -> {
            int num1, num2, sum, avg;
            num1 = Integer.parseInt(number1_field.getText());
            num2 = Integer.parseInt(number2_field.getText());

            sum = num1 + num2;
            avg = sum / 2;
            avg_field.setText("Average: " + avg);

        });
        JButton exit=new JButton("Exit");
        exit.addActionListener((ActionEvent e)->{
            sum_avg.dispose();
        });

        number1_label.setBounds(50, 100, 200, 25);
        number1_field.setBounds(180, 100, 180, 25);
        number2_label.setBounds(50, 135, 200, 25);
        number2_field.setBounds(180, 135, 180, 25);
        sum_label.setBounds(50, 170, 200, 25);
        sum_field.setBounds(180, 170, 180, 25);
        avg_label.setBounds(50, 205, 200, 25);
        avg_field.setBounds(180, 205, 180, 25);
        addition.setBounds(100, 245, 100, 25);
        average.setBounds(250, 245, 100, 25);
        exit.setBounds(400, 245, 100, 25);


        sum_avg.add(number1_label);
        sum_avg.add(number1_field);
        sum_avg.add(number2_label);
        sum_avg.add(number2_field);
        sum_avg.add(sum_label);
        sum_avg.add(sum_field);
        sum_avg.add(avg_label);
        sum_avg.add(avg_field);
        sum_avg.add(addition);
        sum_avg.add(average);
        sum_avg.add(exit);

        sum_avg.setSize(600, 500);
        sum_avg.setLayout(null);
        sum_avg.setVisible(true);
    }
}
class per_gra extends JFrame {
       
    public per_gra() {
        JFrame per_gra = new JFrame("Grade");

        per_gra.setSize(600, 500);
        per_gra.setLayout(null);
        per_gra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 JTextField[] marks_field;
   

    String[] subjects = {"Management", "Accounting", "C++"};
   
    
        marks_field = new JTextField[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            JLabel marks_label = new JLabel(subjects[i] + ":");
            marks_label.setBounds(50, 20 + i * 30, 120, 25);
            per_gra.add(marks_label);
              marks_field[i] = new JTextField();
            marks_field[i].setBounds(180, 20 + i * 30, 250, 25);
            per_gra.add(marks_field[i]);
        }

        JLabel sum_label = new JLabel("Sum");
        JTextField sum_field = new JTextField();
        JLabel avg_label = new JLabel("Avg");
        JTextField avg_field = new JTextField();
        JLabel percent_label = new JLabel("Percentage");
        JTextField percent_field = new JTextField();

        JLabel grade_label = new JLabel("Grade");
        JTextField grade_field = new JTextField();
        JButton check=new JButton("Check");

        sum_label.setBounds(50, 135, 200, 25);
        sum_field.setBounds(180, 135, 180, 25);
        avg_label.setBounds(50, 170, 200, 25);
        avg_field.setBounds(180, 170, 180, 25);
        percent_label.setBounds(50, 205, 200, 25);
        percent_field.setBounds(180, 205, 180, 25);
        grade_label.setBounds(50, 240, 200, 25);
        grade_field.setBounds(180, 240, 180, 25);

        check.setBounds(140, 275, 100, 25);

        check.addActionListener((ActionEvent e) ->{

            int sum = 0,avg,percent;
            char grade;
          for (int i = 0; i < subjects.length; i++) {
              int marks = Integer.parseInt(marks_field[i].getText());

              sum += marks;
              avg = sum/subjects.length;
              percent = (sum * 100)/300;

              sum_field.setText(""+sum);
               avg_field.setText(""+avg);
               percent_field.setText(""+percent);

               if(avg > 50){
                grade = 'A';

               }
               else{
                grade = 'F';
               }

               grade_field.setText(""+grade);
          }
        });

    
        per_gra.add(sum_label);
        per_gra.add(sum_field);
        per_gra.add(avg_label);
        per_gra.add(avg_field);
        per_gra.add(percent_label);
        per_gra.add(percent_field);
        per_gra.add(grade_label);
        per_gra.add(grade_field);
        per_gra.add(check);
        
            
        per_gra.setVisible(true);
    }
}
class payment_method extends JFrame {
    public payment_method(){
        JFrame frame = new JFrame("Glamour Garments");
        frame.setSize(600,800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JLabel amountLabel = new JLabel("Net Amount");
        amountLabel.setBounds(20,230,150,25);
        JTextField amounttextField = new JTextField();
        amounttextField.setBounds(150,230,100,25);

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
            frame.dispose();
        });
        frame.add(nameLabel);
        frame.add(nametextField);
        frame.add(billLabel);
        frame.add(billtextField);
        frame.add(paymentLabel);
        frame.add(comboBox);
        frame.add(discountButton);
        frame.add(amountButton);
        frame.add(discountLabel);
        frame.add(discounttextField);
        frame.add(amountLabel);
        frame.add(amounttextField);
        frame.add(stopButton);



        frame.setVisible(true);

    }
}
class companys extends JFrame {
    public companys(){
       setTitle("Gikondo Salary Calculator");
            setSize(600, 500);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> departmentBox;
         JTextField salaryField;

            JLabel deptLabel = new JLabel("Department:");
            deptLabel.setBounds(30, 30, 100, 25);
            add(deptLabel);

            departmentBox = new JComboBox<>(new String[]{"Cooking Oil", "Soap"});
            departmentBox.setBounds(150, 30, 150, 25);
            add(departmentBox);

            JLabel salaryLabel = new JLabel("Basic Salary:");
            salaryLabel.setBounds(30, 70, 100, 25);
            add(salaryLabel);

            salaryField = new JTextField();
            salaryField.setBounds(150, 70, 150, 25);
            add(salaryField);

            JButton calculateButton = new JButton("Calculate");
            calculateButton.setBounds(100, 110, 120, 30);
            add(calculateButton);

        JLabel taLabel = new JLabel("TA:");
        taLabel.setBounds(30, 150, 100, 25);
        JTextField taField = new JTextField();
        taField.setBounds(150, 150, 150, 25);
        add(taLabel);
        add(taField);

        JLabel hrLabel = new JLabel("HR:");
        hrLabel.setBounds(30, 190, 100, 25);
        JTextField hrField = new JTextField();
        hrField.setBounds(150, 190, 150, 25);
        add(hrLabel);
        add(hrField);

        JLabel upkeepLabel = new JLabel("Upkeep:");
        upkeepLabel.setBounds(30, 230, 100, 25);
        JTextField upkeepField = new JTextField();
        upkeepField.setBounds(150, 230, 150, 25);
        add(upkeepLabel);
        add(upkeepField);

        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setBounds(30, 270, 100, 25);
        JTextField totalField = new JTextField();
        totalField.setBounds(150, 270, 150, 25);
        add(totalLabel);
        add(totalField);




            calculateButton.addActionListener((ActionEvent e) -> {
                
                    String dept = (String) departmentBox.getSelectedItem();
                    double basic = Double.parseDouble(salaryField.getText());
                    double ta = 0, hra = 0, upkeep = 0;
                    if (dept.equals("Cooking Oil")) {
                        if (basic >= 5000) {
                            ta = 1.10 * basic;
                            hra = 0.20 * basic;
                            upkeep = 500;
                        } else if (basic >= 3000) {
                            ta = 1.00 * basic;
                            hra = 0.15 * basic;
                            upkeep = 400;
                        } else {
                            ta = 0.90 * basic;
                            hra = 0.10 * basic;
                            upkeep = 300;
                        }
                    } else if (dept.equals("Soap")) {
                        if (basic >= 5000) {
                            ta = 1.00 * basic;
                            hra = 0.10 * basic;
                            upkeep = 300;
                        } else if (basic >= 3000) {
                            ta = 0.90 * basic;
                            hra = 0.10 * basic;
                            upkeep = 200;
                        } else {
                            ta = 0.70 * basic;
                            hra = 0.05 * basic;
                            upkeep = 100;
                        }
                    }

                    double total = ta + hra + upkeep;
                   
                    taField.setText(""+ta);
                    hrField.setText(""+hra);
                    upkeepField.setText(""+upkeep);
                    totalField.setText(""+total);


                
            });

            setVisible(true);
        }
 
      }
class StudentGrading extends JFrame {

    JTextField idField;
    JTextField[] internalFields, externalFields;
    JTextArea resultArea;

    String[] internalSubjects = {"Management", "Accounting", "C++", "Geography", "Economics"};
    String[] externalSubjects = {"Political Science", "General Knowledge", "Oral"};

    public StudentGrading() {
        setTitle("Student Grading System");
        setSize(450, 850);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(20, 20, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 20, 250, 25);
        add(idField);

        JLabel internalLabel = new JLabel("Internal Exams:");
        internalLabel.setBounds(20, 60, 200, 25);
        add(internalLabel);

        internalFields = new JTextField[internalSubjects.length];
        for (int i = 0; i < internalSubjects.length; i++) {
            JLabel label = new JLabel(internalSubjects[i] + ":");
            label.setBounds(20, 90 + i * 30, 120, 25);
            add(label);

            internalFields[i] = new JTextField();
            internalFields[i].setBounds(140, 90 + i * 30, 250, 25);
            add(internalFields[i]);
        }

        JLabel externalLabel = new JLabel("External Exams:");
        externalLabel.setBounds(20, 270, 200, 25);
        add(externalLabel);

        externalFields = new JTextField[externalSubjects.length];
        for (int i = 0; i < externalSubjects.length; i++) {
            JLabel label = new JLabel(externalSubjects[i] + ":");
            label.setBounds(20, 300 + i * 30, 120, 25);
            add(label);

            externalFields[i] = new JTextField();
            externalFields[i].setBounds(140, 300 + i * 30, 250, 25);
            add(externalFields[i]);
        }

        JButton calculateBtn = new JButton("Calculate ");
        calculateBtn.setBounds(100, 410, 180, 30);
        add(calculateBtn);
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(200, 410, 180, 30);
        add(clearBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 460, 400, 400);
        resultArea.setEditable(false);
        add(resultArea);

        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });

      
        setVisible(true);
    }

    private void calculateGrades() {
        int totalMarks = 0;
        int subjectCount = internalSubjects.length + externalSubjects.length;
        String result = "";

        result = result + "ID: " + idField.getText() + "\n\n";

        result = result + "Internal Grades:\n";
        for (int i = 0; i < internalSubjects.length; i++) {
            int mark = Integer.parseInt(internalFields[i].getText());
            totalMarks += mark;
            result = result + internalSubjects[i] + ": " + mark + " - " + getInternalGrade(mark) + "\n";
        }

        result = result + "\nExternal Grades:\n";
        for (int i = 0; i < externalSubjects.length; i++) {
            int mark = Integer.parseInt(externalFields[i].getText());
            totalMarks += mark;
            result = result + externalSubjects[i] + ": " + mark + " - " + getExternalGrade(mark) + "\n";
        }

        double average = totalMarks / (double) subjectCount;
        result = result + "\nTotal Marks: " + totalMarks;
        result = result + "\nAverage: " + String.format("%.2f", average);

        resultArea.setText(result);
    }

    private String getInternalGrade(int mark) {
        if (mark >= 80) return "A";
        else if (mark >= 70) return "B";
        else if (mark >= 60) return "C";
        else if (mark >= 50) return "D";
        else if (mark >= 40) return "E";
        else return "F";
    }

    private String getExternalGrade(int mark) {
        if (mark >= 80) return "A";
        else if (mark >= 60) return "B";
        else if (mark >= 50) return "C";
        else if (mark >= 40) return "D";
        else if (mark >= 30) return "E";
        else return "F";
    }

  
}
class ElectrogazBilling extends JFrame {
JComboBox<String> serviceBox;
    JTextField unitsField, regField;
    JTextArea resultArea;

    public ElectrogazBilling() {
        setTitle("Electrogaz Billing System");
        setSize(450, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel regLabel = new JLabel("Registration No:");
        regLabel.setBounds(20, 20, 150, 25);
        add(regLabel);

        regField = new JTextField();
        regField.setBounds(180, 20, 200, 25);
        add(regField);

        JLabel serviceLabel = new JLabel("Select Service:");
        serviceLabel.setBounds(20, 60, 150, 25);
        add(serviceLabel);

        serviceBox = new JComboBox<>(new String[]{"Water", "Electricity"});
        serviceBox.setBounds(180, 60, 200, 25);
        add(serviceBox);

        JLabel unitsLabel = new JLabel("Units Consumed:");
        unitsLabel.setBounds(20, 100, 150, 25);
        add(unitsLabel);

        unitsField = new JTextField();
        unitsField.setBounds(180, 100, 200, 25);
        add(unitsField);

        JButton calcBtn = new JButton("Calculate Bill");
        calcBtn.setBounds(100, 140, 130, 30);
        add(calcBtn);

        
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(270, 140, 130, 30);
        add(clearBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 190, 400, 150);
        resultArea.setEditable(false);
        add(resultArea);

        calcBtn.addActionListener((ActionEvent e) ->{
           
                calculateBill();
            
        });

        setVisible(true);
          clearBtn.addActionListener((ActionEvent e) ->{
      regField.setText("");
      unitsField.setText("");
      resultArea.setText("");
      
    });
    }

  
    void calculateBill() {
        String regNo = regField.getText();
        String service = (String) serviceBox.getSelectedItem();
        int units = Integer.parseInt(unitsField.getText());

        double chargePerUnit = 0;
        double baseCharge = 0;
        double extraCharge = 0;
        double serviceCharge = 0;
        double total = 0;

        if (service.equals("Water")) {
            if (units <= 500)
                chargePerUnit = 100;
            else if (units <= 1000)
                chargePerUnit = 150;
            else if (units <= 1500)
                chargePerUnit = 200;
            else
                chargePerUnit = 250;

            baseCharge = units * chargePerUnit;

            if (baseCharge < 30) baseCharge = 30;
            if (baseCharge > 1000) extraCharge = baseCharge * 0.20;

            serviceCharge = 300;
        } else {
            if (units <= 100)
                chargePerUnit = 60;
            else if (units <= 200)
                chargePerUnit = 80;
            else if (units <= 300)
                chargePerUnit = 90;
            else
                chargePerUnit = 120;

            baseCharge = units * chargePerUnit;

            if (baseCharge < 100) baseCharge = 100;
            if (baseCharge > 500) extraCharge = baseCharge * 0.15;

            serviceCharge = 100;
        }

        total = baseCharge + extraCharge + serviceCharge;

        String result = "Registration No: " + regNo + "\n";
        result += "Service: " + service + "\n";
        result += "Units Consumed: " + units + "\n";
        result += "Charge per Unit: $" + chargePerUnit + "\n";
        result += "Base Charge: $" + baseCharge + "\n";
        result += "Extra Charge: $" + extraCharge + "\n";
        result += "Service Charge: $" + serviceCharge + "\n";
        result += "Total Amount to Pay: $" + total;

        resultArea.setText(result);
    }

  
}