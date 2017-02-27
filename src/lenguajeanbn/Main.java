/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajeanbn;

import java.util.Scanner;

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class Main {
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
