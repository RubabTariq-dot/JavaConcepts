/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l176310.java.concepts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rubab Tariq
 */
 interface Characters 
{
  
    void Jump();
    void Defend();
    void Speak();
    void HealthField(int p) throws IOException;
    void Attack(Characters s2);
     
    
}

 abstract class Humans implements Characters
{
    String name;
    private int power;
    
            
    Humans()
    {
       power=100;
    }
    
    @Override
    public void HealthField(int p) throws IOException
    {
        power+=p;
        if(power<0 || power>100)
        {
            throw new IOException ("POWER OUT OF RANGE!");
        }
        if(power==0)
        {
            System.out.println("Character has been WASTED :(");
        }
    }
    Boolean checkInstance(Characters s)
    {
        if(s instanceof Humans)
        {
            return true;
        }
        return false;
    }
    
    void SetName(String s) throws IOException
    {
        boolean trigger=false;
        for(int i=0;i<s.length() &&trigger==false ;i++)
        {
            char c=s.charAt(i);
            if((c <'0') || (c>'9' &&c<'A')|| (c>'Z' &&c<'a') || c>'z')
            {
                trigger=true;
                throw new IOException("Name NOT VALID! \n");
            }
        }
        
        if(!trigger)
        {
            name=s;
        }
    }

    @Override
    public void Jump()
    {
        System.out.print( name+ " Jumped! \n");
    }
    
    
    @Override
    public void Defend()
    {
        System.out.print(name+ " Defended the Attack! \n");
    }
    
    @Override
    public void Speak()
    {
        System.out.print(name+" Spoke during the Attack! \n");
    }
    
    void Explore()
    {
        System.out.println(name+" is Exploring");
    }
    
    @Override
    public abstract void Attack(Characters s);

    void Heal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void Capture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class Alien implements Characters
{
    private int power;
    
    Alien()
    {
        power =100;
    }
    
   
    @Override
    public void Jump()
    {
        System.out.println("Alien Jumped!!");
    }
    
   
    @Override
    public void Defend()
    {
        System.out.println("Alien Defended!!");
    
    }
    
   
    @Override
    public void Speak()
    {
        System.out.println("Alien Spoke during the attack!!");   
    }
    
   
    @Override
   public void HealthField(int p)
   {
       power+=p;
   }
   
 
    @Override
   public void Attack(Characters s)
   {
      if (s instanceof Alien)
       {
           System.out.println("Cannot Attack same character type :D");
       }
       else
       {
            try
            {
                s.HealthField(-5);
            }
            catch(IOException e)
            {
               System.out.println("Power Exception handled");
            }

            finally
            {
              System.out.println( "Alien attacked!");
            }
       }
    }
}

class Wizard extends Humans
{
    @Override
    void Heal()
    {
        try
        {
        HealthField(10);
        }
        catch(IOException e)
              {
                    System.out.println("Health Exception handled");
              }
        finally
        {
            System.out.println(name+" Healed");
        }
    }
    
    @Override
    public void Attack(Characters s)
    {
        if(checkInstance(s)==true)
        {
            System.out.println("Cannot Attack same character type :D");
        }
        else
        {
            try
            {
            s.HealthField(-15);
            }
            catch(IOException e)
                  {
                    System.out.println("Power Exception handled");
                  }

            finally
            {
              System.out.println( name+ " attacked with a FIREBALL!");
            }
        }
    }
}

class Warrior extends Humans
{
    @Override
    void Capture()
    {
        System.out.println( name+ " Captured something!");
    }
    
    
    @Override
    public void Attack(Characters s)
    {
        if(checkInstance(s)==true)
            {
                System.out.println("Cannot Attack same character type :D");
            }
        else
        {
            try
                {
                  s.HealthField(-20);
                }
            catch(IOException e)
                {
                  System.out.println("Power Exception handled");
                }
            finally
                {
                  System.out.println( name+ " attacked with a SWORD");
                }
        }
    } 
}

class Game
{
    List<Characters> charList=new ArrayList<>(5);

    void AddChar(Characters s) throws IOException
    {
        if(charList.size()==5)
        {
             throw new IOException("Cannot add more than 5 characters at a time \n");
        }
        else
        {
            charList.add(s);
        }
    }
    
    
    
    void Run()
    {
        Characters s1 = new Alien();
        Humans s2=new Warrior();
        Humans s3= new Wizard();
        Characters s4=new Alien();
        Humans s5=new Wizard();
        Humans s6=new Warrior();
        
        
        try
        {
        s2.SetName("warrior1");
        s3.SetName("wizard1");
        s5.SetName("wizard2");
        s6.SetName("warrior2");
        }
        catch(IOException e)
                {
                    System.out.println("Name EXCEPTION HANDLED");
                }
        
        
        try
        {
            AddChar(s1);
            AddChar(s2);
            AddChar(s3);
            AddChar(s4);
            AddChar(s5);
            AddChar(s6);
        }
        catch (IOException e)
            {
              System.out.println("Active Players Exception Handled...");
            }
        
       
        s1.Attack(s2);
        s2.Defend();
        s3.Attack(s1);
        s4.Attack(s1);
        s5.Heal();    
    }
    
}






