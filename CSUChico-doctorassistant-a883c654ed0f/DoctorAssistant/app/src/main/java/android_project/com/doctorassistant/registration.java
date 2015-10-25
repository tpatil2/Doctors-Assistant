package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tejas on 4/24/15.
 */
public class registration extends Activity implements View.OnClickListener {
    private static final String TAG = "";
    databasehelper helper = new databasehelper(this);

    Serverdatabasehelper helper1;


    Button b;
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.newuser_registration);


        b = (Button)findViewById(R.id.btnRegister);
        b.setOnClickListener(this);

        tv = (TextView)findViewById(R.id.link_to_login);
        tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

            if(v.getId() ==R.id.btnRegister)
            {
                Toast temp;
                temp = Toast.makeText(registration.this, "registration successfull!", Toast.LENGTH_SHORT);
                temp.show();
                EditText name = (EditText) findViewById(R.id.reg_fullname);
                EditText email = (EditText) findViewById(R.id.reg_email);
                EditText username = (EditText) findViewById(R.id.uname);
                EditText password = (EditText) findViewById(R.id.reg_password);

                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String unamestr = username.getText().toString();
                String passstr = password.getText().toString();

                userinfo c = new userinfo();

                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUsername(unamestr);
                c.setPassword(passstr);




                helper.insert(c);

                Log.d(TAG, "We are in values;"+namestr);
                helper1 = new Serverdatabasehelper(namestr,emailstr,unamestr,passstr);
                helper1.serverinsert();
                Intent i = new Intent(registration.this, DoctorLogin.class);
                startActivity(i);

            }

        if(v.getId() ==R.id.link_to_login)
        {
            Intent i = new Intent(getApplicationContext(), DoctorLogin.class);
            startActivity(i);

        }

        }
}
