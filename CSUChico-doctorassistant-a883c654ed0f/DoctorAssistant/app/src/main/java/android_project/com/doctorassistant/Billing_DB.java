package android_project.com.doctorassistant;

/**
 * Created by Tejas on 5/12/15.
 */
public class Billing_DB {


    int b_id;
    String bill_pid, amount ,bill_date;


    public void setId(int id){
        this.b_id = b_id;
    }
    public int getId(){
        return this.b_id;
    }

    public void setBillpid(String bill_pid) {
        this.bill_pid = bill_pid;
    }
    public String getBillpid(){
        return this.bill_pid;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAmount(){ return this.amount;}

    public void setUserBilldate(String bill_date) {
        this.bill_date = bill_date;
    }
    public String getBilldate(){
        return this.bill_date;
    }

}
