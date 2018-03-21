/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *Prints the value on the console
 * @author Divam Shah
 */
public class WriteCode extends ByteCode
{
    @Override
    //No initialization required
    public void init(ArrayList<String> args){
     
    }
    
    @Override
    //Prints 
    public void execute(VirtualMachine v) {
       
        System.out.println(v.peekRunStack());
    }
    @Override
    public String toString()
    {
        return "WRITE";
    }
}