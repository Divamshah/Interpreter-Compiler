/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *Takes argument and stores it.
 * @author Divam Shah
 */
public class LabelCode extends ByteCode {

    private String argument;

    @Override
    //Assigns the argument of the LABEL to arguments.
    public void init(ArrayList<String> args) {

        argument = args.get(0);
    }

    @Override
    //No execution is performed. 
    public void execute(VirtualMachine v) {

    }

    @Override
    public String toString() {
        return "LABEL " + argument;
    }

    public String ReturnLabelName() {
        return argument;
    }
}
