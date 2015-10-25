package android_project.com.doctorassistant;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RAHUL on 4/23/2015.
 */
public class DoctorLogin extends Activity implements View.OnClickListener{

    Button b1;
    TextView tv1;

    databasehelper helper = new databasehelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        b1 = (Button)findViewById(R.id.btnLogin);
        b1.setOnClickListener(this);
        tv1 = (TextView)findViewById(R.id.link_to_register);
        tv1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnLogin) {
            EditText a = (EditText) findViewById(R.id.login_user);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.login_password);
            String pass = b.getText().toString();
            String password = helper.searchPass(str);

            if (pass.equals(password)) {
                Intent i = new Intent(getApplicationContext(), homepage.class);
                startActivity(i);
            } else {
                Toast temp;
                temp = Toast.makeText(DoctorLogin.this, "Invalid Password", Toast.LENGTH_SHORT);
                temp.show();
            }
        }

        if(v.getId() ==R.id.link_to_register)
        {
            Intent i = new Intent(getApplicationContext(), registration.class);
            startActivity(i);

        }


    }


 }

