package android_project.com.doctorassistant;

/**
 * Created by Tejas on 5/10/15.
 */
public class Appointment_db {



    int id;
    String app_id ,app_name, app_reason, app_contact, app_date;


    public void setId(int id){
       this.id = id;
    }
    public int getId(){
        return this.id;
    }


    public void setPatientID(String app_id) {
        this.app_id = app_id;
    }
    public String getPatientID(){
        return this.app_id;
    }

    public void setPatient_Name(String app_name) {this.app_name = app_name; }
    public String getPatient_Name(){
        return this.app_name;
    }

    public void setPatient_reason(String app_reason) {
        this.app_reason = app_reason;
    }
    public String getPatient_reason(){
        return this.app_reason;
    }

    public void setPatient_contact(String app_contact) {
        this.app_contact = app_contact;
    }
    public String getPatient_contact(){return this.app_contact;}

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }
    public String getApp_date(){return this.app_date;}



}
