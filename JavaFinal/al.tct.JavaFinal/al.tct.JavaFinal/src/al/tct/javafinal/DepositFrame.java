package al.tct.javafinal;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DepositFrame extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 100;

    private JPanel panel;
    private JTextField funds;
    private JButton depositButton;
    ArrayList<Account> usacl;
    private int index;
    Account acc = new Account();
    UserFrame usfr;
    DepositFrame depfr;
    public DepositFrame(ArrayList<Account> ac,int in) {
        this.usacl = ac;
        this.index= in;
        this.acc=usacl.get(index);
        setProperties();
        init();
        setUI();
    }
    public void setframe(UserFrame lf1,DepositFrame depfr){
        this.usfr=lf1;
        this.depfr=depfr;
    }
    private void setProperties() {
        setSize(WIDTH, HEIGHT);
        setTitle("Deposit");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        panel = new JPanel(new FlowLayout());
        funds = new JTextField(20);
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double fundsss = Double.parseDouble(funds.getText());
                usacl.get(index).Deposite(fundsss);
                Bank.prtoFIle(usacl);
                JOptionPane.showMessageDialog(panel, "Depozitimi u krye");
                usfr.dispose();
                depfr.dispose();
                Bank nbank = new Bank();
                ArrayList<Account> usacl1 = nbank.getBalance();
                UserFrame usfr2 =new UserFrame(usacl1,index);
                usfr2.setframe(usfr2);
                usfr2.setVisible(true);
                
            }
        });
    }

    private void setUI() {
        panel.add(funds);
        panel.add(depositButton);

        add(panel);
    }
}
