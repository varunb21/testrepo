package com.utilities;

import java.util.List;
import java.util.Map;

public class XLReader {
    public String DataSheetPath;
    public String TestDataSheetName = "TestData";
    public String LocatorsSheetName = "Locators";
    public String DriverSheetName = "TestDriverSheet";
    public String EnvSheetName = "ENV";
    public String groupFlag = "Y";
    public String groupName = "Regression";
    public List<Map<String, String>> TestCaseDataMapList;
    public Map<String, String> TestCaseInfoMap;
    public Map<String, String> TestCaseDataMap;
    public Map<String, String> EnvironmentDataMap;
    public Map<String, Map<String, String>> LocatorDataMap;

    public XLReader() {
    }

//    public static Map<String, String> getEnvironmentInfo(String envID) throws IOException {
//        Workbook wbook = getDataBook(DataSheetPath);
//        Sheet sheet = getDataSheet(wbook, "ENV");
//        Map<String, String> envMap = new HashMap();
//        Row firstRow = sheet.getRow(0);
//        int columnCount = firstRow.getLastCellNum();
//        int rowNumber = getRowNumberByRowID(sheet, "ENV_ID", envID);
//        Row envRow = sheet.getRow(rowNumber);
//
//        for(int i = 0; i <= columnCount - 1; ++i) {
//            String envKeyName = firstRow.getCell(i).getStringCellValue();
//            String envKeyValue = null;
//            if (envKeyName != null && !envKeyName.trim().equals("")) {
//                envKeyValue = envRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
//                envMap.put(envKeyName, envKeyValue);
//            }
//        }
//
//        EnvironmentDataMap = envMap;
//        return envMap;
//    }
//
//    public static Workbook getDataBook(String dataSheetPath) throws IOException {
//        File xlFile = new File(dataSheetPath);
//        FileInputStream fis = new FileInputStream(xlFile);
//        String[] arrPath = dataSheetPath.split("\\.");
//        String fileExt = arrPath[arrPath.length - 1];
//        return (Workbook)(fileExt.equalsIgnoreCase("xlsx") ? new XSSFWorkbook(fis) : new HSSFWorkbook(fis));
//    }
}
