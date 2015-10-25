package android_project.com.doctorassistant;

/**
 * Created by Tejas on 5/10/15.
 */
public class Patient_DBinfo {

    int pid;
    String pname , pemail, pcontact, pgender, pdob, pnotes, padderss;


    public void setId(int pid)
    {
        this.pid = pid;
    }
    public int getId()
    {
        return this.pid;
    }

    public void setName(String pname) {
        this.pname = pname;
    }
    public String getName(){
        return this.pname;
    }


    public void setAddress(String paddress) {
        this.padderss = paddress;
    }
    public String getAddress(){
        return this.padderss;
    }

    public void setContact(String pcontact) {
        this.pcontact = pcontact;
    }
    public String getContact(){
        return this.pcontact;
    }

    public void setEmail(String pemail) {
        this.pemail = pemail;
    }
    public String getEmail(){
        return this.pemail;
    }


    public void setGender(String pgender) {
        this.pgender = pgender;
    }
    public String getGender(){
        return this.pgender;
    }

    public void setDOB(String pdob) {
        this.pdob = pdob;
    }
    public String getDOB(){
        return this.pdob;
    }


    public void setNotes(String pnotes) {
        this.pnotes = pnotes;
    }
    public String getNotes(){
        return this.pnotes;
    }
}
