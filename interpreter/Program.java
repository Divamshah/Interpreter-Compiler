package interpreter;

import interpreter.ByteCode.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public ArrayList getProgram() {
        return program;
    }

    /**
     * This function goes through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these are converted into
     * correct addresses so the VirtualMachine knows what to set the Program
     * Counter(PC)
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {

        HashMap<String, Integer> Label = new HashMap<>();  //Hashmap stores the lable argument and corresponding address or index number.
        String arguments = "";

        for (int i = 0; i < program.getSize(); i++) {
            if (this.program.get(i).getClass().getName().equals("interpreter.ByteCode.LabelCode")) {
                arguments = ((LabelCode) program.program.get(i)).ReturnLabelName();
                Label.put(arguments, i);
            }
        }

        for (int i = 0; i < program.getSize(); i++) {

            //CALLCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.CallCode")) {
                CallCode callCode = ((CallCode) program.program.get(i));        //Stores the instance
                arguments = callCode.ReturnLabelName();                         //Assigns the argument of lable to arguments
                callCode.SetLabelName(Label.get(arguments));    //the hashmap assings the index of the LABEL arg to callCode argument
            }

            //GOTOCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.GotoCode")) {
                GotoCode gotoCode = ((GotoCode) program.program.get(i));        //Stores the instance
                arguments = gotoCode.ReturnLabelName();                         //Assigns the argument of lable to arguments
                gotoCode.SetLabelName(Label.get(arguments));  //the hashmap assings the index of the LABEL arg to gotoCode argument
            }
            //FALSEBRANCHCODE
            if (program.program.get(i).getClass().getName().equals("interpreter.ByteCode.FalseBranchCode")) {
                FalseBranchCode falsebranchCode = ((FalseBranchCode) program.program.get(i)); //Stores the instance
                arguments = falsebranchCode.ReturnLabelName();                              //Assigns the argument of lable to arguments
                falsebranchCode.SetLabelName(Label.get(arguments));     //the hashmap assings the index of the LABEL args to falsebranchcode
            }

        }

    }

}
