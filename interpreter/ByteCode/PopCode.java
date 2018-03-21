/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * Pops the top of the stack or further.
 *
 * @author Divam Shah
 */
public class PopCode extends ByteCode {

    private int argument;

    @Override
    //Assigns the argument 
    public void init(ArrayList<String> args) {
        argument = Integer.parseInt(args.get(0));
    }

    @Override
    //Pops until required
    public void execute(VirtualMachine v) {

        for (int i = 0; i < argument && v.getRunStacksize() != v.getFramPointerPeek(); i++) {
            v.popRunStack();
        }

    }

    @Override
    public String toString() {
        return "POP " + argument;
    }

}
