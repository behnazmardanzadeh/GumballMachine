package com.algocoding;

import java.rmi.Naming;

public class GumballProxyTestDrive {

    public static void main(String[] args) {

//        "rmi://santafe.mightygumball.com/gumballmachine",
//        "rmi://boulder.mightygumball.com/gumballmachine",
//        "rmi://austin.mightygumball.com/gumballmachine"

        String[] location = {
                "rmi://localhost/gumballmachine"
        };

        GumballProxy[] monitor = new GumballProxy[location.length];

        for (int i=0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballProxy(machine);
                System.out.println("monitor: " + monitor[i]);
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (GumballProxy gumballProxy : monitor) {
            gumballProxy.report();
            System.out.println("------------------------------");
        }
    }
}
