package com.ws;

import com.config.Environment;
import com.entity.interfaces.intake.employee.MolinaEmployee;
import com.entity.interfaces.intake.employee.ProviderIdentification;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

import static com.ws.WebServicesConstants.IMPORT_MOLINA_EMPLOYEE;

public class MolinaEmployeeServices extends WebServicesBase {
    private static final Logger LOGGER = Logger.getLogger(MolinaEmployeeServices.class);

    public MolinaEmployeeServices() {
    }

    public Response sendImportEmployeeRequest(Environment environment, String modifyJson, String accountId){
        LOGGER.info(modifyJson);
        LOGGER.info(environment.getDwh() + IMPORT_MOLINA_EMPLOYEE);
        return sendPOSTWithAccountInHeader(environment.getDwh() + IMPORT_MOLINA_EMPLOYEE,
                modifyJson, environment.getMember_user(), environment.getMember_pass(), accountId);
    }

    public MolinaEmployee[] CreateEmployee(String jsonFileName, Environment environment,
                                           ProviderIdentification provider, String accountId) throws IOException {
        Gson gson = new Gson();
        MolinaEmployee[] employees = toJsonModel(jsonFileName, MolinaEmployee[].class);
        String empssn = CommonMethods.generateRandomNumberOfFixLength(9);
        MolinaEmployee employee = employees[0];
        employee.setEmployeeIdentifier(empssn);
        employee.setEmployeeFirstName(CommonMethods.generateRandomStringOfFixLength(10));
        employee.setEmployeeLastName(CommonMethods.generateRandomStringOfFixLength(10));
        employee.setSequenceID(CommonMethods.generateRandomNumberOfFixLength(10));
        employee.setEmployeeSSN(empssn);
        employee.setEmployeeEmail(DataGeneratorEmployee.generateEmpEmail(14));
        employee.setProviderIdentification(provider);

        sendImportEmployeeRequest(environment, gson.toJson(employees), accountId);

        return employees;
    }
}
