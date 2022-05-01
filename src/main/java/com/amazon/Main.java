package com.amazon;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {
        int i = 0;
        String fullPath = args[0];

        String extension = ".csv";
        CSVReader reader = new CSVReader(new FileReader(fullPath));
        List<String[]> stringList;
        stringList = reader.readAll();
        FileWriter fileWriter = new FileWriter(fullPath.replace(extension, "") + "_clean" + extension);

        while (i < stringList.size()) {
            String st = (StringUtils.stripAccents(Arrays.toString(stringList.get(i))));
            String outST = st.replace("[", "").replace("]", " ");
            fileWriter.write(outST);
//            fileWriter.flush();

            fileWriter.write("\n");
            fileWriter.flush();

            i++;
        }
        fileWriter.close();

    }
}
