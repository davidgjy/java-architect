package com.genesis.architect.rmi.simple;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by KG on 2016/12/3.
 */
public interface HelloService extends Remote {
    String sayHello(String someOne) throws RemoteException;
}
