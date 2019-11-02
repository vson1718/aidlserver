package com.drsports.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.drsports.server.IMyAidlInterface;
import com.drsports.server.Person;

import java.util.List;

/**
 * @author vson
 */
public class MainActivity extends AppCompatActivity {


    private ComponentName remoteServer;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBindService();
    }


    /**
     * onStartServer 点击事件
     *
     * @param view
     */
    public void onStartServer(View view) {
        startService(new Intent(this, MyService.class));
    }


    private LocalService localService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalService.LocalBinder binder = (LocalService.LocalBinder) service;
            localService = binder.getService();
            localService.setCallBack(new LocalService.CallBack() {
                @Override
                public void onCallBack(String str) {
                    if (getMainLooper() == Looper.getMainLooper()) {
                        Log.d("TAG", "onCallBack:=====> " + str);
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } else {
                        Log.d("TAG", "onCallBack: " + str);
                    }
                }
            });

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            localService = null;
        }
    };

    /**
     * onBindServer点击事件
     *
     * @param view
     */
    public void onBindServer(View view) {
        intent = new Intent(this, LocalService.class);
        bindService(intent, connection, Service.BIND_AUTO_CREATE);
    }


    /**
     * onAIDLServer点击事件
     *
     * @param view
     */
    public void onAIDLServer(View view) {
        try {
            myAidlInterface.addPerson(new Person("vson", 2));
            List<Person> mList = myAidlInterface.getPersonList();
            Log.d("sss", mList.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private IMyAidlInterface myAidlInterface;

    private ServiceConnection connection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myAidlInterface = null;
        }
    };


    public void myBindService() {
        Intent intent = new Intent();
        remoteServer = new ComponentName("com.drsports.server", "com.drsports.server.AidlService");
        intent.setComponent(remoteServer);
        bindService(intent, connection2, Service.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null) {
            unbindService(connection);
        }
        if (remoteServer != null) {
            unbindService(connection2);
        }
    }


}
