package com.mapper;

import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.sftp.SFTPFileTransfer.DEFAULT_CSV_DELIMITER;
import static com.sftp.SFTPFileTransfer.DEFAULT_IGNORE_SURROUNDING_SPACES;

public class CsvUtil {
    public static CSVFormat getCsvFormat(char delimiter, boolean ignoreSurroundingSpace) {
        return CSVFormat.DEFAULT
                .withDelimiter(delimiter)
                .withFirstRecordAsHeader()
                .withIgnoreSurroundingSpaces(ignoreSurroundingSpace)
                .withIgnoreEmptyLines()
                .withAllowMissingColumnNames();
    }

    public static CSVParser readCSVRecords(File file) throws IOException {
        return getCsvFormat(DEFAULT_CSV_DELIMITER, DEFAULT_IGNORE_SURROUNDING_SPACES).parse(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    }

    public static CSVParser readCSVRecords(File file, char delimiter, boolean ignoreSurroundingSpace) throws IOException {
        return getCsvFormat(delimiter, ignoreSurroundingSpace).parse(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    }

    public static List<String> readCsvRecords(String fileName) {
        List<String> records = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            while((nextRecord = csvReader.readNext())!= null){
                String record = "\"" + nextRecord[0] + "\"";
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
