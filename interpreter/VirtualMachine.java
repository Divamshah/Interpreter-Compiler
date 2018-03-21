package interpreter;

import java.util.*;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;
    private Stack returnAddrs;
    private boolean isRunning;
    private Program program;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);     //This here is the virtual machine, passed to the execute method
            if (dump == true) {
                System.out.println(code);
                runStack.dump();  //Check that the operation is correct
            }
            pc++;
        }
    }

    //Pops the top of the runStack
    public int popRunStack() {
        return runStack.pop();
    }

    //Peeks the top of the runStack
    public int peekRunStack() {
        return runStack.peek();
    }

    //Pushes in the runStack
    public int pushRunStack(int i) {
        return runStack.push(i);
    }

    //Creates a newFrame at the given offset
    public void newFrameAtRunStack(int offset) {
        runStack.newFrameAt(offset);
    }

    //Pops Frame pointer, when return
    public void popFrameRunStack() {
        runStack.popFrame();
    }

    //Stores the popped value into offset at n, from the start of the frame
    public int storeRunStack(int offset) {
        return runStack.store(offset);
    }

    //Pushes the value into offet slot, from the start of the frame
    public int loadRunStack(int offset) {
        return runStack.load(offset);
    }

    //Return program counter
    public int getpc() {
        return pc;
    }

    //Sets program counter
    public void setpc(int i) {
        pc = i;
    }

    //Pushes the program counter onto returnAddrs stack
    public void pushpc() {
        returnAddrs.push(getpc());
    }

    //Pops the program coutner from returnAddrs stack
    public int poppc() {
        return (int) returnAddrs.pop();
    }

    //Sets isRunning false, used for halt code
    public void setisRunning() {
        isRunning = false;
    }

    //Calls the dump function
    public void runStackdump() {
        runStack.dump();
    }

    //Returns the size of the runStack
    public int getRunStacksize() {
        return runStack.RunStackSize();
    }

    //peeks the FramePointer
    public int getFramPointerPeek() {
        return runStack.FrameStackPeek();
    }

    //Handles the Dumpswitch
    public void DumpSwitch(boolean Dumpswitch) {
        dump = Dumpswitch;
    }

    //Returns the RuntimeStack array
    public ArrayList getRunStack() {
        return runStack.RuntimeStackArray();
    }
}
