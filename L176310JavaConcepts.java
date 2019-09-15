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
import static l176310.java.concepts.clientInfo.FitnessCenter.DownGrade;
import static l176310.java.concepts.clientInfo.FitnessCenter.Upgrade;
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
      //  Game g1=new Game();
        //g1.Run();
        
       
        
        //QUESTION2
        Driver();
        
    }
    
    static void Menu()
    {
        FitnessCenter f1=new Gym();
        FitnessCenter f2=new SwimmingPool();
        FitnessCenter f3=new TennisCourt();
        FitnessCenter f4=new YogaCenter();
        
        Scanner input=new Scanner(System.in);
           String CurrDate="14-9-19";
        
      
        System.out.println("Enter your name");
        String name=input.next();
        System.out.println("Enter your cnic");
        int cnic=input.nextInt();
        System.out.println("Enter your age");
        int age=input.nextInt();
       
       
        System.out.println("Press 1 to be a member and Press 2 to be a Regular client");
        int choice= input.nextInt();
        if(choice==1)
        {
            Members m1=new Members(name,cnic,age,"11-8-19");
            m1.client_id=1;
            m1.Avail(f1, f2, f3, f4);
            System.out.println("Press 1 to be see due date+fees");
                choice=input.nextInt();
                if(choice==1)
                {
                   String DueDate= m1.CalculateDueDate(); 
                   System.out.println("DueDate:  "+DueDate);
                   int fee=m1.CalculateFee();
                   System.out.println("Fee:  "+fee);
                   
                    boolean trig=m1.RemoveOrKeep(DueDate, CurrDate);
                    if(trig==false)
                    {
                        System.out.println("Press 2 to pay fee");
                        choice=input.nextInt();
                        if(choice==2 )
                        {
                            m1.payFee(CurrDate);
                            System.out.println("Press 1 to Request DownGrade");
                          choice=input.nextInt();
                          if(choice==1)
                          {
                           DownGrade(m1,f1,f2,f3,f4);
                          }
                        }
                    }
                }
        }
        else if(choice==2)
        {
            Regular r1=new Regular(name,cnic,age,"15-7-19");
            r1.client_id=1;
            f1.addClient(r1);
            r1.availFacility(f1);
            
            System.out.println("In how many facilities do you want to register?");
            int count=input.nextInt();
            if (count <4)
            {
                for(int i=0;i<count;i++)
                {
                    System.out.println(" \n Press 1 if you want to join the Swimming Pool.Press 2 to join TennisCourt.Press 3 to join yogaCenter");
                     choice=input.nextInt();
                    switch(choice)
                    {
                        case 1:
                            r1.availFacility(f2);
                            break;
                        case 2:
                            r1.availFacility(f3);
                            break;
                        case 3:
                            r1.availFacility(f4);
                            break;
                    } 
                }
            }
                System.out.println("Press 1 to be see due date+fees");
                choice=input.nextInt();
                if(choice==1)
                {
                   String DueDate= r1.CalculateDueDate();
                   System.out.println("DueDate:  "+DueDate);
                   int fee=r1.CalculateFee();
                   System.out.println("Fee:  "+fee);
                   boolean trig=r1.RemoveOrKeep(DueDate, CurrDate);
                    if(trig==false)
                    {
                        System.out.println("Press 2 to pay fee");
                        choice=input.nextInt();
                        if(choice==2 )
                        {
                            r1.payFee(CurrDate);
                            System.out.println("Press 1 to Request Upgrade");
                          choice=input.nextInt();
                          if(choice==1)
                          {
                           Upgrade(r1,f1,f2,f3,f4);
                          }
                        }
                    }
                }
            
              
        }
    }
    
    static void Driver()
    {
                
         Menu();
            
      
     
       
    }

    
}
