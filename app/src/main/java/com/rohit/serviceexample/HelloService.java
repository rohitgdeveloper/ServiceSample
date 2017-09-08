package com.rohit.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class HelloService extends Service {

    private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
        Toast.makeText(this, "Service onCreate", Toast.LENGTH_SHORT).show();
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand");
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
       /* new Thread(new Runnable() {
            @Override
            public void run() {


                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
                for (int i = 0; i < 30; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                    }

                    if(isRunning){
                        Log.i(TAG, "Service running");
                        Toast.makeText(HelloService.this, "Running", Toast.LENGTH_SHORT).show();
                    }
                }

                //Stop service once it finishes its task
                stopSelf();
            }
        }).start();*/

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Log.d("", "onStartCommand: running");
                Toast.makeText(HelloService.this, "Service is Running", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this,6000);
            }
        }, 6000);

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;
        Toast.makeText(this, "destory", Toast.LENGTH_SHORT).show();

        Log.i(TAG, "Service onDestroy");
    }
}