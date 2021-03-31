package com.BenRasha.BusStop.DAO.impl;

import com.BenRasha.BusStop.DAO.TimetableDAO;
import com.BenRasha.BusStop.bean.Timetable;
import javafx.util.converter.TimeStringConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQLTimetableDAO implements TimetableDAO {

    private List<Timetable> timetables = new ArrayList<>();

    @Override
    public void readFromFile(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String[] timetablesFromFile = scanner.nextLine().split(" ");
            String companyName = timetablesFromFile[0];
            String departureString = timetablesFromFile[1];
            String arrivalString = timetablesFromFile[2];
            timetables.add(new Timetable(companyName,LocalTime.parse(departureString),LocalTime.parse(arrivalString)));
        }
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }
}
