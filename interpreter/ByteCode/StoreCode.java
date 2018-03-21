/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * Stores the value into offset.
 *
 * @author Divam Shah
 */
public class StoreCode extends ByteCode {

    private int argument;
    private String id = "";
    private int value;

    @Override
    //Assigns the value to arguments
    public void init(ArrayList<String> args) {

        if (args.size() > 1) {
            argument = Integer.parseInt(args.get(0));
            id = args.get(1);
        } else {
            argument = Integer.parseInt(args.get(0));
        }
    }

    @Override
    //Stores the value
    public void execute(VirtualMachine v) {

        value = v.storeRunStack(argument);

    }

    @Override
    public String toString() {

        if (id.equals("")) {
            return "STORE " + argument;
        } else {
            return "STORE " + argument + " " + id + "     " + id + "=" + value;
        }

    }
}
