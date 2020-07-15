package al.tct.javafinal;

 import java.io.Serializable;
public class Account implements Serializable {

    protected String id;
    protected String password;
    protected String user;
    protected String name;
    protected Double amount;

    public Account() {
    }

    public Account(String id, String password,String user, String name, Double amount) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public void Deposite(double b){
        this.amount+=b;
    }
    public void Withdraw(double b){
        if(this.amount>=Math.abs(b)){
            this.amount -= Math.abs(b);}
    }
    
    
}
