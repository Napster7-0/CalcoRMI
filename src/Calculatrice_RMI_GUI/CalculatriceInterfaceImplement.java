/*
    * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculatrice_RMI_GUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


/**
 *
 * @author Dell
 */
public class CalculatriceInterfaceImplement extends UnicastRemoteObject implements CalculatriceInterface {

    public CalculatriceInterfaceImplement() throws RemoteException {
        super();
    }
    /**
        * Cette méthode exécute une expression Python et renvoie le résultat.
        *
        * @param str L'expression Python à évaluer
        * @return Le résultat de l'expression Python (sous forme de chaîne)
        * @throws RemoteException En cas d'erreur lors de l'exécution
     */
    public String Calculator (String str) throws RemoteException {
        try {
            // Construit la commande pour démarrer l'interpréteur Python
            String command = "python -c \"import sys; print(eval(sys.argv[1]))\" " + str;

            // Crée un ProcessBuilder pour exécuter la commande
            Process process = Runtime.getRuntime().exec(command);

            // Lit la sortie du processus
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Attend que le processus se termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return output.toString().trim(); // Supprime les espaces en début et fin de chaîne
            } else {
                System.err.println("Erreur lors de l'exécution de la commande shell. Code de sortie : " + exitCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RemoteException("Erreur : veuillez entrer un opérateur valide");
        }
    }
}