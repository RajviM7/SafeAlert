package com.example.rajvi.safealert;

import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
//<<<<<<< HEAD
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
//<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
//=======
=======

import android.widget.Button;
import android.widget.Toast;

//>>>>>>> origin/master

//UNCOMMENT WHEN WE'RE READY FOR TWILIO
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Call;



public class MainActivity extends AppCompatActivity {

    private TextView mTxtSpeech;
    private Button mButton;
    private Button mButtonHelp;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mButton = (Button) findViewById(R.id.buttonUncomf);
        mTxtSpeech = (TextView) findViewById(R.id.txtSpeech);
        mTxtSpeech.setText("Hi");
//        FloatingActionButton mbutton = (FloatingActionButton) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//<<<<<<< HEAD
                Intent screen2 = new Intent(MainActivity.this, Screen2V2Activity.class);
                MainActivity.this.startActivity(screen2);
                promptSpeechInput();
            }

        });

        mButtonHelp = (Button) findViewById(R.id.buttonHelp);
        mButtonHelp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Intent screen2 = new Intent(activity, Screen2V2Activity.class); //user has hit "I'm nervous"
//                startActivity(screen2);
                makeCallWrapper();
=======

                Intent screen2 = new Intent(MainActivity.this, Screen2V2Activity.class);
                MainActivity.this.startActivity(screen2);

//                Intent screen2 = new Intent(activity, Screen2V2Activity.class); //user has hit "I'm nervous"
//                startActivity(screen2);

>>>>>>> origin/master
            }

        });

//        final MainActivity activity = this;
//        Button mButton = (Button) findViewById(R.id.button);
////        FloatingActionButton mbutton = (FloatingActionButton) findViewById(R.id.button);
//        mButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
////<<<<<<< HEAD
//                Intent screen2 = new Intent(MainActivity.this, Screen2V2Activity.class);
//                MainActivity.this.startActivity(screen2);
////=======
////                Intent screen2 = new Intent(activity, Screen2V2Activity.class); //user has hit "I'm nervous"
////                startActivity(screen2);
////>>>>>>> origin/master
//            }
//
//        });

        final MainActivity activity2 = this;
        Button mButton6 = (Button) findViewById(R.id.buttonMap);
//        FloatingActionButton mbutton = (FloatingActionButton) findViewById(R.id.button);
        mButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent map = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(map);
            }
        });


    }
        //Pop-up Alert
//        Button mButton2 = (Button) findViewById(R.id.button2);
//        mButton2.setOnClickListener(new View.OnClickListener() {
//
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//            public class DialogFragment extends DialogFragment {
//                @Override
//                public Dialog onCreateDialog(Bundle savedInstanceState) {
//                    // Use the Builder class for convenient dialog construction
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                    builder.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            toast.makeText(this,"enter a text here",Toast.LENTH_SHORT).show();
//                        }
//                    })
//                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    finish();
//                                });
//                                // Create the AlertDialog object and return it
//                                return builder.create();
//                            }
//                }
//            }
//
//        });

    private void makeCallWrapper() {
        int hasCallPermission = checkSelfPermission(android.Manifest.permission.CALL_PHONE);
        if (hasCallPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {android.Manifest.permission.CALL_PHONE},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        }
        makeCall();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    makeCall();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "CALL_PHONE Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            case REQ_CODE_SPEECH_INPUT:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    promptSpeechInput();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "RECOGNIZE_SPEECH Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void makeCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:3478204920"));
        try {
            MainActivity.this.startActivity(intent);

        } catch (ActivityNotFoundException a) {
            Log.d("LOG",a.getMessage());
        }
    }
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Log.d("LOG",a.getMessage());
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mTxtSpeech.setText(result.get(0));
                }
                break;
            }
        }
    }

    
    
 /*
    ActivityCompat.requestPermissions(this,
    new String[]{Manifest.permission.RECORD_AUDIO}, MIC_PERMISSION_REQUEST_CODE);
    */
    //add the above line of code when the user hits the "I'm feeling uncomfortable" button. It allows app to access mic in case of necesary 911 call

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
