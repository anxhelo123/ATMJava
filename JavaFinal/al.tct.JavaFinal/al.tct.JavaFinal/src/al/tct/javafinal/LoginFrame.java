package al.tct.javafinal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class LoginFrame extends JFrame {

    private static final int WIDTH = 220;
    private static final int HEIGHT = 130;

    private JPanel panel;
    private JPasswordField passField;
    private JLabel username;
    private JLabel password;
    private JTextField userField;
    private JButton loginButton;
    ArrayList<Account> ac1;
    ArrayList<Account> ac2;
    Account acc = new Account();
    Account acc2 = new Account();
    boolean chc = true;
    LoginFrame lf1;
    public LoginFrame() {
        setProperties();
        init();
        setUI();
    }
    public void setframe(LoginFrame lf1){
        this.lf1=lf1;
    }
    private void setProperties() {
        setSize(WIDTH, HEIGHT);
        setTitle("Account Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        panel = new JPanel(new FlowLayout());
        passField = new JPasswordField(10);
        passField.setEditable(true);
        username = new JLabel("Username");
        password = new JLabel("Password");
        userField = new JTextField(10);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pin = passField.getText();
                Bank bank = new Bank();
                ac1 = bank.getBalance();
                for (int c = 0; c < ac1.size(); c++) {
                    acc = ac1.get(c);
                    if (acc.getUser().equals(user) && acc.getPassword().equals(pin)) {
                        UserFrame uf = new UserFrame(ac1,c);
                        uf.setframe(uf);
                        uf.setVisible(true);
                        lf1.setVisible(false);
                        chc = false;
                    }
                }
                if (chc == true) {
                    /*Bank bank2 = new Bank();
                    ac2 = bank2.getBalance();
                            String id="0002";
                            String name = "lame";
                            Double balance1 = 0.0;
                            acc2 = new Account(id,pin, user,  name, balance1);
                            ac2 = bank2.getBalance();
                            ac2.add(acc2);
                            Bank.prtoFIle(ac2);*/
                        JOptionPane.showMessageDialog(panel, "Inputet jan gabim");
                    
                }
            }
        });
    }
    private void setUI() {
        panel.add(username);
        panel.add(userField);
        panel.add(password);
        panel.add(passField);
        panel.add(loginButton);
        add(panel);
    }
}
