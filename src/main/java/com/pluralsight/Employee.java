package com.pluralsight;

public class Employee {

        //Fields (store data for each employee)

        private int employeeId;      //stores employee ID
        private String name;         //stores employee name
        private double hoursWorked;  // store hours worked
        private double payRate;      //stores pay rate per hour

        //Constructor
        //Used to create a new employee object
        public Employee (int employeeId, String name, double hoursWorked, double payRate){
            this.employeeId = employeeId;    //assign ID
            this.name = name;                //assign name
            this.hoursWorked = hoursWorked;   //assign hours worked
            this.payRate = payRate;          //assign pay rate
        }
    //Gettter methods (used to access private data)
        public int getEmployeeId() {
            return employeeId;               //return employee ID
        }
        public String getName() {
            return name;                    //return employee name
        }
        public double getHoursWorked() {
            return hoursWorked;             //return hours worked
        }
        public double getPayRate() {
            return payRate;                 //return pay aret
        }
    //Method to calculate gross pay
        public double getGrossPay(){
            //Formula: Gross Pay = Hours worked * Pay Rate
            return hoursWorked * payRate;
    }
}
