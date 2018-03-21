/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * This halts the program. Sets the isRunning to false.
 *
 * @author Divam Shah
 */
public class HaltCode extends ByteCode {

    //execute here, halts the program
    @Override
    public void execute(VirtualMachine v) {

        v.setisRunning();
    }

    //Does not initialise anything 
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public String toString() {
        return "HALT";
    }

}
