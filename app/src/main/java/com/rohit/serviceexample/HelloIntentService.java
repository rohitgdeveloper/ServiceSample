package com.rohit.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class HelloIntentService extends IntentService {

  /**
   * A constructor is required, and must call the super IntentService(String)
   * constructor with a name for the worker thread.
   */
  public HelloIntentService() {
      super("HelloIntentService");
  }

  /**
   * The IntentService calls this method from the default worker thread with
   * the intent that started the service. When this method returns, IntentService
   * stops the service, as appropriate.
   */
  @Override
  protected void onHandleIntent(Intent intent) {
      // Normally we would do some work here, like download a file.
      // For our sample, we just sleep for 5 seconds.
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

  }
}