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
public class Members extends Client
{
    int AnnualFee;
    int monthlyFee;
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
}