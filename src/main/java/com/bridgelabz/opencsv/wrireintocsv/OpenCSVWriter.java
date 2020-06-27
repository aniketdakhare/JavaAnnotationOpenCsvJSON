package com.bridgelabz.opencsv.wrireintocsv;

import com.bridgelabz.opencsv.model.CSVUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter
{
    private static final String OBJECT_LIST_SAMPLE= "./object-list-Sample.csv";

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException
    {
        Writer writer = new FileWriter(OBJECT_LIST_SAMPLE);
        StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

        List<CSVUser> users = new ArrayList<>();
        users.add(new CSVUser("Aniket D", "aniketdakhare@gmail.com", "9945678899", "India"));
        users.add(new CSVUser("Bharat R", "bharatArawat@gmail.com", "9679896998", "Nepal"));
        users.add(new CSVUser("Snehal Gunde", "snhlg@gmail.com", "8899899889", "U.S."));
        users.add(new CSVUser("A David", "devid@gmail.com", "8899845877", "Pakistan"));

        beanToCsv.write(users);
        beanToCsv.getCapturedExceptions();
        writer.close();
    }
}
