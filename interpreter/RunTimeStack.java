package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        //point of our language, so its frame pointer is 0.
        framePointer.push(0);

    }

    //Returns the the top/last element of the arraylist
    public int peek() {
        return (int) runTimeStack.get(runTimeStack.size() - 1);

    }

    //Pops the the top/last element of the arraylist
    public int pop() {

        int popItem = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return popItem;

    }

    //Pushes an element in arraylist
    public int push(int i) {

        runTimeStack.add(i);
        return i;
    }

    //Create a newFrameAt a given offset
    public void newFrameAt(int offset) {
        framePointer.push(offset);

    }

    //Pops elements until, it reaches the previous framePointer.
    public void popFrame() {
        int savedValue = this.pop();
        int size = runTimeStack.size();
        for (int i = size; i > framePointer.peek(); i--) {
            pop();
        }
        //FramePointer gets popped
        framePointer.pop();
        this.push(savedValue);
    }

    //Stores the element at desired offeset in the stack
    public int store(int offset) {
        int savedValue = this.pop();
        pop();
        runTimeStack.add(framePointer.peek() + offset, savedValue);
        return savedValue;
    }

    //Loads the element from the desired offset and pushes on the top.
    public int load(int offset) {
        int temp = (int) runTimeStack.get(framePointer.peek() + offset);
        push(temp);
        return temp;
    }

    //Gives the index of a desired element
    public int getIndex(int i) {
        return runTimeStack.indexOf(i);
    }

    //Prints the trace of the runTimeStack and FramePointers.
    public void dump() {

        for (int i = 0; i < framePointer.size(); i++) {
            System.out.print("[");
            if (i + 1 < framePointer.size()) {
                for (int j = framePointer.get(i); j < framePointer.get(i + 1); j++) {
                    if (j + 1 == framePointer.get(i + 1)) {
                        System.out.print("" + runTimeStack.get(j));
                    } else {
                        System.out.print("" + runTimeStack.get(j) + ",");
                    }
                }
            } else {
                for (int m = framePointer.get(i); m < runTimeStack.size() && !runTimeStack.isEmpty(); m++) {
                    if (m + 1 == runTimeStack.size()) {
                        System.out.print("" + runTimeStack.get(m));
                    } else {
                        System.out.print("" + runTimeStack.get(m) + ",");
                    }
                }
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    //Returns the size of the RunTimeStack
    public int RunStackSize() {
        return runTimeStack.size();
    }

    //Returns the top FramePointer
    public int FrameStackPeek() {
        return framePointer.peek();
    }

    //Returns the RunTimeStackArray
    public ArrayList RuntimeStackArray() {
        return runTimeStack;
    }

}
