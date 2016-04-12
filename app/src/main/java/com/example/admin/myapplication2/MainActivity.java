package com.example.admin.myapplication2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView idView;
    EditText emailBox;
    EditText passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = (TextView) findViewById(R.id.userID);
        emailBox = (EditText) findViewById(R.id.emailAddr);
        passwordBox =
                (EditText) findViewById(R.id.password);
    }

    public void newUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String quantity = passwordBox.getText().toString();
        String mydomain = emailBox.getText().toString();
        String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Boolean b = mydomain.matches(emailregex);

        User exist =
                dbHandler.findUser(emailBox.getText().toString());
        if(exist==null) {
            if(b==true) {
                User user =
                        new User(emailBox.getText().toString(), quantity);

                dbHandler.addUser(user);
                idView.setText("New user added successfully");
                emailBox.setText("");
                passwordBox.setText("");

            }
            else
            {
                idView.setText("Email expression is not correct");
            }

        }
        else {
            idView.setText("Email already exist!");
        }
    }

    public void lookupUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        User user =
                dbHandler.findUser(emailBox.getText().toString());

        if (user != null) {
            idView.setText(String.valueOf(user.getID()));
            passwordBox.setText(user.getPassword());
        } else {
            idView.setText("No Match Found");
        }
    }

    public void removeUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);

        boolean result = dbHandler.deleteUser(
                emailBox.getText().toString());

        if (result)
        {
            idView.setText("Record Deleted");
            emailBox.setText("");
            passwordBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }
}