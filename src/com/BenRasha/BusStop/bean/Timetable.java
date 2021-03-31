package com.BenRasha.BusStop.bean;

import java.time.LocalTime;

public class Timetable{

    private String companyName;
    private LocalTime departure;
    private LocalTime arrival;

    public Timetable(String companyName, LocalTime departure, LocalTime arrival) {
        this.companyName = companyName;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return  companyName+" "+departure+" "+arrival+"\n";
    }

}
