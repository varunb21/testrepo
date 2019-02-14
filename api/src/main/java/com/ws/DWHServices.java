package com.ws;

import com.config.Environment;
import com.entity.exportDWH.AccountInterfaceParamInformation;
import com.entity.exportDWH.ExportWithConfigurationModel;
import com.entity.exportDWH.FullExportWithDateRange;
import com.globalMethods.core.CommonMethods;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ws.WebServicesConstants.DWH_EXPORT_ALL_URL;
import static com.ws.WebServicesConstants.DWH_EXPORT_WITH_CONFIG_URL;

public class DWHServices {
    private static final Logger LOGGER = Logger.getLogger(DWHServices.class);
    private WebServicesBase webServicesBase;

    enum Account{
        MOLINA, OHIO, CONNECTICUT
    }

    public DWHServices(){
        webServicesBase =  new WebServicesBase();
    }

    public Response sendExportDWHRequest(String baseUrl, String userName,
                                                String password, String modifyJson){
        LOGGER.info(modifyJson);
        LOGGER.info(baseUrl + DWH_EXPORT_WITH_CONFIG_URL);
        return webServicesBase.sendPOSTRequestWithoutSSL(baseUrl + DWH_EXPORT_WITH_CONFIG_URL,
                modifyJson, userName, password);
    }

    public Response sendExportDWHWithoutConfigRequest(String baseUrl, String userName,
                                                             String password,FullExportWithDateRange param){
        LOGGER.info(baseUrl + DWH_EXPORT_ALL_URL);

        String url = baseUrl + DWH_EXPORT_ALL_URL
                + "?startDate=" + param.getStartDate()
                + "&endDate=" + param.getEndDate()
                + "&account=" + param.getAccount()
                + "&groupKey=" + param.getGroupKey()
                + "&contract=" + param.getContract()
                + "&spv=" + param.getSpv()
                + "&username=" + param.getUsername()
                + "&exportMode=" + param.getExportMode();
        LOGGER.info("Get send export without config url: " + url);

        return webServicesBase.sendGETRequestWithourSSL(url, userName, password);
    }

    public List<String> getFileNamesInExportEVV(String body, String prefix, String format) {
//		body = "Trigger full export successfully! Please wait until the file State_EVV_DWExtract_PROVIDER_GENERAL_112618_06_52_07.csv, State_EVV_DWExtract_PROVIDER_LOC_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_GENERAL_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_PROG_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_ELIG_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_DIAG_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_ADDR_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_PHONE_112618_06_52_07.csv, State_EVV_DWExtract_CLIENT_SCHEDULE_112618_06_52_07.csv, State_EVV_DWExtract_EMP_GENERAL_112618_06_52_07.csv, State_EVV_DWExtract_EMP_DISC_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_GENERAL_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_CALLS_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_TASKS_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_EXCP_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_CHANGES_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_CLAIMST_112618_06_52_07.csv, State_EVV_DWExtract_VISIT_LOG_DETAILS_112618_06_52_07.csv is completely written. Returned SID: 104818507. TraceId: ";
        List<String> fileNameList = new ArrayList<>();
        String[] fileNames = body.replace(",", "").split("u0027");
        fileNames[0] = fileNames[0].replaceAll("Trigger full export successfully! Please wait until the file", "");
        fileNames[fileNames.length - 1] = fileNames[fileNames.length - 1].replaceAll("", " is completely written. Returned SID: 104818507. TraceId: ");
        for(String fileName : fileNames)
            if(fileName.contains("EVV_DWExtract")) {
                fileName = fileName.replace("\\", "").trim();
                if(fileName.contains("_ALL")) {
                    fileName = fileName.replaceAll("_ALL", prefix);
                }
                if(format != null && format != "") {
                    fileName = fileName.replaceAll(".csv", format);
                }
                fileNameList.add(fileName);
            }
        return fileNameList;
    }

    public String getFileNameContain(List<String> fileNames, String containText) {
        for(String fileName : fileNames) {
            if (fileName.contains(containText))
                return fileName;
        }

        return null;
    }

    /**
     * Get method export EVV
     * @param url: the url api
     * @param param: the param with date range data
     * @return string response data when execute GET method
     */
    public String captureGetResponseEXPORTEVV(String url, FullExportWithDateRange param, Environment environment){
        return sendExportDWHWithoutConfigRequest(url,
                environment.getClaims_username(),
                environment.getClaims_pass(), param).asString();
    }

    /**
     * Post method export EVV
     * @param url: the url api
     * @param modifyJson: the json data
     * @return
     */
    public String capturePostResponseEXPORTEVV(String url, String modifyJson, Environment environment){
        return sendExportDWHRequest(url,
                environment.getClaims_username(),
                environment.getClaims_pass(), modifyJson).asString();
    }

    public String PrepareGetRequestDWHExportData(String account, String startDate, String endDate,
                                                 String groupKey, String contract, Environment environment) throws Exception{
        FullExportWithDateRange fullExportWithDateRange = new FullExportWithDateRange();
        fullExportWithDateRange.setAccount(account);
        fullExportWithDateRange.setStartDate(startDate);
        fullExportWithDateRange.setEndDate(endDate);
        fullExportWithDateRange.setGroupKey(groupKey);
        fullExportWithDateRange.setContract(contract);

        return captureGetResponseEXPORTEVV(environment.getDwh(), fullExportWithDateRange, environment);
    }

    public String PreparePostRequestDWHExportData(String account, String startDate, String endDate,
                                                  String groupKey, String contract, Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        ExportWithConfigurationModel[] exportWithConfiRequests = webServicesBase
                .toJsonModel("DWHExportWithConfiguration.json", ExportWithConfigurationModel[].class);
        ExportWithConfigurationModel exportWithConfigRequest = exportWithConfiRequests[0];
        AccountInterfaceParamInformation accountInterfaceParamInformation =
                exportWithConfigRequest.getAccountInterfaceParamInformation();
        accountInterfaceParamInformation.setAccount(account);
        accountInterfaceParamInformation.setContract(contract);
        accountInterfaceParamInformation.setGroupKey(groupKey);
        accountInterfaceParamInformation.setStartDate(startDate);
        accountInterfaceParamInformation.setEndDate(endDate);

        exportWithConfigRequest.setAccountInterfaceParamInformation(accountInterfaceParamInformation);

        return capturePostResponseEXPORTEVV(url, gson.toJson(exportWithConfigRequest), environment);

    }

    public String callDWHExport(String accountType, String account, String startDate, String endDate,
                                String groupKey, String contract, Environment environment) throws Exception {
        if(accountType.equals(Account.MOLINA)){
            return PreparePostRequestDWHExportData(account, startDate, endDate, groupKey, contract, environment);
        } else if(accountType.equals(Account.CONNECTICUT) || accountType.equals(Account.OHIO)){
            return PrepareGetRequestDWHExportData(account, startDate, endDate, groupKey, contract, environment);
        }
        return PrepareGetRequestDWHExportData(account, startDate, endDate, groupKey, contract, environment);
    }
}
