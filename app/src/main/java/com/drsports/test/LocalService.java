package com.drsports.test;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


/**
 * @author vson
 */
public class LocalService extends Service {

    private static String TAG = "LocalService";

    public LocalBinder binder = new LocalBinder();

    private CallBack callBack;

    public interface CallBack {
        /**
         * 消息
         *
         * @param str
         */
        void onCallBack(String str);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    private Handler mHandler;

    public class LocalBinder extends Binder {
        public LocalService getService() {
            return LocalService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mHandler != null) {
                    callBack.onCallBack("this is message");
                    mHandler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind: ");
        super.onRebind(intent);
    }


    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.d(TAG, "bindService: ");
        return super.bindService(service, conn, flags);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d(TAG, "unbindService: ");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        mHandler = null;
        super.onDestroy();
    }
}
