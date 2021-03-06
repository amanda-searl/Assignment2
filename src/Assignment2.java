/*
score: 9.0/10.0
Great Job! Just one corner case miss.
*/
/**
 * Created by Rose on 1/21/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews.Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {        //correct
        if (employee.salary <8900) {
        	System.out.println(employee.salary*0.062);
        	return employee.salary*0.062;
        } else {
        	System.out.println(106800*0.062);
        	return 106800*0.062;
        }
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {          //correct
        double x;
    	if (employee.age <35){
        	x= employee.salary*0.03; 
        } else if (employee.age >= 35 && employee.age <= 50 ){
        	x= employee.salary*0.04;
        } else if (employee.age>50 && employee.age<= 60){
        	x= employee.salary*0.05;
        } else {
        	x= employee.salary*0.06;
        }
    	System.out.println(x);
    	return x;
    }
    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {    	   	//correct
    	Employee n = e1;  
    	Employee sortEmployee[] ={e1,e2,e3};
    	for (Employee e: sortEmployee) {
	    	if (e.salary > n.salary){
	    		n = e;
	    	}
    	}
    	
    	if (n == e1) {
    		if (e2.salary > e3.salary) {
    			System.out.print(e3.getName());
    			System.out.print(e2.getName());
    		} else {
    			System.out.print(e2.getName());
    			System.out.print(e3.getName());
    		}
    	} else if (n == e2) {
    		if (e1.salary > e3.salary) {
    			System.out.print(e3.getName());
    			System.out.print(e1.getName());
    		} else {
    			System.out.print(e1.getName());
    			System.out.print(e3.getName());
    		}
    	} else if (n == e3) {
    		if (e1.salary > e2.salary) {
    			System.out.print(e2.getName());
    			System.out.print(e1.getName());
    		} else {
    			System.out.print(e1.getName());
    			System.out.print(e2.getName());
    		}
    	}
    	System.out.print(n.getName());
    }
    	


    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {                           //requirement is to use raiseSalary()method, but your way is also correct
    	employee.salary= employee.salary*3;
    	System.out.println(employee.salary);
    }

    //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {                  //correct
    	if (n<=1){
    		return false;
    	}
    	if (n==2){
    		return true;
    	}
    	for(int i=2; i<n; i++){
	    	if (n%i==0){
	        	return false;
	        }
    	}
    	return true;
    }

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {                  //correct
    	n=Math.abs(n);
    	int sum=0;
    	 do {  
    		 sum = 0;
	    	 while (n>0){
		    	 sum += n%10;
		    	 n /= 10;
	    	  }
	    	 n = sum;
    	 } while (sum>=10);  
         return sum;    
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {               //one mistake: if n is 0, the program cannot jump out the first while loop
        while (n%2==0){
        	n /= 2;
        	if (n==1) {
        		return true;
        	}
        }
        
        while (n%3==0){
        	n /=3;
        	if (n==1){
        		return true;
        	}
        }
        
        while (n%5==0){
        	n /=5;
        	if (n==1){
        		return true;
        	}	
        }
        
    	return false;
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     After swap, should also change the subject for .getName.            
     Because the sentence "swap(a,b)" don't into the call function   
    */
    /*
     correct answer is:
     after "Employee a = new Employee", the program declare a as the reference
     variable assigned to the Employee object named Jenny. Also, b is the reference variable
     assigned to the Employee object named John. When calling the method "swap", two reference
     variables are passed as the arguments. Yet, the passed x and y are only the copies of a and b.
     Swapping x and y will not affected the assignment of a and b. Therefore, a is still assigned to
     Employee "Jenny" and b is still assigned to Employee "John".
     */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
       
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}

