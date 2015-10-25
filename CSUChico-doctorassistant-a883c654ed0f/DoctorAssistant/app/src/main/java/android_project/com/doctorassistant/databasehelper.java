package android_project.com.doctorassistant;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tejas on 4/25/15.
 */
public class databasehelper extends SQLiteOpenHelper {




    Context context;
    Cursor cursor;
    //doctor database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "APP_DBfinalf";

    private static final String TABLE_NAME = "docinfo";
    private static final String TABLE_NAME2 = "patientinfo";
    private static final String TABLE_NAME3 = "appointment_info";
    private static final String TABLE_NAME4 = "billinginfo";



    private static final String COLUMN_ID = "id";
    private static final String COLUMN_name = "name";
    private static final String COLUMN_email = "email";
    private static final String COLUMN_username = "username";
    private static final String COLUMN_password = "password";


    //patient datatbase addpatient

   //private static final int DATABASE_VERSION = 1;
   // private static final String DATABASE_NAME = "patientinfo.db";

    private static final String COLUMN_pid = "pid";
    private static final String COLUMN_pname = "pname";
    private static final String COLUMN_pemail = "pemail";
    private static final String COLUMN_paddress = "paddress";
    private static final String COLUMN_pcontact = "pcontact";
    private static final String COLUMN_pgender = "pgender";
    private static final String COLUMN_pdob = "pdob";
    private static final String COLUMN_pnotes = "pnotes";



    //appointment database app_id ,app_name, app_reason, app_contact, app_date;

    private static final String COLUMN_aid = "aid";
    private static final String COLUMN_app_id = "app_id";
    private static final String COLUMN_app_name = "app_name";
    private static final String COLUMN_app_reason = "app_reason";
    private static final String COLUMN_app_contact = "app_contact";
    private static final String COLUMN_app_date = "app_date";

//appointment table
    private static final String COLUMN_b_id = "b_id";
    private static final String COLUMN_bill_pid_ = "bill_pid";
    private static final String COLUMN_amount = "amount";
    private static final String COLUMN_bill_date = "bill_date";


    SQLiteDatabase db;



    private static final String TABLE_CREATE = "create table docinfo (id integer primary key AUTOINCREMENT not null ,"+
            "name text not null ,email text not null ,username text not null ,password text not null);";


   private static final String TABLE_C = "create table patientinfo" + "(pid integer primary key AUTOINCREMENT not null ,"+
            "pname text not null ,pemail text not null ,paddress text not null ,pcontact int not null ," +
            "pgender text not null ,pdob date not null ,pnotes text not null)";



    private static final String TABLE_A = "create table appointment_info (aid integer primary key AUTOINCREMENT not null ,"+
            "app_id text not null ,app_name text not null ,app_reason text not null ,app_contact text not null,app_date text not null);";



    private static final String TABLE_B = "create table billinginfo (b_id integer primary key AUTOINCREMENT not null ,"+
            "bill_pid text not null ,amount text not null ,bill_date txt not null);";


    public databasehelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


    try {

        //Only create table queries to be executed here
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_C);
        db.execSQL(TABLE_A);
        db.execSQL(TABLE_B);
    }
    catch (SQLException e)
        {
                e.printStackTrace();
        }

    }


    //database insert table for doctor
    public void insert(userinfo c){

        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from docinfo";
       Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();
//app_id ,app_name, app_reason, app_contact, app_date;
        values.put(COLUMN_ID, count);

        values.put(COLUMN_name, c.getName());
        values.put(COLUMN_email, c.getEmail());
        values.put(COLUMN_username, c.getUsername());
        values.put(COLUMN_password, c.getPassword());


        db.insert(TABLE_NAME, null, values);
    }

    //database for insert patient



   public void insert2(Patient_DBinfo c1){

       db = getWritableDatabase();
       ContentValues values = new ContentValues();

       String query = "select * from patientinfo";
       Cursor cursor = db.rawQuery(query, null);

       int count = cursor.getCount();

       values.put(COLUMN_pid, count);
       values.put(COLUMN_pname, c1.getName());
       values.put(COLUMN_pemail, c1.getEmail());
       values.put(COLUMN_paddress, c1.getAddress());
       values.put(COLUMN_pcontact, c1.getContact());
       values.put(COLUMN_pgender, c1.getGender());
       values.put(COLUMN_pdob, c1.getDOB());
       values.put(COLUMN_pnotes, c1.getNotes());

       db.insert(TABLE_NAME2, null, values);

   }

    public void insert3(Appointment_db c2){

        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from appointment_info";
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        values.put(COLUMN_aid, count);

        values.put(COLUMN_app_id, c2.getPatientID());
        values.put(COLUMN_app_name, c2.getPatient_Name());
        values.put(COLUMN_app_reason, c2.getPatient_reason());
        values.put(COLUMN_app_contact, c2.getPatient_contact());
        values.put(COLUMN_app_date, c2.getApp_date());

        db.insert(TABLE_NAME3, null, values);
    }

