/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.*;

/**
 * It is an abstract class, with 2 abstract methods.
 *
 * @author Divam Shah
 */
public abstract class ByteCode {

    //Abstract classs will have 2 methods. execute and init
    //execute will be different for each key or subclasses.
    //init- initializes the ByteCode
    public abstract void execute(VirtualMachine v);

    public abstract void init(ArrayList<String> args);

}
