package com.algocoding;

import java.rmi.RemoteException;

public class GumballProxy {
    GumballMachineRemote machine;

    public GumballProxy(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
