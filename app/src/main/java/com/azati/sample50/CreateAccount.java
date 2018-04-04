package com.azati.sample50;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.azati.sample50.Data.listOfPerson;
import static com.azati.sample50.DataProcess.login;

/**
 * Created by azati on 02.04.2018.
 */

public class CreateAccount extends AppCompatActivity{

    Button buttonCreateAccount;
    EditText editTextLogin;
    EditText editTextPassword;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.create_account);

        buttonCreateAccount = (Button) findViewById(R.id.create_account);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateAccount.this, "111", Toast.LENGTH_SHORT);
                addAccount(editTextLogin.getText().toString(), editTextPassword.getText().toString());
            }
        });

        editTextLogin = (EditText) findViewById(R.id.edit_create_login);
        editTextPassword = (EditText) findViewById(R.id.edit_create_password);
    }

    public void addAccount(String login, String password) {

        listOfPerson.add(new Person(login, password, "", "", 0,0));

        if (login(login, password)) {
            Intent intent = new Intent(CreateAccount.this, Main.class);
            startActivity(intent);
        }
    }

}