/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Calculatrice_RMI_GUI;
import java.rmi.Remote;
/**
 *
 * @author Dell
 */
public interface CalculatriceInterface extends Remote{
    public String Calculator(String str) throws Exception;
         
}
