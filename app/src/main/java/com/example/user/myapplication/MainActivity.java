package com.example.user.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.et_input);
        submit = (Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(calcResult);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

private OnClickListener calcResult = new OnClickListener() {

    @Override
        public void onClick(View v) {

            String input_str = input.getText().toString();

            Toast.makeText(MainActivity.this,
                    "Hello "+input_str,
                    Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) { //選擇按鈕
            case R.id.action_Reset:
                input.setText(" ");
                break;
            case R.id.action_About:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("About this APP");
                ad.setMessage("Author: Bo-Shiun Huang");

                DialogInterface.OnClickListener listener =
                        new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface di, int i) {
                          }
                        };

                        ad.setPositiveButton("OK", listener);
                ad.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
