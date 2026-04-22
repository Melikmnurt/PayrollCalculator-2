package com.pluralsight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            //Step 1: Load the CSV file from resources folder

            InputStream is = PayrollCalculator.class.getResourceAsStream("/employees.csv");

            //Check if file exists
            if (is == null){
                System.out.println("File not found!");
                return;                                 //Stop program if file is missing
            }
            //Wrap InputStream with BufferedReader for reading text
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            //Step 2: Skip the header line
            reader.readLine();

            String line;                             //Variable to store each line from file

            //Step 3: Read file line by line
            while ((line = reader.readLine()) != null){

                //Step 4: Split the line into parts
                String[] tokens = line.split("\\|");

                //Step 5: Convert string values to proper types
                int id = Integer.parseInt(tokens[0]);
                //Convert "10" to 10

                String name = tokens [1];
                //name stays as String

                double hoursWorked = Double.parseDouble(tokens[2]);
                //Convert "52.5" to 52.5

                double payRate = Double.parseDouble(tokens[3]);
                //Convert "12.50" to 12.50

                //Step 6: Create an employee object
                Employee emp = new Employee(id, name, hoursWorked, payRate);

                //Step 7: Display employee information
                System.out.printf("ID: %d  |  Name: %s  | Gross: %.2f\n",
                        emp.getEmployeeId(),   //get ID
                        emp.getName(),         //get name
                        emp.getGrossPay());    //calculate gross pay
            }
            reader.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
