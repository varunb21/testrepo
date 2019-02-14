package com.DWExtractModels.Employee;

import com.mapper.Column;
import com.mapper.CsvHeader;
import org.testng.Assert;

import java.util.List;

public class EmployeeDisciplineModel {
    @CsvHeader("ProviderID")
    @Column("ProviderID")
    private String providerID;

    @CsvHeader("EmployeeID")
    @Column("EmployeeID")
    private String employeeID;

    @CsvHeader("EmployeeDiscipline")
    @Column("EmployeeDiscipline")
    private String employeeDiscipline;

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeDiscipline() {
        return employeeDiscipline;
    }

    public void setEmployeeDiscipline(String employeeDiscipline) {
        this.employeeDiscipline = employeeDiscipline;
    }

    @Override
    public String toString() {
        String toString = "EmployeeDisciplineModel{" +
                "providerID='" + providerID + '\'' +
                "employeeID='" + employeeID + '\'' +
                "employeeDiscipline='" + employeeDiscipline + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals(null))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly, value is %s";

        this.verifyFormatField(this.providerID, "^\\w{0,50}$", String.format(errorMessage1, "providerID", providerID));
        this.verifyFormatField(this.employeeID, "^\\w{0,9}$", String.format(errorMessage1, "employeeID", employeeID));
        this.verifyFormatField(this.employeeDiscipline, "^HHA|RN|LPN|PT$|^{0,6}$", String.format(errorMessage1, "employeeDiscipline", employeeDiscipline));
    }

    public static void verifyFormatFieldOfData(List<EmployeeDisciplineModel> employeeDisciplineList) {
        for (EmployeeDisciplineModel recordCsv: employeeDisciplineList){
            recordCsv.verifyFormatFields();
        }
    }
}
