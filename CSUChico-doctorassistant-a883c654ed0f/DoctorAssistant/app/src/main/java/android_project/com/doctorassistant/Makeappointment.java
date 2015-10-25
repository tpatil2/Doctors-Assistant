package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tejas on 4/26/15.
 */
public class Makeappointment extends Activity implements View.OnClickListener{

    databasehelper helper = new databasehelper(this);
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeappointment);

        b1 = (Button)findViewById(R.id.conform_appo);
        b1.setOnClickListener(this);

        b2 = (Button)findViewById(R.id.calender_add);
        b2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.conform_appo)
        {

            Toast temp;
            temp = Toast.makeText(Makeappointment.this, "Appointment successfull!", Toast.LENGTH_SHORT);
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

            Appointment_db c3 = new Appointment_db();

            c3.setPatientID(patidstr);
            c3.setPatient_Name(patnamestr);
            c3.setPatient_reason(patreasonstr);
            c3.setPatient_contact(patcontactstr);
            c3.setApp_date(patdatestr);


            helper.insert3(c3);


        }

        if(v.getId()==R.id.calender_add)
        {
            ComponentName cn;
            Intent i = new Intent();
            cn = new ComponentName("com.android.calendar", "com.android.calendar.LaunchActivity");
            i.setComponent(cn);
            startActivity(i);
        }
    }
}




