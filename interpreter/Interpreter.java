package interpreter;

import java.io.*;

/**
 * <pre>
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the bytecodes from file
 *     3. Run the virtual machine
 * </pre>
 * 
 * This is an interpreter which uses virtual machine to interpret a language.
 * @author Divam Hiren Shah 
 */
public class Interpreter {

    private ByteCodeLoader bcl;

    //Initializes the hashmap
    public Interpreter(String codeFile) {
        try {
            CodeTable.init();
            bcl = new ByteCodeLoader(codeFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    void run() {

        //loads the bytecodes from fil
        Program program = bcl.loadCodes();
        VirtualMachine vm = new VirtualMachine(program);
        //Executes the bytecodes through virtual machine
        vm.executeProgram();
    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
        }
        (new Interpreter(args[0])).run();
    }
}
