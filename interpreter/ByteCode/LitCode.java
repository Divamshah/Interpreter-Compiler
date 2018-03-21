/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * Pushes an integer 
 * @author Divam Shah
 */
public class LitCode extends ByteCode {

    private int argument;
    private String id = "";

    @Override
    //Assigns the argument.
    public void init(ArrayList<String> args) {

        if (args.size() > 1) {
            argument = Integer.parseInt(args.get(0));
            id = args.get(1);
        } else {
            argument = Integer.parseInt(args.get(0));
        }
    }

    @Override
    //Pushes an integer in the stack
    public void execute(VirtualMachine v) {
        v.pushRunStack(argument);
    }

    @Override
    public String toString() {
        if (id.equals("")) {
            return "LIT " + argument;
        } else {
            return "LIT " + argument + "  " + id + "      int " + id;
        }
    }

}
