package id.asad.navigationdrawer;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String KEY_USER = "USER";
    private String KEY_NAME = "NAME";
    private String KEY_EMAIL = "EMAIL";

    public UserPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(KEY_USER, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void loginPreferences(String name, String email){
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public void logoutPreferences(){
        editor.remove(KEY_NAME);
        editor.remove(KEY_EMAIL);
        editor.apply();
    }

    public String getName(){
        return sharedPreferences.getString(KEY_NAME, null);
    }

    public String getEmail(){
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    public boolean isLogin(){
        return getName() != null && getEmail() != null;
    }



}
