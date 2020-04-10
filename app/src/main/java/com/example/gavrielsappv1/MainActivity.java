package com.example.gavrielsappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView loginResult;
    EditText usernameInput;
    EditText passwordInput;
    Button login;
    String[] usernames;
    String[] passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginResult = findViewById(R.id.textView);
        usernameInput = findViewById(R.id.editText);
        passwordInput = findViewById(R.id.editText2);
        login = findViewById(R.id.button);


        usernames = new String[5];
        passwords = new String[5];
        usernames[0] = "bruh";
        passwords[0] = "bruh";
        usernames[1] = "";
        passwords[1] = "";

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernames != null || passwords != null) {
                    Boolean didGetIn = false;
                    for (Integer i = 0; i < usernames.length; i++) {
                        if (usernameInput.getText().toString().equals(usernames[i]) && passwordInput.getText().toString().equals(passwords[i])) {
                            didGetIn = true;
                            break;
                        }
                    }
                    if (didGetIn.equals(true)) {
                        loginResult.setText("welcome");
                        Intent myIntent = new Intent(MainActivity.this, TaskList.class);
                        MainActivity.this.startActivity(myIntent);
                    } else {
                        loginResult.setText("try again");
                    }
                } else {
                    loginResult.setText("error array empty or missing");
                }
            }
        });
    }
}
