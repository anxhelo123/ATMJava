package al.tct.javafinal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {

    String emri;
    ArrayList<Account> ac = new ArrayList<Account>();

    public Bank() {
        try {
            FileInputStream file = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            try {
                ac = (ArrayList) in.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
            in.close();
            file.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Account> getBalance() {
        return ac;
    }
    
     public void addAccount(Account anAccount) {
        this.ac.add(anAccount);
    }
     public void removeAccount(long id) {
        Account toBeRemoved = null;

        for (Account acc : this.ac) {
            if (acc.getId().equals(id)) {
                toBeRemoved = acc;
                break;
            }
        }

        if (toBeRemoved != null) {
            this.ac.remove(toBeRemoved);
        }
    }
  

    public static void prtoFIle(ArrayList<Account> b) {
        try {
            FileOutputStream file1 = new FileOutputStream("data.ser");
            ObjectOutputStream pr = new ObjectOutputStream(file1);
            pr.writeObject(b);
            pr.close();
            file1.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
