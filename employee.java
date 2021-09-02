package lab.pkg1a;

import java.util.Scanner;
interface taxable {

    void calculateTax();
}

class employee  {

    int employee_id;
    String employee_name;
    
 employee()
 {
     System.out.print("Employee records ");
 }
 
   void Get()
   {
       Scanner input=new Scanner(System.in);
       System.out.println("Enter id");
       employee_id=input.nextInt();
       System.out.println("Enter name");
       employee_name=input.next();
       
   }
   
   }
class Hourlyemployee extends employee
{
        int Add_earning;
        double total,Salary;
    
    int choice;
    
    Hourlyemployee()
    {
        System.out.println("Hourly employee  ");
        
    }
    int Hours_worked ;
    double  Rate_per_hour;
    void Time()
    {
       Scanner input=new Scanner(System.in);
       System.out.println("Hours_worked");
       Hours_worked=input.nextInt();
       System.out.println("Rate per hour");
       Rate_per_hour=input.nextDouble();
       System.out.println("Hours worked "+ Hours_worked +" hours");
       Salary=Rate_per_hour*Hours_worked;
       System.out.println("Earning is "+ Salary+" lakhs");
        System.out.println("Do you have extra earning? 1 for yes  0 for no");
       choice=input.nextInt();
       this.AdditionalEarning();
       
    }
    
    void AdditionalEarning() {
      if (choice==0)
      {
          System.out.println("No extra earning");
      }
      if (choice==1)
      {
     Scanner input=new Scanner(System.in); 
     System.out.println("Enter additional earning in lakhs");
     Add_earning=input.nextInt();     
    }
      this.Total();
     }
  
     void Total()
     {
         total=Salary+Add_earning;
         System.out.println(employee_name +" Your Total Salary is"+total+" lakhs");

                  
     }

}
    


class permanent extends employee implements taxable {
  permanent()
  { 
      
      super();
      System.out.print("Permanent employee ");
       
      
  }
    int Salary;
    int Add_earning;
    int choice;
    public int tax;
    int total;
    double net_worth;
    int Ask;
    void ask2()
    {
        System.out.println(" Are you permanent employee 1 for yes 0 for no");
        Scanner input=new Scanner(System.in);
        Ask=input.nextInt();
        this.Get();
    }
     void GetData()
   {
       if (Ask==1)
       {
       Scanner input=new Scanner(System.in);
       System.out.println("Enter Salary in lakhs");
       Salary=input.nextInt();
       System.out.println("Salary is "+ Salary +"lakhs ");
       System.out.println("Do you have extra earning? 1  for yes  0 for no");
       choice=input.nextInt();       
       this.AdditionalEarning();       
       }  
   }
        

     void AdditionalEarning() {
      if (choice==0)
      {
          System.out.println("No extra earning");
      }
      if (choice==1)
      {
     Scanner input=new Scanner(System.in); 
     System.out.println("Enter additional earning in lakhs");
     Add_earning=input.nextInt();     
    }
      this.Total();
     }
     void Total()
     {
         total=Salary+Add_earning;
         System.out.println("Total salary "+total+"lakhs ");
          this.calculateTax();
          net_worth=total - ((total*tax))/100.0;
          
          System.out.println(employee_name +" your net worth after tax deduction "+net_worth+"lakhs");
         
                  
     }
     public void calculateTax() {
        if (total < 1) {
            System.out.println("No tax to be paid");
            tax=0;
        }
        else if (total >= 1 & total <= 5) {
            tax=10;
        } else {
            tax=20;
        }
   System.out.println("tax to be paid is "+tax+"% of  Salary = "+total+" lakhs");
    }
    
}

class Run {
     public static void main(String[] args) {                
             
             
     permanent ob1=new permanent();
     
     ob1.ask2();     
     ob1.GetData();     

     Hourlyemployee ob2=new Hourlyemployee();
     ob2.Get();
     ob2.Time();
      
     
    }
}
