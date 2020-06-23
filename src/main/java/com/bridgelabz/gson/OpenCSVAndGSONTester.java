package com.bridgelabz.gson;

import com.bridgelabz.opencsv.model.CSVUser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndGSONTester
{
    private static final String SAMPLE_CSV_FILE_PATH = "./object-list-Sample.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./object-list-Sample.json";

    public static void main(String[] args) throws IOException
    {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBeanBuilder<CSVUser> csvUserCsvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvUserCsvToBeanBuilder.withType(CSVUser.class);
        csvUserCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<CSVUser> csvToBean = new CsvToBean<>();
        List<CSVUser> csvUsers = csvToBean.parse();
        Gson gson = new Gson();
        String json = gson.toJson(csvUsers);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
        CSVUser[] users = gson.fromJson(bufferedReader, CSVUser[].class);
        List<CSVUser> csvUserList = Arrays.asList(users);
    }

}
