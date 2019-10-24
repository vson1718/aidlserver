package com.drsports.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vson
 */
public class AidlService extends Service {


    private ArrayList<Person> mList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "onCreate: 开始");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "onStartCommand:开始 ");
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mList = new ArrayList<>();
        return binder;
    }

    private IBinder binder = new IMyAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            mList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return mList;
        }
    };


}
