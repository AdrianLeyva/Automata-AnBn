package lenguajeanbn;

import java.util.Scanner;
import java.util.Stack;

public class LanguageAnBnCopy 
{
    /*
        S -> aA
        A -> Sb
        A -> b
    
            a   b
        S   aA  
        A   Sb  b
    */
    
    private void stackingString(String string, Stack stack){
        Stack temp = new Stack();
        for(int i=0;i<string.length();i++){
            temp.push(string.charAt(i));
        }
        while(!temp.empty()){
            stack.push(temp.pop());
        }
    }
    
    public boolean valida(String string)
    {
        Stack stackSym = new Stack();
        Stack stackStr = new Stack();
        boolean value = false;
        stackingString(string, stackStr);
        stackSym.push("$");
        stackSym.push("S");
        
        while(!value) 
        {
           String temp = String.valueOf(stackStr.peek());
            
            /*if(stackSym.empty())
            {
                value = false;
                break;
            }*/
            
            switch(temp){
                case "a":
                    if((String)stackSym.peek() == "S"){
                        stackSym.pop();
                        stackSym.push("S'");
                        stackSym.push("E");
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "E"){
                        stackSym.pop();
                        stackSym.push("E'");
                        stackSym.push("A");
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "A"){
                        stackSym.pop();
                        stackSym.push("a");
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
                    
                
                case "+":
                    if((String)stackSym.peek() == "S'"){
                        stackSym.pop();
                        stackSym.push("S'");
                        stackSym.push("E");
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "E'"){
                        stackSym.pop();
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
                    
                case "*":
                    if((String)stackSym.peek() == "E'"){
                        stackSym.pop();
                        stackSym.push("E'");
                        stackSym.push("A");
                        stackSym.push("*");
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
                    
                case "(":
                    if((String)stackSym.peek() == "S"){
                        stackSym.pop();
                        stackSym.push("S'");
                        stackSym.push("E");
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "E'"){
                        stackSym.pop();
                        stackSym.push("E'");
                        stackSym.push("A");
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "A"){
                        stackSym.pop();
                        stackSym.push(")");
                        stackSym.push("S");
                        stackSym.push("(");
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
                    
                case ")":
                    if((String)stackSym.peek() == "S'"){
                        stackSym.pop();
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "E'"){
                        stackSym.pop();
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
                    
                case "$":
                    if((String)stackSym.peek() == "S'"){
                        stackSym.pop();
                        continue;
                    }
                    
                    if((String)stackSym.peek() == "E'"){
                        stackSym.pop();
                        continue;
                    }
                    
                    if(((String)stackSym.peek()).equals(temp)){
                        stackSym.pop();
                        stackStr.pop();
                        continue;
                        //value = true;
                    }
                    break;
            }
            
            if(stackSym.empty() && stackStr.empty())
                value = true;
            
        }
        
        
        return value;
    }
    
    public static void main(String[] args) 
    {
        String string;
        Scanner in = new Scanner(System.in);
        LanguageAnBnCopy language = new LanguageAnBnCopy();
       
        System.out.println("Cadena: ");
        string = in.nextLine();
        
        if(language.valida(string))
        {
            System.out.println("Cadena válida");
        }
        else
        {
            System.out.println("Cadena inválida");
        }
    }
    
}
