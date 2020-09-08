package id.asad.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
    }

    public void moveActivity(View view) {

        // intent explicit, jelas tujuannya
        Intent intent = new Intent(this, MoveActivity.class);
        startActivity(intent);
    }

    public void moveDataActivity(View view) {

        // intent explicit, jelas tujuannya
        Intent intent = new Intent(this, MoveDataActivity.class);
        intent.putExtra("NAMA", "Asadullah Al Hamasy");
        intent.putExtra("UMUR", 22);
        startActivity(intent);
    }

    public void moveObjectActivity(View view) {

        Mobil mbl = new Mobil();
        mbl.setMerek("Toyota");
        mbl.setKilometer(1212.12);
        mbl.setTahun(2020);
        mbl.setPlatnomor('B');
        mbl.setBaru(false);

        // intent explicit, jelas tujuannya
        Intent intent = new Intent(this, MoveObjectActivity.class);
        intent.putExtra("MOBIL", mbl);
        startActivity(intent);

    }

    public void moveApplication(View view) {

        // intent implicit, belum jelas tujuannya
        String website = "https://idn.id";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(website));
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}