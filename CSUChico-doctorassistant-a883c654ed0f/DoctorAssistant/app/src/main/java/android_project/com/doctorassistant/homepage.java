package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tejas on 4/25/15.
 */
public class homepage extends Activity implements View.OnClickListener {

   Button b1, b2, b3, b4, b5, b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        b1 = (Button)findViewById(R.id.Button1);
        b1.setOnClickListener(this);

        b2 = (Button)findViewById(R.id.Button2);
        b2.setOnClickListener(this);


        b4 = (Button)findViewById(R.id.btn_appointment);
        b4.setOnClickListener(this);

        b5 = (Button)findViewById(R.id.button5);
        b5.setOnClickListener(this);

        b6 = (Button)findViewById(R.id.Bcontact);
        b6.setOnClickListener(this);

        b3 = (Button)findViewById(R.id.logout);
        b3.setOnClickListener(this);




    }




    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Bcontact)
        {
            Intent i = new Intent(homepage.this, ContactUs.class);
            startActivity(i);
        }

        if(v.getId()==R.id.Button1)
        {
            Intent i = new Intent(homepage.this, AddPatient.class);
            startActivity(i);
        }

        if(v.getId()==R.id.btn_appointment)
        {
            Intent i = new Intent(homepage.this, Mainpage_appointment.class);
            startActivity(i);
        }

        if(v.getId()==R.id.button5)
        {
            Intent i = new Intent(homepage.this, Bill_search.class);
            startActivity(i);
        }
        if(v.getId()==R.id.Button2)
        {
            Intent i = new Intent(homepage.this, Patient_Search.class);
            startActivity(i);
        }

        if(v.getId()==R.id.logout)
        {
            Intent i = new Intent(homepage.this, DoctorLogin.class);
            startActivity(i);
            finish();
        }



    }
}
