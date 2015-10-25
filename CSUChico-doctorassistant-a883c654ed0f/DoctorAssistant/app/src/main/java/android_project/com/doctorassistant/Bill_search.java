package android_project.com.doctorassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tejas on 5/8/15.
 */
public class Bill_search extends Activity implements View.OnClickListener {


    Button b1;
    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_search);


        b1 = (Button) findViewById(R.id.search_billQ);
        b1.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_billQ) {
            EditText a = (EditText) findViewById(R.id.pat_id_billQ);
            String str = a.getText().toString();

            String patientId = helper.searchpid(str);

            if (str.equals(patientId))

            {
                Intent i = new Intent(getApplicationContext(), Billing.class);
                startActivity(i);

            }
            else
            {
                //  b1.setOnClickListener(
                //        new View.OnClickListener() {
                //   @Override
                //    public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Bill_search.this);

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
               // cursor.moveToFirst();
            }

        }

    }

}
