package com.algocoding;

import java.rmi.Naming;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count;
        if (args.length < 2) {
//          java GumballMachineTestDrive santafe.mightygumball.com 100
//          java GumballMachineTestDrive boulder.mightygumball.com 100
//          java GumballMachineTestDrive austin.mightygumball.com 250

//          java com.algocoding.server.GumballMachineTestDrive localhost 100


            //                           rmi://127.0.0.1
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        try {
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
