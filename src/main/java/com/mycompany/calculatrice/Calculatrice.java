  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatrice;
import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author Dell
 */
public class Calculatrice {

    public static void main(String[] arg)
        throws IOException, InterruptedException {
        try{// objet ProcessBuilder pour executer le script python avec la donnee en argument
            String line = null;
            
            ProcessBuilder pb = new ProcessBuilder("C:/Users/Dell/Documents/NetBeansProjects/Calculatrice/src/"
                    + "main/java/com/mycompany/calculatrice/eval.py","2+3");
            // build.directory(new File("src"));
            // demarrage du processus
            // Process process = pb.start();
            /* lecture de la sortie du processus python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String output = reader.readLine();
             attendre la fin du processus*/
            // process.waitFor();
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
            try{
                File file = new File("C:/Users/Dell/Documents/NetBeansProjects/Calculatrice/"
                        + "src/main/java/com/mycompany/calculatrice/fic.txt");
                Scanner scanner = new Scanner(file);
                line = scanner.nextLine();
            }catch(Exception e){
                
            }
            // utiliser la valeur renvoyée par le programme python
            
             //line;
        }catch(Exception e){
            e.printStackTrace();
            //return null;
        }
    }
}
