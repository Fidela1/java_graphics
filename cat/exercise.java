import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class exercise {
   public static void main(String[] args){
    
            JFrame createuser_frame = new JFrame("Create user form");
    createuser_frame.setSize(500,400);
    createuser_frame.setLayout(null);
    createuser_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    JLabel name_label = new JLabel("Name");
    JTextField name_field = new JTextField();
     JLabel username_label = new JLabel("Username");
    JTextField username_field = new JTextField();
    JLabel pass_label = new JLabel("Password");
    JTextField pass_field = new JTextField();
    JLabel tel_label = new JLabel("Telephone");
    JTextField tel_field = new JTextField();
    JButton createuser_btn = new JButton("Create user");
    JButton exit_btn = new JButton("Exit");


    name_label.setBounds(20,20,150,25);
    name_field.setBounds(120,20,150,25);
    username_label.setBounds(20,60,150,25);
    username_field.setBounds(120,60,150,25);
    pass_label.setBounds(20,100,150,25);
    pass_field.setBounds(120,100,150,25);
    tel_label.setBounds(20,140,150,25);
    tel_field.setBounds(120,140,150,25);
    createuser_btn.setBounds(60,200,130,25);
    exit_btn.setBounds(240,200,130,25);

    createuser_btn.addActionListener((ActionEvent e) -> {

          Connection con1;
    PreparedStatement insert;
    String name = name_field.getText();
    String username = username_field.getText();
    String password = pass_field.getText();
    String tel = tel_field.getText();
    
    try 
    {
   
        Class.forName("com.mysql.cj.jdbc.Driver");
        con1 = DriverManager.getConnection
        
        ("jdbc:mysql://localhost/payroll", "root", "");
         insert = con1.prepareStatement("SELECT * FROM user WHERE username = ?");
            insert.setString(1, username);
           ResultSet rs = insert.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User already registered!");
            } else {
      
        insert = con1.prepareStatement("INSERT INTO user (Name, Username, Password, Telephone) VALUES (?, ?, ?, ?)");
      

        insert.setString(1, name);
        insert.setString(2, username);
        insert.setString(3, password);
        insert.setString(4, tel);

        int row = insert.executeUpdate();
       
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"All fields must be filled");
                }
                    else if(row > 0){
                    JOptionPane.showMessageDialog(null, "User is registered");
                    login_form login = new login_form();
                } else {
                    JOptionPane.showMessageDialog(null, "User is not registered.");
                }

        
        insert.close();
        con1.close();
    } 
}
    catch (ClassNotFoundException | SQLException ex) {
        
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    
}  
    });

     exit_btn.addActionListener((ActionEvent e) ->{

        int result = JOptionPane.showConfirmDialog(
                    createuser_frame,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);  
                }
                   
                    });
    createuser_frame.add(name_label);
    createuser_frame.add(name_field);
    createuser_frame.add(username_label);
    createuser_frame.add(username_field);
    createuser_frame.add(pass_label);
    createuser_frame.add(pass_field);
    createuser_frame.add(tel_label);
    createuser_frame.add(tel_field);
    createuser_frame.add(createuser_btn);
    createuser_frame.add(exit_btn);
    createuser_frame.setVisible(true);

       } 
}

    class login_form extends JFrame{
        public login_form(){

            JFrame login_frame = new JFrame("Login Form");
    login_frame.setSize(400,300);
    login_frame.setLayout(null);
    login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    JLabel name_label = new JLabel("Username");
    JTextField name_field = new JTextField();
    JLabel pass_label = new JLabel("Password");
    JTextField pass_field = new JTextField();
    JButton login_btn = new JButton("Login");
    JButton exit_btn = new JButton("Exit");


    name_label.setBounds(20,60,150,25);
    name_field.setBounds(120,60,150,25);
    pass_label.setBounds(20,120,150,25);
    pass_field.setBounds(120,120,150,25);
    login_btn.setBounds(60,180,100,25);
    exit_btn.setBounds(180,180,100,25);

    login_frame.add(name_label);
    login_frame.add(name_field);
    login_frame.add(pass_label);
    login_frame.add(pass_field);
    login_frame.add(login_btn);
    login_frame.add(exit_btn);

    login_btn.addActionListener((ActionEvent e) ->{

       Connection con1;
        String username = name_field.getText();
        String password = new String(pass_field.getText());


      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       
        con1 = DriverManager.getConnection
        ("jdbc:mysql://localhost/payroll", "root", "");
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = con1.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(login_frame, "Login Successful!");
                 mainForm main = new mainForm();
            } else {
                JOptionPane.showMessageDialog(login_frame, "You are not registered");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(login_frame, "Error connecting to database");
        }
       
    
    });
exit_btn.addActionListener((ActionEvent e) ->{

        int result = JOptionPane.showConfirmDialog(
                    login_frame,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);  
                }
                   
                    });
    login_frame.setVisible(true);
        }
    }
    


class mainForm extends JFrame{
    public mainForm(){

        setTitle("Main form");
        setSize(500,400);
        setVisible(true);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu menu_opt = new JMenu("Options");
        menubar.add(menu_opt);
        JMenu salary = new JMenu("Salary");
        menubar.add(salary);

        JMenu display_menu = new JMenu("Display");
        menu_opt.add(display_menu);
        JMenuItem calc_salary = new JMenuItem("Calculate");
        salary.add(calc_salary);

        JMenuItem employee_form = new JMenuItem("Employee");
        display_menu.add(employee_form);

        calc_salary.addActionListener((ActionEvent e) -> {

            salary_form form = new salary_form();
        });
         

    }
}

