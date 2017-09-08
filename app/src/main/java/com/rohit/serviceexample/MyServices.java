package com.rohit.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyServices extends Service {


    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
      // Let it continue running until it is stopped.
        Log.d("", "onStartCommand: started");
      //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Log.d("", "onStartCommand: running");
                //Toast.makeText(MyServices.this, "Service is Running", Toast.LENGTH_LONG).show();
            }
        }, 3000);
      return START_STICKY;
   }
   @Override
   public void onDestroy() {
      super.onDestroy();
     // Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
   }
}