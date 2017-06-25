package com.example.rajvi.safealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//UNCOMMENT WHEN WE'RE READY FOR TWILIO
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Call;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MainActivity activity = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(activity, Screen2V2Activity.class);
                startActivity(screen2);
            }

        });
    }
    
    
 /*
    ActivityCompat.requestPermissions(this,
    new String[]{Manifest.permission.RECORD_AUDIO}, MIC_PERMISSION_REQUEST_CODE);
    */
    //add the above line of code when the user hits the "I'm nervous" button. It allows app to access mic in case of necesary 911 call
    
    /*
        public static boolean callPolice(){ //calls the police
            public static final String ACCOUNT_SID = "ACebd0e977b0959d04da953c6fed0d5131";
            public static final String AUTH_TOKEN = "c236a3a93ee47134154089aec6f875d0";
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
           
                          //  parameters( call to # aka my num to be replaced by 911, call from # aka twilio num, URI)
                          // what is URI?
             Call call = Call.creator(new PhoneNumber("+17327446890"), new PhoneNumber("+18482299702"), new URI(""http://demo.twilio.com/welcome/voice/").create();
            //this will probably only say "welcome" right now!
        }
    */
    
    
    /*
    ActivityCompat.requestPermissions(this,
    new String[]{Manifest.permission.RECORD_AUDIO}, MIC_PERMISSION_REQUEST_CODE);
    */
    //add the above line of code when the user hits the "I'm nervous" button. It allows app to access mic in case of necesary 911 call
}
