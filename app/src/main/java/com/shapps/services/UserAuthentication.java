package com.shapps.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;



public class UserAuthentication extends Service {
    public UserAuthentication() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        String username = intent.getExtras().getString("username");
        String password = intent.getExtras().getString("password");

//            Toast.makeText(getApplicationContext(), username + password, Toast.LENGTH_SHORT).show();


        if(username.equals("sharvesh0608") && password.equals("Sharvesh@123")){
            Toast.makeText(getApplicationContext(), "Logged in successfully..", Toast.LENGTH_SHORT).show();
            Intent next = new Intent(getApplicationContext(), Dashboard.class);
            next.putExtra("name", username);
            next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(next);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please check your credentials...", Toast.LENGTH_SHORT).show();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}