package android_project.com.doctorassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tejas on 4/26/15.
 */
public class Mainpage_appointment extends Activity implements View.OnClickListener {

    Button a1, a2, a3;
    Context context;
    Cursor cursor;

    databasehelper helper = new databasehelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_appointment);

        a1 = (Button)findViewById(R.id.b_make_appoint);
        a1.setOnClickListener(this);

        a2 = (Button)findViewById(R.id.b_edit_appoint);
        a2.setOnClickListener(this);

        a3 = (Button)findViewById(R.id.b_view_appoint);
        a3.setOnClickListener(this);





    }




    public void showMessage(String title, String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(Mainpage_appointment.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();


    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.b_make_appoint)
        {
            Intent i = new Intent(Mainpage_appointment.this, Makeappointment.class);
            startActivity(i);
        }

        if(v.getId()==R.id.b_edit_appoint)
        {
            Intent i = new Intent(Mainpage_appointment.this, EditAppointment.class);
            startActivity(i);
        }

        if(v.getId()==R.id.b_view_appoint)
        {
           //Intent i = new Intent(Mainpage_appointment.this, ViewAppointment.class);
            //startActivity(i);


            Cursor all =  helper.getALLData();

            if(all.getCount() == 0){
                //show msg
                showMessage("Error", "No Appointment Scheduled:");
                return;
            }

            StringBuffer buffer = new StringBuffer();
            while(all.moveToNext()){


                buffer.append("Appointment Id:"+all.getString(0)+"\n");
                buffer.append("Patient Name:"+all.getString(1)+"\n");
                buffer.append(" Reason:"+all.getString(2)+"\n");
                buffer.append("Contact:"+all.getString(3)+"\n");
                buffer.append("Date::"+all.getString(4)+"\n\n");

            }

            //show msg
            showMessage("Appointment Details", buffer.toString());


        }



    }
}
