/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l176310.java.concepts.clientInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rubab Tariq
 */
public class FitnessCenter 
{
    public int startTime;
    public int endTime;
    public int fee;
    static int NumberOfClients;
    
    private static List<Client> Clients_List=new ArrayList<>();
    
   public  void addClient(Client newClient)
    {
        Clients_List.add(newClient);
        NumberOfClients++;
    }
   public void removeClient(Client c)
    {
        Clients_List.remove(c);
        NumberOfClients--;
    }
    
    
    
}


