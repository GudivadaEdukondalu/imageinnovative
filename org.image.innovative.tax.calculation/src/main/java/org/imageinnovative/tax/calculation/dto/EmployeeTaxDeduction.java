package org.imageinnovative.tax.calculation.dto;


public class EmployeeTaxDeduction {

    private String employeeCode;
    private String firstName;
    private String lastName;
    private long yearlySalary;
    private long taxAmount;
    private long cessAmount;

    // Your existing code...

    // Generate constructor
    public EmployeeTaxDeduction(String employeeCode, String firstName, String lastName,
                                long yearlySalary, long taxAmount, long cessAmount) {
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
        this.taxAmount = taxAmount;
        this.cessAmount = cessAmount;
    }

    // Your existing code...
}

