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
        try{
            CalculatriceInterface service = new CalculatriceInterfaceImplement();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculatrice", service);
            System.out.println("ServeurRMI prêt !");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