class salary_form extends JFrame{
    public salary_form(){
         setTitle("Calculate Salary");
        setSize(500,400);
        setLayout(null);
        setVisible(true);

        JLabel empid_label = new JLabel("Employee ID");
        JTextField empid_field = new JTextField();
        JLabel empname_label = new JLabel("Employee name");
        JTextField empname_field = new JTextField();
        JLabel year_label = new JLabel("Year name");
        JTextField year_field = new JTextField();
        JLabel salary_label = new JLabel("Salary");
        JTextField salary_field = new JTextField();
        JLabel allowance_label = new JLabel("Allowance");
        JTextField allowance_field = new JTextField();
        JLabel gross_label = new JLabel("Gross");
        JTextField gross_field = new JTextField();
        JLabel deduction_label = new JLabel("Deduction");
        JTextField deduction_field = new JTextField();
        JLabel netpay_label = new JLabel("Net pay");
        JTextField netpay_field = new JTextField();
        JButton calc_btn = new JButton("Calculate");
        JButton save_btn = new JButton("Save");
        JButton edit_btn = new JButton("Edit");
        JButton delete_btn = new JButton("Delete");


        empid_label.setBounds(20,20,100,25);
        empid_field.setBounds(120,20,120,25);
        empname_label.setBounds(20,60,100,25);
        empname_field.setBounds(120,60,120,25);
        year_label.setBounds(20,100,100,25);
        year_field.setBounds(120,100,120,25);
        salary_label.setBounds(20,140,100,25);
        salary_field.setBounds(120,140,120,25);
        allowance_label.setBounds(20,180,100,25);
        allowance_field.setBounds(120,180,120,25);
        gross_label.setBounds(20,220,100,25);
        gross_field.setBounds(120,220,120,25);
        deduction_label.setBounds(20,260,100,25);
        deduction_field.setBounds(120,260,120,25);
        netpay_label.setBounds(20,300,100,25);
        netpay_field.setBounds(120,300,120,25);
        calc_btn.setBounds(100,340,100,25);
        save_btn.setBounds(250,340,100,25);
        edit_btn.setBounds(350,340,100,25);
        delete_btn.setBounds(450,340,100,25);

        calc_btn.addActionListener((ActionEvent e) -> {

            double allowance,gross,deduct,netpay;
            double salary = Double.parseDouble(salary_field.getText());

            allowance = salary * 0.05;
            gross = salary + allowance;
            deduct = salary * 0.1;
            netpay = gross - deduct;

            allowance_field.setText(""+allowance);
            gross_field.setText(""+gross);
            deduction_field.setText(""+deduct);
            netpay_field.setText(""+netpay);
            

        });

        save_btn.addActionListener((ActionEvent e) -> {

            Connection con1;
    PreparedStatement insert;
    //Reads user input from GUI JTextFields.
    int empid = Integer.parseInt(empid_field.getText());
    String empname = empname_field.getText();
    String year = year_field.getText();
    double salary = Double.parseDouble(salary_field.getText());
    double allo = Double.parseDouble(allowance_field.getText());
    double gross = Double.parseDouble(gross_field.getText());
    double deduct = Double.parseDouble(deduction_field.getText());
    double netpay = Double.parseDouble(netpay_field.getText());
    try 
    {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to the database
        con1 = DriverManager.getConnection
        ("jdbc:mysql://localhost/payroll", "root", "");
        // Prepare SQL insert with placeholders
        insert = con1.prepareStatement("INSERT INTO employee (Emp_ID, Emp_name, Year, Salary, Allowance, Gross,Deduction,Net_pay) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
        // Set values from text fields
        insert.setInt(1, empid);
        insert.setString(2, empname);
        insert.setString(3, year);
        insert.setDouble(4, salary);
        insert.setDouble(5, allo);
        insert.setDouble(6, gross);
        insert.setDouble(7, deduct);
        insert.setDouble(8, netpay);
        
        insert.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Record well inserted");
        
        insert.close();
        con1.close();
    } 
    catch (ClassNotFoundException | SQLException ex) {
        
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
        });
        edit_btn.addActionListener((ActionEvent e) -> {

            Connection con1;
   
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to the database
        con1 = DriverManager.getConnection
        ("jdbc:mysql://localhost/payroll", "root", "");
     
                String sql = "UPDATE employee SET Emp_name=? WHERE Emp_ID=?";
                PreparedStatement stmt = con1.prepareStatement(sql);
                stmt.setString(1, empname_field.getText());
                stmt.setInt(2, Integer.parseInt(empid_field.getText()));

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Record Updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "No record found.");
                }

                stmt.close();
                con1.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });
        
        delete_btn.addActionListener((ActionEvent e) -> {
            Connection con1;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to the database
        con1 = DriverManager.getConnection
        ("jdbc:mysql://localhost/payroll", "root", "");
        String sql = "DELETE FROM employee WHERE Emp_ID=?";
        PreparedStatement stmt = con1.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(empid_field.getText())); // assuming idField contains Emp_ID

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        } else {
            JOptionPane.showMessageDialog(null, "No record found with that ID.");
        }

        stmt.close();
        con1.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
        });
        add(empid_label);
        add(empid_field);
        add(empname_label);
        add(empname_field);
        add(year_label);
        add(year_field);
        add(salary_label);
        add(salary_field);
        add(allowance_label);
        add(allowance_field);
        add(gross_label);
        add(gross_field);
        add(deduction_label);
        add(deduction_field);
        add(netpay_label);
        add(netpay_field);
        add(calc_btn);
        add(save_btn);
        add(edit_btn);
        add(delete_btn);


    }
}
