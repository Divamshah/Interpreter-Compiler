/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * This acts like if and else. if 0 goes to the label. else continues. 
 *
 * @author Divam Shah
 */
public class FalseBranchCode extends ByteCode {

    private String labelname;
    private int NewAdd;

    @Override

    public void init(ArrayList<String> args) {
        labelname = args.get(0);
    }

    @Override
    //Goes to the label if it is 0
    public void execute(VirtualMachine v) {
        if (v.popRunStack() == 0) {
            v.setpc(NewAdd);
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + labelname;
    }

    public String ReturnLabelName() {
        return labelname;
    }

    public void SetLabelName(int address) {
        NewAdd = address;
    }
}
