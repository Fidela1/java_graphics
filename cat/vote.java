import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class vote {
    public static void main(String [] args){
        JFrame main_frame = new JFrame("Main Frame");
        main_frame.setSize(500,500);
        main_frame.setLayout(null);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menubar = new JMenuBar();
        main_frame.setJMenuBar(menubar);
     

        JMenu file = new JMenu("File");
        menubar.add(file);

        JMenu open = new JMenu("Open");
        file.add(open);

        JMenuItem votingFormItem = new JMenuItem("Voting Form");
        open.add(votingFormItem);

        votingFormItem.addActionListener((ActionEvent e ) -> {
            voting_form vote = new voting_form();
        });
        main_frame.setVisible(true);

    }
}

class voting_form extends JFrame{
    public voting_form(){
        setTitle("Voting Form");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JLabel lblTitle = new JLabel("Vote for Your Candidate");
        lblTitle.setBounds(120, 10, 200, 30);
        add(lblTitle);

      JPanel radioPanel = new JPanel();
radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
radioPanel.setBounds(50, 50, 300, 30);

JRadioButton rb1 = new JRadioButton("Candidate A");
JRadioButton rb2 = new JRadioButton("Candidate B");
JRadioButton rb3 = new JRadioButton("Candidate C");

ButtonGroup group = new ButtonGroup();
group.add(rb1);
group.add(rb2);
group.add(rb3);

radioPanel.add(rb1);
radioPanel.add(rb2);
radioPanel.add(rb3);

add(radioPanel);

        JButton btnVote = new JButton("Vote");
        btnVote.setBounds(260, 90, 100, 30);
        JButton btnNext = new JButton("Next Voter");
        btnNext.setBounds(260, 130, 100, 30);
        JButton btnResults = new JButton("Results");
        btnResults.setBounds(260, 170, 100, 30);
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(260, 210, 100, 30);

        add(btnVote);
        add(btnNext);
        add(btnResults);
        add(btnExit);

        JTextArea txtResults = new JTextArea();
        txtResults.setBounds(50, 180, 190, 70);
        txtResults.setEditable(false);
        add(txtResults);

        // Vote counters
        final int[] votes = {0, 0, 0}; // A, B, C

        btnVote.addActionListener(e -> {
            if (rb1.isSelected()) votes[0]++;
            else if (rb2.isSelected()) votes[1]++;
            else if (rb3.isSelected()) votes[2]++;
            else JOptionPane.showMessageDialog(null, "Please select a candidate.");
        });

        btnNext.addActionListener(e -> group.clearSelection());

        btnResults.addActionListener(e -> {
            String winner = "";
            int maxVotes = Math.max(votes[0], Math.max(votes[1], votes[2]));

            if (votes[0] == maxVotes && votes[0] != votes[1] && votes[0] != votes[2]) {
                winner = "Candidate A";
            } else if (votes[1] == maxVotes && votes[1] != votes[0] && votes[1] != votes[2]) {
                winner = "Candidate B";
            } else if (votes[2] == maxVotes && votes[2] != votes[0] && votes[2] != votes[1]) {
                winner = "Candidate C";
            } else {
                winner = "Tie";
            }

            txtResults.setText(
                "Votes:\nA: " + votes[0] +
                "\nB: " + votes[1] +
                "\nC: " + votes[2] +
                "\nWinner: " + winner
            );
        });

        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
