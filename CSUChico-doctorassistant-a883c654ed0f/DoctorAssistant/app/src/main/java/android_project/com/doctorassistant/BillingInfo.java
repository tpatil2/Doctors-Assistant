package android_project.com.doctorassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by RAHUL on 4/25/2015.
 */
public class BillingInfo extends Activity implements View.OnClickListener{

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_info);

        b1 = (Button)findViewById(R.id.back_home);
        b1.setOnClickListener(this);

        b2 = (Button)findViewById(R.id.update_bill);
        b2.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.back_home)
        {
            Intent i = new Intent(BillingInfo.this, homepage.class);
            startActivity(i);
        }
        if(v.getId()==R.id.update_bill)
        {
            Intent i = new Intent(BillingInfo.this, Billing.class);
            startActivity(i);
        }


    }
}
