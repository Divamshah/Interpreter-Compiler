/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *Performs arithmetic operations.
 * @author Divam Shah
 */
public class BopCode extends ByteCode
{
    private String argument;
    
    @Override
    //Assigns the argument of the label
    public void init(ArrayList<String> args){
        argument=args.get(0);
    }
    
    @Override
    //Performs +,-,/,* and other logical operators
    public void execute(VirtualMachine v) {
       
        
        int Op1=v.popRunStack();    //Top element
        int Op2=v.popRunStack();    //Second from top
        
        switch (argument) {
            case "+":
                v.pushRunStack(Op2+Op1);
                break;
            case "-":
                v.pushRunStack(Op2-Op1);
                break;
            case "*":
                v.pushRunStack(Op2*Op1);
                break;
            case "/":
                v.pushRunStack(Op2/Op1);
                break;
            case "==":
                if(Op2==Op1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            case "!=":
                if(Op2!=Op1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            case "<=":
                if(Op2<=Op1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            case ">":
                if(Op2>Op1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            case "<":
                if(Op2<Op1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            case "&":
                if(Op2==1 && Op1==1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;     
        
            case "|":
                if(Op2==1 || Op1==1)
                    v.pushRunStack(1);
                else
                    v.pushRunStack(0);
                break;
            default:
                //Invalid operator
                System.out.println("Invalid Operator");
                break;
        }
   }
    @Override
    public String toString()
    {
        return "BOP "+argument;
    }
    
}