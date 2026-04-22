package com.pluralsight;

import java.io.BufferedReader;   //Reads the employee file
import java.io.BufferedWriter;   // writes the payroll file
import java.io.FileReader;      // opens the input file
import java.io.FileWriter;      //creates the output file
import java.io.IOException;
import java.util.Scanner;       //lets the user type file names

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //Step 1: Ask user for input file name
            System.out.print("Enter the name of the employee file to process: ");
            String inputFile = scanner.nextLine();

            //Step 2: Ask user for output file name
            System.out.print("Enter the name of the payroll file to create: ");
            String outputFile = scanner.nextLine();

            //Step 3: Open the employee file for reading
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + inputFile));

            //Step 4: Open the payroll file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            //Step 5: Skip the header line in the employe file
            reader.readLine();

            //Step 6:Write the header line to the payroll file
            writer.write("id | name | gross pay\n ");

            String line;

            //Step 7: Read each line from the employee file
            while ((line = reader.readLine()) != null) {

                //Step 8: Split the line into tokens
                String[] tokens = line.split("\\|");

                //Step 9: Convert values to correct data types
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                //Step 10: Create Employee object
                Employee emp = new Employee(id, name, hoursWorked, payRate);

                //Step 11: Write employee payroll info to output file
                writer.write(String.format(" %d | %s | %.2f\n ",
                        emp.getEmployeeId(),
                        emp.getName(),
                        emp.getGrossPay()));
            }
            //Step 12: Close files
            reader.close();
            writer.close();
            scanner.close();

            //Step 13: Success
            System.out.println("Payroll file created successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}