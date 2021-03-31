package com.BenRasha.BusStop.service;

import java.text.ParseException;

public interface TimetableService {
    void saveToFile();
    void sortByDepartureTime();
    void sortByAcceptableLength();
    void sortByEfficiency();
    void sortByCompanyName();
}
