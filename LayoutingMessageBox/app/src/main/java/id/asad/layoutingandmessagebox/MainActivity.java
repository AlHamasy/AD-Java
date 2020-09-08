package id.asad.layoutingandmessagebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    private Button btnToast, btnAlert, btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_box);

        // panggil ID
        btnToast = findViewById(R.id.btn_toast);
        btnAlert = findViewById(R.id.btn_alert);
        btnSnackbar = findViewById(R.id.btn_snacbar);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ini adalah toast", Toast.LENGTH_SHORT).show();
            }
        });


        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Judul Alert");
                alert.setMessage("Message Alert");
                alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do action
                    }
                });
                alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do action
                    }
                });
                alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do action
                    }
                });
                alert.show();
            }
        });

        btnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.layout_message_box), "ini snackbar", Snackbar.LENGTH_LONG);
                mySnackbar.setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "toast from snackbar", Toast.LENGTH_SHORT).show();
                    }
                });
                mySnackbar.show();

            }
        });

        
    }
}