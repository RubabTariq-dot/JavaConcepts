/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l176310.java.concepts.clientInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rubab Tariq
 */
public class Members extends Client
{
    int AnnualFee;
    int monthlyFee;
    List<FitnessCenter> facilities=new ArrayList<>();
    
    public Members(String _name,int _creditCardNum,int _age,String _registrationDate)
    {
        super(_name, _creditCardNum, _age,_registrationDate);
        AnnualFee=300;
        monthlyFee=90;
    }
    public int CalculateFee()
    {
        return (AnnualFee+90*12);
    }
    
   public void Avail(FitnessCenter gym,FitnessCenter s_pool,FitnessCenter t_court,FitnessCenter y_center)
    {
        facilities.add(gym);
        gym.addClient(this);
        facilities.add(s_pool);
        s_pool.addClient(this);
        facilities.add(t_court);
        t_court.addClient(this);
        facilities.add(y_center);
        y_center.addClient(this);
    }
   
   public void Remove(FitnessCenter gym,FitnessCenter s_pool,FitnessCenter t_court,FitnessCenter y_center)
   {
       gym.removeClient(this);
       s_pool.removeClient(this);
       t_court.removeClient(this);
       y_center.removeClient(this);
   }
   
}