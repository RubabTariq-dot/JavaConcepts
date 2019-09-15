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
public class Regular extends Client
{
     List<FitnessCenter> facilities=new ArrayList<>(4);
    
     
   public Regular(String _name,int _creditCardNum,int _age,String _registrationDate)
    {
        super(_name, _creditCardNum, _age,_registrationDate);
    }
    
   public void availFacility(FitnessCenter newFacility)
    {
        facilities.add(newFacility);
    }
    
   public int CalculateFee()
    {
        int sum=0;
        for(int i=0;i<facilities.size();i++)
        {
            sum= sum + (facilities.get(i).fee);
        }
        return sum;
    }
}
    
