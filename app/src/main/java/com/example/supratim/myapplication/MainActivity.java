package com.example.supratim.myapplication;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView et1;
    public Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,bspeak;
    float ValueOne,ValueTwo,ValueThree;
    Switch key;
    //float ValueTwo ;

    boolean Addition , Subtract ,Multiplication ,Division,power,root,pi,exponent,sine,cosine,tangent,loge,log,fact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(TextView)findViewById(R.id.tv1);
         key=(Switch)findViewById(R.id.switch1);
        Scientific sc=Scientific.newInstance("j","k");
        FragmentManager fr=getFragmentManager();
        fr.beginTransaction().replace(R.id.frame1,sc).commit();
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.isChecked()) {
                    Scientific sc = Scientific.newInstance("j", "k");
                    FragmentManager fr = getFragmentManager();
                    fr.beginTransaction().replace(R.id.frame1, sc).commit();
                } else if (!key.isChecked()) {
                    standard st=standard.newInstance("m","n");
                    FragmentManager fr=getFragmentManager();
                    fr.beginTransaction().replace(R.id.frame1,st).commit();

                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
