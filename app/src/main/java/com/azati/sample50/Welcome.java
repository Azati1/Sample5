package com.azati.sample50;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.azati.sample50.DataProcess.login;

/**
 * Created by azati on 18.03.2018.
 */

public class Welcome extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;
    Button entry;
    Button createNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editLogin.setText("");
        editPassword = (EditText) findViewById(R.id.editPassword);
        entry = (Button) findViewById(R.id.entry);
        createNew = (Button) findViewById(R.id.createNew);

        editLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start > 10) {
                    Toast.makeText(Welcome.this, "Слишком длинный логин", Toast.LENGTH_SHORT).show();
                    entry.setEnabled(false);
                }
                else {
                    entry.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DataProcess.login(editLogin.getText().toString(), editPassword.getText().toString())) {
                    Intent intent = new Intent(Welcome.this, Main.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Welcome.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, CreateAccount.class);
                startActivity(intent);
            }
        });

    }

}
