/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * Loads the value from offset slot and pushes on the top of the stack
 *
 * @author Divam Shah
 */
public class LoadCode extends ByteCode {

    private int argument;
    private String id = "";

    @Override
    //initializes the arguments
    public void init(ArrayList<String> args) {

        if (args.size() > 1) {
            argument = Integer.parseInt(args.get(0));
            id = args.get(1);
        } else {
            argument = Integer.parseInt(args.get(0));
        }
    }

    @Override
    //Loads the value
    public void execute(VirtualMachine v) {

        v.loadRunStack(argument);
}

    @Override
    public String toString() {
        if (id.equals("")) {
            return "LOAD " + argument;
        } else {
            return "LOAD " + argument + " " + id + "     <load " + id + ">";
        }
    }

}
