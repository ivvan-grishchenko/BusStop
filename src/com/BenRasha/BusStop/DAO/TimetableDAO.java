package com.BenRasha.BusStop.DAO;

import com.BenRasha.BusStop.bean.Timetable;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public interface TimetableDAO {
    void readFromFile(File file) throws ParseException;
}
