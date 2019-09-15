/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l176310.java.concepts;

import java.lang.reflect.Member;
import java.util.Scanner;
import l176310.java.concepts.clientInfo.Client;
import l176310.java.concepts.clientInfo.FitnessCenter;
import l176310.java.concepts.clientInfo.Members;
import l176310.java.concepts.clientInfo.Regular;

/**
 *
 * @author Rubab Tariq
 */
public class L176310JavaConcepts 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //QUESTION 1
       // Game g1=new Game();
       // g1.Run();
        
       
        
        //QUESTION2
        Driver();
        
    }
    
    static void Driver()
    {
        FitnessCenter f1=new Gym();
        FitnessCenter f2=new SwimmingPool();
        FitnessCenter f3=new TennisCourt();
        FitnessCenter f4=new YogaCenter();
          
        
        Regular c1=new Regular("Hamza",123456,19,"12-8-19");
        Members c2=new Members("Hassan",129877,24,"15-9-19");
        String CurrDate="14-9-19";
        
        c1.SetClientID(1);
        c2.SetClientID(2);
       
        
        f1.addClient(c1);
        f1.addClient(c2);
        c1.availFacility(f1);
        
        System.out.println("Press 1 if you are a member.Press 2 if you are a regular client");
        Scanner input=new Scanner(System.in);
        int clientType=input.nextInt();
        if(clientType==2)
        {
            System.out.println("Press 1 if you want to join the Swimming Pool.Press 2 to join TennisCourt.Press 3 to join yogaCenter");
            int choice=input.nextInt();
            switch(choice)
            {
                case 1:
                    c1.availFacility(f2);
                    break;
                case 2:
                    c1.availFacility(f3);
                    break;
                case 3:
                    c1.availFacility(f4);
                    break;
            } 
            
           System.out.println("Your fee is  "+ c1.CalculateFee());
           String dueDate=(c1.CalculateDueDate());
           if(c1.RemoveOrKeep(dueDate,CurrDate)) 
           {
               f1.removeClient(c1);
           }
        }
      if(clientType==1)
      {
           System.out.println("Your fee is  "+ c2.CalculateFee());
           String dueDate=(c2.CalculateDueDate());
           if(c2.RemoveOrKeep(dueDate,CurrDate)) 
           {
               f1.removeClient(c2);
           }
        
      }
        
       
    }
}
