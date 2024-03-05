/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculatrice_RMI_GUI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dell
 */
public class ServerRMI {
    public static void main(String[] args){
        try {
            // Création d'une nouvelle instance de l'implémentation de l'interface "CalculatriceInterface"
            CalculatriceInterface service = new CalculatriceInterfaceImplement();

            // Création d'un nouveau registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Liaison de l'objet "service" au nom "Calculatrice" dans le registre
            registry.rebind("Calculatrice", service);

            // Impression d'un message indiquant que le serveur RMI est prêt
            System.out.println("ServeurRMI prêt !");
        } catch (Exception e) {
            // Impression de l'exception en cas d'erreur
            System.out.println(e);
       }

    }
}
