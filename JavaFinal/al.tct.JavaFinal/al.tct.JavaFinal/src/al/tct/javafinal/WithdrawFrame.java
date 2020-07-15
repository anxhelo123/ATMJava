package al.tct.javafinal;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class WithdrawFrame extends JFrame{
 private static final int WIDTH = 300;
 private static final int HEIGHT = 100;
 
  private JPanel panel;
  private JTextField funds;
  private JButton withdrawButton;
  ArrayList<Account> usacl;
    private int index;
    Account acc = new Account();
    UserFrame usfr;
    WithdrawFrame wf;
  public WithdrawFrame(ArrayList<Account> ac,int in){
      this.usacl = ac;
        this.index= in;
        this.acc=usacl.get(index);
        setProperties();
        init();
        setUI();
  }  
   private void setProperties(){
         setSize(WIDTH, HEIGHT);
        setTitle("Withdraw");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
   public void setframe(UserFrame lf1,WithdrawFrame depfr){
        this.usfr=lf1;
        this.wf=depfr;
    }
    private void init(){
        panel = new JPanel(new FlowLayout());
        funds = new JTextField(20);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double fundsss = Double.parseDouble(funds.getText());
                usacl.get(index).Withdraw(fundsss);
                Bank.prtoFIle(usacl);
                JOptionPane.showMessageDialog(panel, "Terheqja u krye");
                usfr.dispose();
                wf.dispose();
                Bank nbank = new Bank();
                ArrayList<Account> usacl1 = nbank.getBalance();
                UserFrame usfr1 =new UserFrame(usacl1,index);
                usfr1.setframe(usfr1);
                usfr1.setVisible(true);
                
            }
        });
    }
    private void setUI(){
       panel.add(funds);
       panel.add(withdrawButton);
       add(panel);
    }
  
}
