package com.example.game.Database;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileDatabase {
    private static final String FILE_NAME = "test.txt";
    public static boolean CreateDataBase() throws IOException {
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return f.createNewFile();
        }
        return false;
    }

    public static void WriteToDatabase(String data) throws IOException {
        FileWriter f = new FileWriter(FILE_NAME);
        f.write(data);
        f.close();
    }

    public static void AddNewRecordToDatabase(String name, int score) throws IOException, ParseException {
        String data = ReadFromDatabase();
        JSONArray allDataArray = (JSONArray) (new JSONParser()).parse(data);
        boolean isFound = false;

        for ( var datum : allDataArray ) {
            JSONObject obj = (JSONObject) datum;
            var objName = obj.get("name");
            if (Objects.equals(name, objName)) {
                obj.put("score",((Long)obj.get("score")) + 1L);
                isFound = true;
            }
        }

        if (!isFound) {
            JSONObject newRecord = new JSONObject();
            newRecord.put("name",name);
            newRecord.put("score",score);
            allDataArray.add(newRecord);
        }
        WriteToDatabase(allDataArray.toJSONString());
    }

    public static int GetLengthOfRecords() throws FileNotFoundException, ParseException {
        String data = ReadFromDatabase();
        return ((JSONArray) (new JSONParser()).parse(data)).size();
    }

    public static JSONObject getHighestScore() throws FileNotFoundException, ParseException {
        String data = ReadFromDatabase();
        JSONArray allDataArray = (JSONArray) (new JSONParser()).parse(data);
        JSONObject highestScoreObj = null;
        Long currentScore = 0L;
        for (var x : allDataArray) {
            var score = (Long) ((JSONObject) x).get("score");
            if (score > currentScore) {
                highestScoreObj = (JSONObject) x;
                currentScore = score;
            }
        }
        return highestScoreObj;
    }

    public static String ReadFromDatabase() throws FileNotFoundException {
        File f = new File(FILE_NAME);
        Scanner s = new Scanner(f);
        String data = "";
        while (s.hasNextLine()) {
            data = s.nextLine();
            System.out.println(data);
        }
        s.close();
        return data;
    }
}
