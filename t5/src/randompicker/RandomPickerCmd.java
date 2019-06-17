/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompicker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class RandomPickerCmd {
    public static void main(String[] args) throws IOException {
        System.out.println("Informe o nome do arquivo: ");
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = scanner.nextLine();
        File file = new File("C:\\Users\\danie\\Desktop\\UFSM\\Ciência da Computação\\Paradigmas de Programação\\paradigmasdeprogramacao\\t5\\src\\randompicker\\"+nomeArquivo);
        Embaralhamento embaralhamento= new Embaralhamento();
        embaralhamento.leArquivo(file);
        embaralhamento.random("");
        for(int i=0; i<embaralhamento.getListaNomes().size(); i++){
            String enter = scanner.nextLine();
            if(enter.equals("")){
                System.out.println(embaralhamento.next());
            }
        }
        
    }
    
}
