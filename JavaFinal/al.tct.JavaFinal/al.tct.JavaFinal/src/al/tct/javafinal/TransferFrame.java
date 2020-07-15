package al.tct.javafinal;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TransferFrame extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private JPanel panel;
    private JLabel label;
    private JTextField id;
    private JLabel label1;
    private JTextField funds;
    private JButton transferButton;
    ArrayList<Account> usacl;
    private int index;
    Account acc = new Account();
    UserFrame usfr;
    TransferFrame tf;

    public TransferFrame(ArrayList<Account> ac, int in) {
        this.usacl = ac;
        this.index = in;
        this.acc = usacl.get(index);
        setProperties();
        init();
        setUI();
    }

    public void setframe(UserFrame lf1, TransferFrame depfr) {
        this.usfr = lf1;
        this.tf = depfr;
    }

    private void setProperties() {
        setSize(WIDTH, HEIGHT);
        setTitle("Transfer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        panel = new JPanel(new FlowLayout());
        label = new JLabel("Shkruani ID ku deshironi te transferoni fondet");
        label1 = new JLabel("Shkruani fondet qe do transferoni");
        id = new JTextField(20);
        funds = new JTextField(20);
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double ente=Double.parseDouble(funds.getText());
                String id3 = id.getText();
                ///////////
                if (usacl.get(index).getId().equals(id3)==false) {
                    for (int x = 0; x < usacl.size(); x++) {
                        if (usacl.get(x).getId().equals(id3)) {
                            usacl.get(x).Deposite(ente);
                            usacl.get(index).Withdraw(ente);
                            Bank.prtoFIle(usacl);
                            JOptionPane.showMessageDialog(panel, "Transaksioni u krye");
                            usfr.dispose();
                            tf.dispose();
                            Bank nbank = new Bank();
                            ArrayList<Account> usacl1 = nbank.getBalance();
                            UserFrame usfr1 = new UserFrame(usacl1, index);
                            usfr1.setframe(usfr1);
                            usfr1.setVisible(true);
                            
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(panel, "Transaksioni nuk u krye, kontrrolloni te dhenat");
                }
            }
        });
    }

    private void setUI() {
        panel.add(label);
        panel.add(id);
        panel.add(label1);
        panel.add(funds);
        panel.add(transferButton);
        add(panel);
    }
}
