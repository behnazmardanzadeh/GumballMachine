package com.algocoding;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    @Serial
    private static final long serialVersionUID = 2L;

    private final int count;
    private final String location;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        this.count = numberGumballs;
        this.location = location;
    }

    @Override
    public int getCount() throws RemoteException {
        return count;
    }

    @Override
    public String getLocation() throws RemoteException {
        return location;
    }
}
