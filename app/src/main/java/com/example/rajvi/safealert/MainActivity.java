package com.example.rajvi.safealert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MainActivity activity = this;
        Button mButton = (Button) findViewById(R.id.button);
//        FloatingActionButton mbutton = (FloatingActionButton) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent screen2 = new Intent(MainActivity.this, Screen2V2Activity.class);
                MainActivity.this.startActivity(screen2);
            }

        });
    }
    
    /*
    ActivityCompat.requestPermissions(this,
    new String[]{Manifest.permission.RECORD_AUDIO}, MIC_PERMISSION_REQUEST_CODE);
    */
    //add the above line of code when the user hits the "I'm nervous" button. It allows app to access mic in case of necesary 911 call
}
