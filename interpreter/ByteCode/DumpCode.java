/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * Takes care of dumping. Used for debugging while, tracing the execution of the
 * runtime stack and active frame pointers
 *
 * @author Divam Shah
 */
public class DumpCode extends ByteCode {

    private String switcher;

    //Assigns the arguments of the label to argument
    @Override
    public void init(ArrayList<String> args) {
        switcher = args.get(0);
    }

    //Handles the swtich
    @Override
    public void execute(VirtualMachine v) {
        if (switcher.equals("ON")) {
            v.DumpSwitch(true);
        }
        if (switcher.equals("OFF")) {
            v.DumpSwitch(false);
        }
    }

    @Override
    public String toString() {
        return "DUMP " + switcher;
    }
}
