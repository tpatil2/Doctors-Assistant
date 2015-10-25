package android_project.com.doctorassistant;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tejas on 5/12/15.
 */
public class Serverdatabasehelper {


    private static final String TAG = "";
    String name1,email1,id1,password1;
    public Serverdatabasehelper(String name,String email,String id,String psw)
    {
        name1 = name;
        id1=id;
        email1=email;
        password1=psw;





    }


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    public class serverinsert1 extends AsyncTask<String ,String,String> {


        private static final String TAG = "";




        @Override
        protected String doInBackground(String... params) {

            try {
                Log.d(TAG, "We are in try"+name1);


                String postReceiverUrl = "http://52.24.51.46/phpFfiles/register.php";

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(postReceiverUrl);
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);


                nameValuePairs.add(new BasicNameValuePair("name", name1));
                nameValuePairs.add(new BasicNameValuePair("email", email1));
                nameValuePairs.add(new BasicNameValuePair("id", id1));
                nameValuePairs.add(new BasicNameValuePair("pswd", password1));
                Log.d(TAG, "We are @ name"+name1);


                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();

                Log.d(TAG, "We are above null"+name1);


                if (httpEntity != null) {

                    final String responsestr = EntityUtils.toString(httpEntity).trim();

                }


            } catch (ClientProtocolException e) {

                e.printStackTrace();


            } catch (IOException e) {


                e.printStackTrace();
            }
        return null;
        }
    }

    public void serverinsert()
    {

        Log.d(TAG, "We are at server insert");
        new serverinsert1().execute();
        Log.d(TAG, "We are next");


    }
}
