/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Divam Shah
 */
public class CallCode extends ByteCode {

    private String labelname;
    private int NewAdd;
    private String baseid = "";
    private String arguments = "";

    @Override
    //Assigns the argument of the label
    public void init(ArrayList<String> args) {

        labelname = args.get(0);
        StringTokenizer tokenizer = new StringTokenizer(labelname, "<", false);
        baseid = tokenizer.nextToken();
    }

    @Override
    //Pushes the program counter in return address stack and sets the program counter to new address
    public void execute(VirtualMachine v) {

        v.pushpc();
        v.setpc(NewAdd);
        arguments = "";

        //Used when Dump is on
        for (int i = v.getRunStacksize() - 1; i >= v.getFramPointerPeek(); i--) {
            if (i + 1 == v.getRunStacksize()) {
                arguments = arguments + v.getRunStack().get(i);
            } else {
                arguments = arguments + v.getRunStack().get(i) + ",";
            }
        }
    }

    @Override
    public String toString() {
        return "CALL " + labelname + "      " + baseid + "(" + arguments + ")";
    }

    public String ReturnLabelName() {
        return labelname;
    }

    public void SetLabelName(int address) {
        NewAdd = address;
    }
}
