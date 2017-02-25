package lenguajeanbn;

import java.util.Scanner;
import java.util.Stack;

public class LanguageAnBn 
{
    /*
        S -> aA
        A -> Sb
        A -> b
    
            a   b
        S   aA  
        A   Sb  b
    */
    
    public boolean valida(String string)
    {
        Stack stack = new Stack();
        boolean value = true;
        stack.push('S');
        
        for (int i = 0; i < string.length(); i++) 
        {
            char temp = string.charAt(i);
            
            if(stack.empty())
            {
                value = false;
                break;
            }
            
            if(temp == 'b' && (Character)stack.peek() == 'S')
            {
                value = false;
                break;
            }
            
            if(temp == 'a' && (Character)stack.peek() == 'S')
            {
                stack.pop();
                stack.push('A');
                stack.push('a');
            }
            
            if(temp == 'a' && (Character)stack.peek() == 'A')
            {
                stack.pop();
                stack.push('b');
                stack.push('S');
                
                stack.pop();
                stack.push('A');
                stack.push('a');
                
            }
          
            if(temp == 'b' && (Character)stack.peek() == 'A')
            {
                stack.pop();
                stack.push('b');
            }
      
            if(temp == (Character)stack.peek()) 
            {
                stack.pop();
                value = true;
            }
        }
        
        if(!stack.empty())
        {
            value = false;
        }
        
        return value;
    }
    
    public static void main(String[] args) 
    {
        String string;
        Scanner in = new Scanner(System.in);
        LanguageAnBn language = new LanguageAnBn();
       
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
