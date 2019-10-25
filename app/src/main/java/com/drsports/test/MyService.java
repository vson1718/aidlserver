package com.drsports.test;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author vson
 */
public class MyService extends Service {

    private final static String TAG = "Service";
    private Handler mHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: 开始");
        return null;
    }


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: 开始");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: 开始");
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (mHandler != null) {
                    Log.d(TAG, "do something");
                    mHandler.postDelayed(this, 1000);
                }
            }
        }, 1000);

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: 开始");
        return super.onUnbind(intent);
    }


    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.d(TAG, "bindService: 开始");
        return super.bindService(service, conn, flags);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d(TAG, "unbindService: 开始");
        super.unbindService(conn);

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: 开始");
        mHandler = null;
        super.onDestroy();
    }
}
