package lenguajeanbn;

import java.util.Scanner;
import java.util.Stack;

public class LanguageAnBn 
{
    
    //Crea la pila de la cadena introducida por el usuario
    private void stackingString(String string, Stack stack){
        Stack temp = new Stack();
        for(int i=0;i<string.length();i++){
            temp.push(string.charAt(i));
        }
        
        stack.push("$");
        while(!temp.empty()){
            stack.push(temp.pop());
        }
    }
    
    //Imprime las pilas símbolos y cadena
    private void printStacks(Stack sym, Stack str){
        System.out.print("Pila de símbolos:  ");
        System.out.println(sym.toString());
        System.out.print("Pila de cadena:  ");
        System.out.println(str.toString() + "\n\n");
    }
    
    /*
        Verifica si una cadena es válida para la gramática establecida, cuando ambas pilas estén vacías
        entonces significa que la cadena fue aceptada.
    */
    public boolean valida(String string)
    {
        Stack stackSym = new Stack();
        Stack stackStr = new Stack();
        boolean value = false;
        boolean flag = true;
        stackingString(string, stackStr);
        stackSym.push("$");
        stackSym.push("S");
        
        while(flag) 
        {
            printStacks(stackSym, stackStr);
            
            if(stackSym.empty() && stackStr.empty()){
                value = true;
                flag = false;
                break;
            }
            
            
           String temp = String.valueOf(stackStr.peek());
            
            
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
                    
                    else{
                        value = false;
                        flag = false;
                    }
                    
                    break;
                    
                
                case "+":
                    if((String)stackSym.peek() == "S'"){
                        stackSym.pop();
                        stackSym.push("S'");
                        stackSym.push("E");
                        stackSym.push("+");
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
                    
                    else{
                        value = false;
                        flag = false;
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
                    
                    else{
                        value = false;
                        flag = false;
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
                    
                    else{
                        value = false;
                        flag = false;
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
                    
                    else{
                        value = false;
                        flag = false;
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
                    
                    else{
                        value = false;
                        flag = false;
                    }
                    break;
                    
                default:
                    value = false;
                    flag = false;
                    break;
            }
            
            
        }
        
        
        return value;
    }
    
    
}
