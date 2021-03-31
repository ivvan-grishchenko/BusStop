package com.BenRasha.BusStop.Controller;

import com.BenRasha.BusStop.service.impl.TimetableServiceImpl;

public class ControllerImpl {
    private TimetableServiceImpl timetableService = new TimetableServiceImpl();

    public void go() {
        timetableService.sortByAcceptableLength();
        timetableService.sortByDepartureTime();
        timetableService.sortByEfficiency();
        timetableService.sortByCompanyName();
        timetableService.saveToFile();
    }
}
