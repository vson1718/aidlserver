package com.drsports;


/**
 * @author Vson
 * 项目描述:这个是客户端AIDL自动生成的，里面有注释过程
 */
public interface IMyAidlInterface extends android.os.IInterface {
    /**
     * Default implementation for IMyAidlInterface.
     */
    public static class Default implements IMyAidlInterface {
        @Override
        public void addPerson(com.drsports.server.Person person) throws android.os.RemoteException {
        }

        @Override
        public java.util.List<com.drsports.server.Person> getPersonList() throws android.os.RemoteException {
            return null;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements IMyAidlInterface {
        //描述符
        private static final java.lang.String DESCRIPTOR = "IMyAidlInterface";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            //挂载接口
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an IMyAidlInterface interface,
         * generating a proxy if needed.
         * *将一个IBinder对象转换成com.drsports.server.IMyAidlInterface接口,
         * *如果需要，生成代理。(动态代理)
         */
        public static IMyAidlInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IMyAidlInterface))) {
                //查看是否本地接口，如果是本地接口，直接返回
                return ((IMyAidlInterface) iin);
            }
            //如果是不是本地接口，远程获取一个接口（句柄）
            return new IMyAidlInterface.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            java.lang.String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_addPerson: {
                    data.enforceInterface(descriptor);
                    com.drsports.server.Person _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.drsports.server.Person.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.addPerson(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPersonList: {
                    data.enforceInterface(descriptor);
                    java.util.List<com.drsports.server.Person> _result = this.getPersonList();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements IMyAidlInterface {

            //内部对象
            public static IMyAidlInterface sDefaultImpl;

            //发送数据（远程IBinder）
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                //获取远程IBinder
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                //获取描述符
                return DESCRIPTOR;
            }

            @Override
            public void addPerson(com.drsports.server.Person person) throws android.os.RemoteException {
                //客户端发送数据
                android.os.Parcel _data = android.os.Parcel.obtain();
                //服务端返回数据
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    //C层校验数据
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((person != null)) {
                        _data.writeInt(1);
                        person.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    //调用服务端方法，将客服端挂起，直到服务端返回数据
                    //flags 是0表示客户端和服务端相互通信；是1表示客户端只能发送，服务端不能返回数据
                    //Stub.TRANSACTION_addPerson方法ID
                    boolean _status = mRemote.transact(Stub.TRANSACTION_addPerson, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().addPerson(person);
                        return;
                    }
                    //读取异常
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.util.List<com.drsports.server.Person> getPersonList() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<com.drsports.server.Person> _result;
                try {
                    //C层校验数据
                    _data.writeInterfaceToken(DESCRIPTOR);
                    //调用服务端方法，将客服端挂起，直到服务端返回数据
                    //flags 是0表示客户端和服务端相互通信；是1表示客户端只能发送，服务端不能返回数据
                    //Stub.TRANSACTION_addPerson方法ID
                    //这个方法代表着进入内核的Biner中，经过Biner一系列处理，进入服务端，调用服务端transact方法
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPersonList, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getPersonList();
                    }
                    _reply.readException();
                    //读取数据
                    _result = _reply.createTypedArrayList(com.drsports.server.Person.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

        }

        static final int TRANSACTION_addPerson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getPersonList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

        public static boolean setDefaultImpl(IMyAidlInterface impl) {
            if (Stub.Proxy.sDefaultImpl == null && impl != null) {
                Stub.Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IMyAidlInterface getDefaultImpl() {
            return Stub.Proxy.sDefaultImpl;
        }
    }


    public void addPerson(com.drsports.server.Person person) throws android.os.RemoteException;

    public java.util.List<com.drsports.server.Person> getPersonList() throws android.os.RemoteException;
}
