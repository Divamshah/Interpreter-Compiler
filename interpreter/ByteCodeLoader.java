package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.ByteCode.*;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = " ";
    private String nextLine = "";
    private String codeClass = "";
    
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function reads one line of source code at a time. For each line it
     * does the following: Tokenizes the string to break it into parts. Grabs
     * correct class name for the given bytecode from CodeTable, creates an
     * instance of the bytecode class name returned from code table. It Parses
     * any additional arguments for the given bytecode and sends them to the
     * newly created bytecode instance via the init function.
     * @return program 
     */
    public Program loadCodes() {

        ArrayList<String> argvalue;     //Stores the arguments of the label
        int size = 0;                   //Keeps the size of the array argvalue.
        
        program = new Program();
        while (true) {
            try {
                nextLine = this.byteSource.readLine();
                if (nextLine == null) {
                    break;
                }
                
                //Tokenizer handles each token. 
                tokenizer = new StringTokenizer(nextLine, DELIMITERS, false);
                
                while (tokenizer.hasMoreTokens()) {
                    codeClass = CodeTable.getClassName(tokenizer.nextToken());
                    try {
                        //bytecode stores the instance which are created dynamically 
                        ByteCode bytecode = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());
                        argvalue = new ArrayList<>();
                        while (tokenizer.hasMoreTokens()) {
                           //Arguments are added in the array
                            argvalue.add(tokenizer.nextToken());
                            size++;
                        }
                        size = 0;
                        //arguments are initialized
                        bytecode.init(argvalue);
                        //instances of bytecodes are stored in the program arraylist
                        this.program.getProgram().add(bytecode);
                    } catch (Exception e) {
                        System.out.println("Instantiating Error");
                    }
                }
            } catch (IOException ex) {
                break;
            }
        }
        //Resolve Address for GOTO,CALL and FALSEBRANCH
        this.program.resolveAddrs(program);
        return this.program;
    }
}
