package al.tct.javafinal;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class UserFrame extends JFrame {

     private static final int WIDTH = 300;
    private static final int HEIGHT = 100;
    
    private JPanel panel;
    private JLabel currentFunds;
    private JTextField fundField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    ArrayList<Account> usacl;
    private int index;
    Account acc = new Account();
    UserFrame usfr;
    public UserFrame(ArrayList<Account> ac,int in){
        this.usacl = ac;
        this.index= in;
        this.acc=usacl.get(index);
        setProperties();
        init();
        setUI();
    }
    public void setframe(UserFrame lf1){
        this.usfr=lf1;
    }
    private void setProperties(){
       setSize(WIDTH, HEIGHT);
        setTitle("Account");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    private void init(){
        panel = new JPanel(new FlowLayout());
        currentFunds = new JLabel("Your Funds are: ");
       
        fundField = new JTextField(10);
        fundField.setText(Double.toString(acc.getAmount()));
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositFrame df = new DepositFrame(usacl,index);
                df.setframe(usfr, df);
                df.setVisible(true);
            }
        });
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawFrame wf = new WithdrawFrame(usacl,index);
                wf.setframe(usfr, wf);
                wf.setVisible(true);
            }
        });
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferFrame trfr = new TransferFrame(usacl, index);
                trfr.setframe(usfr, trfr);
                trfr.setVisible(true);
            }
        });
        
    }
    private void setUI(){
        panel.add(currentFunds);
        panel.add(fundField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(transferButton);
        
        add(panel);
    }
}
