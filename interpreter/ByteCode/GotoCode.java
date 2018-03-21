/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *This directs the start of the program or transfers the control of the program. 
 * @author Divam Shah
 */
public class GotoCode extends ByteCode {

    private String labelname;
    private int NewAdd;

    @Override
    public void init(ArrayList<String> args) {
        labelname = args.get(0);
    }

    @Override
    public void execute(VirtualMachine v) {

        v.setpc(NewAdd);
    }

    @Override
    public String toString() {
        return "GOTO " + labelname;
    }

    public String ReturnLabelName() {
        return labelname;
    }

    public void SetLabelName(int address) {
        NewAdd = address;
    }
}