//billing


    public void insert4(Billing_DB c4){

        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from billinginfo";
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        values.put(COLUMN_b_id, count);

        values.put(COLUMN_bill_pid_, c4.getBillpid());
        values.put(COLUMN_amount, c4.getAmount());
        values.put(COLUMN_bill_date, c4.getBilldate());


        db.insert(TABLE_NAME4, null, values);
    }

    //appointment info update

    public void updateData(String a1, String a2, String a3, String a4, String a5){

        db=getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put(COLUMN_app_id,a1);
        data.put(COLUMN_app_name,a2);
        data.put(COLUMN_app_reason,a3);
        data.put(COLUMN_app_contact,a4);
        data.put(COLUMN_app_date,a5);

        //String where = "COLUMN_app_id=a1";

        db.update(TABLE_NAME3,data, "app_id=" + a1,null);


       // db.update(TABLE_NAME3, data, "app_id=" + a1,"app_name=" +a2,"app_reason=" +a3,"app_contact=" +a4,"app_name=" +a5);

    }



    //update patient data

    public void updatePatientData(String p1, String p2, String p3, String p4, String p5,String p6,String p7,String p8){

        db=getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put(COLUMN_pname,p1);
        data.put(COLUMN_paddress,p2);
        data.put(COLUMN_pcontact,p3);
        data.put(COLUMN_pemail,p4);
        data.put(COLUMN_pgender,p5);
        data.put(COLUMN_pdob,p6);
        data.put(COLUMN_pnotes,p7);

        //String where = "COLUMN_app_id=a1";

        db.update(TABLE_NAME2,data, "pid=" + p8,null);


        // db.update(TABLE_NAME3, data, "app_id=" + a1,"app_name=" +a2,"app_reason=" +a3,"app_contact=" +a4,"app_name=" +a5);

    }










    public String searchPass(String username)
    {

        db = this.getReadableDatabase();
        String query = " select username, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString((0));

                if(a.equals(username))
                {
                    b = cursor.getString(1);


                    break;
                }
            }
            while(cursor.moveToNext());
        }
       return b;

    }

    //Patient_Info my_pi;

    public String searchid(String appid)
    {
        db = this.getReadableDatabase();
        String query = " select app_id from "+TABLE_NAME3;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString((0));

                if(a.equals(appid))
                {
                    b = appid;
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }





    public String searchpid(String pid)
    {
        db = this.getReadableDatabase();
        String query = " select pid from "+TABLE_NAME2;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        cursor.moveToFirst();
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString((0));

                if(a.equals(pid))
                {
                    b = pid;

                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }



    public Cursor getALLData(){

            db=this.getWritableDatabase();
             //String query = " select aid from "+TABLE_NAME3;
               //Cursor all = db.rawQuery(query, null);
            //Cursor all = db.rawQuery("select aid from" +TABLE_NAME3,null);

        return db.query(TABLE_NAME3,new String[]{COLUMN_app_id,COLUMN_app_name,COLUMN_app_reason,COLUMN_app_contact,COLUMN_app_date},null,null,null,null,null);

       // return all;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        String query = "DROP TABLE IF EXISTS" +TABLE_NAME;

        db.execSQL(query);
        this.onCreate(db);

        String query2 = "DROP TABLE IF EXISTS" +TABLE_NAME2;

        db.execSQL(query2);
        this.onCreate(db);

        String query3 = "DROP TABLE IF EXISTS" +TABLE_NAME3;

        db.execSQL(query3);
        this.onCreate(db);

        String query4 = "DROP TABLE IF EXISTS" +TABLE_NAME4;

        db.execSQL(query4);
        this.onCreate(db);

    }

    public Cursor returnData()
    {

        return db.query(TABLE_NAME3,new String[]{COLUMN_app_id,COLUMN_app_name,COLUMN_app_reason,COLUMN_app_contact,COLUMN_app_date},null,null,null,null,null);


    }




    public Cursor returnData_patient()
    {

        return db.query(TABLE_NAME2,new String[]{COLUMN_pid,COLUMN_pname,COLUMN_pemail,COLUMN_paddress,COLUMN_pcontact,COLUMN_pgender,COLUMN_pdob,COLUMN_pnotes},null,null,null,null,null);


    }





}
