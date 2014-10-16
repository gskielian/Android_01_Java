package com.example.gkielian.android_01_java;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;


public class HelloAndroidJava extends Activity {

    //strings for our guessing game
    private static final String[] my_secret_answers = {"eclair", "kitkat", "ice cream sandwhich", "lollipop"};

    //declared here for scope (so we can use in button onClick and inner classes)
    private TextView judgement_view;
    private EditText edit_text_answer;
    private Button judging_button;


    //this runs when app starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //looks if was open before
        super.onCreate(savedInstanceState);

        //what is the "html" of your app
        setContentView(R.layout.activity_hello_android_java);

        //binds the "controller" (the java code) to the things you "view" (specified in the layout)
        judgement_view = (TextView) findViewById(R.id.textView);
        edit_text_answer = (EditText) findViewById(R.id.editText);
        judging_button = (Button) findViewById(R.id.button);

        //react to enter key
        edit_text_answer.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //if enter key is pressed
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //judge and reply
                    judge_guess_and_reply();
                }
                return true;
            }
        });

        //Define what our button does when clicked:
        judging_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //judge and reply
                judge_guess_and_reply();
            }
        });

    }

    //example of an additional class method
    private void judge_guess_and_reply() {
        //get user's guess
        String user_guess = edit_text_answer.getText().toString();

        //test if they got it right
        Boolean correct_or_not  = check_guess(user_guess);

        //test whether guess is
        String my_response = (correct_or_not) ? user_guess + " is definitely one of them.": "Not a big fan of " + user_guess + ".";

        //display the result
        judgement_view.setText(my_response);
    }

    //example of a helper method
    private Boolean check_guess(String edit_text_answer) {
        for (String user_guess : my_secret_answers) {
            if (user_guess.equals(edit_text_answer) )
                return true;
        }
        return false;
    }

    //below are defaults from android studio:

    //creates a menu and adds to action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello_android_java, menu);
        return true;
    }


    //handling home and return buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
