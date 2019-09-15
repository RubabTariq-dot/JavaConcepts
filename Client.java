/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l176310.java.concepts.clientInfo;


/**
 *
 * @author Rubab Tariq
 */

public class Client
{
    String Name;
    int CreditCardNumber;
    int Age;
    
    String RegistrationDate; //Date-Month-Year
    public  int client_id;
    public String CalculateDueDate()
    {
        String[] Date = RegistrationDate.split("-");
           int month=Integer.parseInt(Date[1]);
           int year=Integer.parseInt(Date[2]);
           if(month==12)
           { 
               year+=1;
               month=(month+2)%13;
           }
           else
           {
               month+=1;
           }
           int date=Integer.parseInt(Date[0]);
           //System.out.println("Due Date:   "+date+"-" +month+"-" +year);
           String ret= String.valueOf(date)+"-"+String.valueOf(month)+"-"+String.valueOf(year);
           return ret;
    }
    
   public Client(String _name,int _creditCardNum,int _age,String _registrationDate)
   {
       Name=_name;
       CreditCardNumber=_creditCardNum;
       Age=_age;
       RegistrationDate=_registrationDate;
   }
   
   public void SetClientID(int c_id)
   {
       client_id=c_id;
   }

     public void payFee(String date)
     {
         System.out.println("Fee paid");
         RegistrationDate=date;
     }
     public boolean RemoveOrKeep(String dueDate,String currDate)
     {
           String[] Date = currDate.split("-");
           int month=Integer.parseInt(Date[1]);
           int year=Integer.parseInt(Date[2]);
           int date=Integer.parseInt(Date[0]);
           
           String[] due_Date=dueDate.split("-");
           int due_date=Integer.parseInt(due_Date[0]);
           int due_month=Integer.parseInt(due_Date[1]);
            
            if((month-due_month==0) && (date-due_date>0))
            {
                 System.out.print("You have Over Due Fees \n");
            }

           else if(month-due_month>=1)
            { 
                System.out.println("Client removed due to over due fees");
                return true;
            }
            return false;
     }

  


   
}




