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
public class ReturnCode extends ByteCode {

    private String labelname;
    private int NewAdd;
    private String baseid = "";
    private int value;

    @Override
    public void init(ArrayList<String> args) {
        if (args.size()> 1) {
            labelname = args.get(0);
            StringTokenizer tokenizer = new StringTokenizer(labelname, "<", false);
            baseid = tokenizer.nextToken();

        } else {
            labelname = "";
        }

    }

    @Override
    public void execute(VirtualMachine v) {

        v.setpc(v.poppc());
        v.popFrameRunStack();
        value = v.peekRunStack();

    }

    @Override
    public String toString() {
        if (baseid.equals("")) {
            return "RETURN " + labelname + "     " +"exit:"+ value;
        } else {
            return "RETURN " + labelname + "      exit " + baseid + ":" + value;
        }

    }

    public String ReturnLabelName() {
        return labelname;
    }

    public void SetLabelName(int address) {
        NewAdd = address;
    }
}
