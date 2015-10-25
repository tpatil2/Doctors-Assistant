package android_project.com.doctorassistant;

import android.app.Activity;
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
public class Patient_Info extends Activity implements View.OnClickListener {

    Button b1, b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_info);

    }
        @Override
        public void onClick (View v){
            if (v.getId() == R.id.ueditpatient) {
                Intent i = new Intent(Patient_Info.this, Edit_patient_info.class);
                startActivity(i);
            }

            if (v.getId() == R.id.Bhhome) {
                Intent i = new Intent(Patient_Info.this, homepage.class);
                startActivity(i);
            }


        }

}