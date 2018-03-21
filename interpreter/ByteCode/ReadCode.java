/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads an integer from the user
 *
 * @author Divam Shah
 */
public class ReadCode extends ByteCode {

    @Override
    //No inialization required 
    public void init(ArrayList<String> args) {

    }

    @Override
    //Prompts the user to enter the integer
    public void execute(VirtualMachine v) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number");
        v.pushRunStack(in.nextInt());
    }

    @Override
    public String toString() {
        return "READ";
    }
}
