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
    
  static void Upgrade(Regular c,FitnessCenter gym,FitnessCenter s_pool,FitnessCenter t_court,FitnessCenter y_center)
    {
        Members newMem=new Members(c.Name,c.CreditCardNumber,c.Age,c.RegistrationDate);
        newMem.client_id=c.client_id;
        gym.removeClient(c);
       
        c.facilities.clear();
        s_pool.removeClient(c);
        t_court.removeClient(c);
        y_center.removeClient(c);
        gym.addClient(newMem);
        s_pool.addClient(newMem);
        t_court.addClient(newMem);
        y_center.addClient(newMem);
    }
  
  static void DownGrade(Members m,FitnessCenter gym,FitnessCenter s_pool,FitnessCenter t_court,FitnessCenter y_center)
  {
      Regular newReg=new Regular(m.Name,m.CreditCardNumber,m.Age,m.RegistrationDate);
      newReg.client_id=m.client_id;
      
  }
    
}


