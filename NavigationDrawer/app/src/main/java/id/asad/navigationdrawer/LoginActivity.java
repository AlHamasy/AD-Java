package id.asad.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtName = findViewById(R.id.edt_name);
        final EditText edtEmail = findViewById(R.id.edt_email);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();

                if (name.isEmpty() || email.isEmpty()){
                    Toast.makeText(LoginActivity.this, "tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else{

                    // simpan data ke shared preferences
                    UserPreferences preferences = new UserPreferences(LoginActivity.this);
                    preferences.loginPreferences(name, email);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}