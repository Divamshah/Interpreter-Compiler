/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Divam Shah
 */
public class ArgsCode extends ByteCode {

    private int argument;

    @Override
    //Assigns the argument of the label
    public void init(ArrayList<String> args) {
        argument = Integer.parseInt(args.get(0));

    }

    @Override
    //Create a newFrame at desired position 
    public void execute(VirtualMachine v) {
        v.newFrameAtRunStack(v.getRunStacksize() - argument );
    }

    @Override
    public String toString() {
        return "ARGS " + argument;
    }

}
