package android_project.com.doctorassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by RAHUL on 4/25/2015.
 */
public class Patient_Search extends Activity implements View.OnClickListener {


    Button b1,b2,b3;
    String ww;

    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_search);


        b1 = (Button)findViewById(R.id.patient_searchU);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.ueditpatient);
        b2.setOnClickListener(this);

        b3 = (Button) findViewById(R.id.Bhhome);
        b3.setOnClickListener(this);

    }





    public void onClick(View v) {

        if (v.getId() == R.id.patient_searchU) {
            EditText a = (EditText) findViewById(R.id.pat_idu);
            String str = a.getText().toString();

            String patient_Id = helper.searchpid(str);


            EditText pnameU = (EditText) findViewById(R.id.nameetxtU);
            EditText pemailU = (EditText) findViewById(R.id.emailetxtU);
            EditText paddressU = (EditText) findViewById(R.id.addressetxtU);
            EditText pcontactU = (EditText) findViewById(R.id.contactetxtU);
            EditText pgenderU = (EditText) findViewById(R.id.genderetxtU);
            EditText pdobU = (EditText) findViewById(R.id.dobetxtU);
            EditText pnotesU = (EditText) findViewById(R.id.notesetxtU);

            Cursor cursor = helper.returnData_patient();

            ww=str;

            if(str.equals(patient_Id))
            {

                String name, address,contact,email,gender,dob,notes;

                name ="";
                address ="";
                contact="";
                email="";
                gender ="";
                dob ="";
                notes ="";

                helper=new databasehelper(getBaseContext());

                if(cursor.moveToFirst())
                {
                        /*do{
                            id = cursor.getString((0));
                            name= cursor.getString((1));
                            reason = cursor.getString((2));
                            contact= cursor.getString((3));
                            date= cursor.getString((4));


                        }
                        while(cursor.moveToNext());*/
                    do{
                        String q = cursor.getString((0));

                        if(q.equals(str))
                        {
                            name = cursor.getString((1));
                            email= cursor.getString((2));
                            address = cursor.getString((3));
                            contact= cursor.getString((4));
                            gender= cursor.getString((5));
                            dob= cursor.getString((6));
                            notes= cursor.getString((7));


                            //break;
                        }
                    }
                    while(cursor.moveToNext());

                }

                pnameU.setText(name);
                pemailU.setText(email);
                paddressU.setText(address);
                pcontactU.setText(contact);
                pgenderU.setText(gender);
                pdobU.setText(dob);
                pnotesU.setText(notes);


               Toast.makeText(getBaseContext(),"Search" +"successfull", Toast.LENGTH_SHORT).show();

           }

            //Intent i = new Intent(getApplicationContext(), Patient_Info.class);
                //startActivity(i);


                //retrive data form database and put it in edit text
                /*Toast temp;
                temp = Toast.makeText(EditAppointment.this, "patient id found", Toast.LENGTH_SHORT);
                temp.show();

*/



            else
            {
              //  b1.setOnClickListener(
                //        new View.OnClickListener() {
                         //   @Override
                        //    public void onClick(View v) {
                                AlertDialog.Builder a_builder = new AlertDialog.Builder(Patient_Search.this);

                                a_builder.setMessage("The Patient is not present, Do you want to add ??")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                Intent i = new Intent(getApplicationContext(), AddPatient.class);
                                                startActivity(i);

                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alert = a_builder.create();
                                alert.setTitle("Alert !!!");
                                alert.show();
                        //    }
               //         }
             //   );
                cursor.moveToFirst();
            }

        }




        if (v.getId() == R.id.ueditpatient){


            Toast temp;
            temp = Toast.makeText(Patient_Search.this, "Info Updated", Toast.LENGTH_SHORT);
            temp.show();
            //app_id ,app_name, app_reason, app_contact, app_date;


            EditText updatename = (EditText) findViewById(R.id.nameetxtU);
            EditText updateaddress = (EditText) findViewById(R.id.addressetxtU);
            EditText updatecontact = (EditText) findViewById(R.id.contactetxtU);
            EditText updateemail = (EditText) findViewById(R.id.emailetxtU);
            EditText updategender = (EditText) findViewById(R.id.genderetxtU);
            EditText updatedob = (EditText) findViewById(R.id.dobetxtU);
            EditText updatenotes = (EditText) findViewById(R.id.notesetxtU);

            String newname = updatename.getText().toString();
            String newaddress = updateaddress.getText().toString();
            String newcontact = updatecontact.getText().toString();
            String newemail = updateemail.getText().toString();
            String newgender = updategender.getText().toString();
            String newdob = updatedob.getText().toString();
            String newnotes = updatenotes.getText().toString();


            /*Appointment_db c4 = new Appointment_db();

            c4.setPatientID(patidstr);
            c4.setPatient_Name(patnamestr);
            c4.setPatient_reason(patreasonstr);
            c4.setPatient_contact(patcontactstr);
            c4.setApp_date(patdatestr);*/


            //  helper.updateappointment(c4);

            // helper.updateData(patidstr,patnamestr,patreasonstr,patcontactstr,patdatestr);

            helper.updatePatientData(newname, newaddress,newcontact,newemail,newgender,newdob,newnotes,ww);


            //Toast.makeText(this,"update successfull",Toast.LENGTH_SHORT).show();

            //helper.updateList();





        }
        if (v.getId() == R.id.Bhhome) {
            Intent i = new Intent(Patient_Search.this, homepage.class);
            startActivity(i);
        }



 }

}

