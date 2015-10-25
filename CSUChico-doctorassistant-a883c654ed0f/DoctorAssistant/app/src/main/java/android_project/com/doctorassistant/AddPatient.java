package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by RAHUL on 4/26/2015.
 */
public class AddPatient extends Activity implements View.OnClickListener{



    databasehelper helper = new databasehelper(this);
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient);



        b1 = (Button)findViewById(R.id.Baddpatient);
        b1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.Baddpatient) {

            Toast temp;

            temp = Toast.makeText(AddPatient.this, "successfull!", Toast.LENGTH_SHORT);
            temp.show();



            // EditText PID =(EditText) findViewById(R.id.nameetxt)
            EditText pname = (EditText) findViewById(R.id.nameetxt);
            EditText paddress = (EditText) findViewById(R.id.addressetxt);
            EditText pcontact = (EditText) findViewById(R.id.contactetxt);
            EditText pemail = (EditText) findViewById(R.id.emailetxt);
            EditText pgender = (EditText) findViewById(R.id.gendertxt);
            EditText pdob = (EditText) findViewById(R.id.dobetxt);
            EditText pnotes = (EditText) findViewById(R.id.notesetxt);


            String pnamestr = pname.getText().toString();
            String pemailstr = pemail.getText().toString();
            String paddressstr = paddress.getText().toString();
            String pcontactstr = pcontact.getText().toString();
            String pgenderstr = pgender.getText().toString();
            String pdobstr = pdob.getText().toString();
            String pnotestr = pnotes.getText().toString();


            Patient_DBinfo c1 = new Patient_DBinfo();

            c1.setName(pnamestr);
            c1.setEmail(pemailstr);
            c1.setAddress(paddressstr);
            c1.setContact(pcontactstr);
            c1.setGender(pgenderstr);
            c1.setDOB(pdobstr);
            c1.setNotes(pnotestr);
            helper.insert2(c1);


            Intent i = new Intent(AddPatient.this, homepage.class);
            startActivity(i);

        }

    }
}