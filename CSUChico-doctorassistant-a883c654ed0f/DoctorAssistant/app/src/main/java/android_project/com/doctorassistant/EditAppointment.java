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

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RAHUL on 4/25/2015.
 */

public class EditAppointment extends Activity implements View.OnClickListener {

    Button b1, b2, b3;


    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editappointment);

        b1 = (Button) findViewById(R.id.patient_search);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.conform_appo);
        b2.setOnClickListener(this);

        b3 = (Button) findViewById(R.id.apphome);
        b3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.patient_search) {
            EditText a = (EditText) findViewById(R.id.pat_id1);
            String str = a.getText().toString();

            EditText pat_ida = (EditText) findViewById(R.id.pat_id);
            EditText pat_namea = (EditText) findViewById(R.id.pat_name);
            EditText pat_reasona = (EditText) findViewById(R.id.pat_reason);
            EditText pat_contacta = (EditText) findViewById(R.id.pat_contact);
            EditText pat_datea = (EditText) findViewById(R.id.pat_date);


            String patientId = helper.searchid(str);
            Cursor cursor = helper.returnData();


            if (str.equals(patientId))

            {

                String id, name, reason, contact, date;

                id = "";
                name = "";
                reason = "";
                contact = "";
                date = "";

                helper = new databasehelper(getBaseContext());

                if (cursor.moveToFirst()) {
                        /*do{
                            id = cursor.getString((0));
                            name= cursor.getString((1));
                            reason = cursor.getString((2));
                            contact= cursor.getString((3));
                            date= cursor.getString((4));


                        }
                        while(cursor.moveToNext());*/
                    do {
                        String q = cursor.getString((0));

                        if (q.equals(str)) {
                            id = cursor.getString((0));
                            name = cursor.getString((1));
                            reason = cursor.getString((2));
                            contact = cursor.getString((3));
                            date = cursor.getString((4));


                            break;
                        }
                    }
                    while (cursor.moveToNext());

                }


                pat_ida.setText(id);
                pat_namea.setText(name);
                pat_reasona.setText(reason);
                pat_contacta.setText(contact);
                pat_datea.setText(date);
                Toast.makeText(getBaseContext(), "Appointment found", Toast.LENGTH_SHORT).show();
/*
                Intent i = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(i);
            //retrive data form database and put it in edit text
                /*Toast temp;
                temp = Toast.makeText(EditAppointment.this, "patient id found", Toast.LENGTH_SHORT);
                temp.show();
            */


                /*List<String[]> et_set_list ;
                //String[] stg1;
                et_set_list = helper.searchid2(str);
                int test = et_set_list.size();

                String p = et_set_list.get(1).toString();
                app_pateint_id.setText(p);
*/
            } else {
                //  b1.setOnClickListener(
                //        new View.OnClickListener() {
                //   @Override
                //    public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(EditAppointment.this);

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

        if (v.getId() == R.id.conform_appo) {
            //Update information and put back to data base


            Toast temp;
            temp = Toast.makeText(EditAppointment.this, "Info Updated", Toast.LENGTH_SHORT);
            temp.show();
            //app_id ,app_name, app_reason, app_contact, app_date;


            EditText patid = (EditText) findViewById(R.id.pat_id);
            EditText patname = (EditText) findViewById(R.id.pat_name);
            EditText patreason = (EditText) findViewById(R.id.pat_reason);
            EditText patcontct = (EditText) findViewById(R.id.pat_contact);
            EditText patdate = (EditText) findViewById(R.id.pat_date);

            String patidstr = patid.getText().toString();
            String patnamestr = patname.getText().toString();
            String patreasonstr = patreason.getText().toString();
            String patcontactstr = patcontct.getText().toString();
            String patdatestr = patdate.getText().toString();



            helper.updateData(patidstr, patnamestr, patreasonstr, patcontactstr, patdatestr);


            Toast.makeText(this, "update successfull", Toast.LENGTH_SHORT).show();

            //helper.updateList();

        }


        if (v.getId() == R.id.apphome) {


            Intent i = new Intent(getApplicationContext(), Mainpage_appointment.class);
            startActivity(i);

        }


    }

}