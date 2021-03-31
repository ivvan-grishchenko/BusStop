package com.BenRasha.BusStop.service.impl;

import com.BenRasha.BusStop.DAO.impl.SQLTimetableDAO;
import com.BenRasha.BusStop.bean.Timetable;
import com.BenRasha.BusStop.service.TimetableService;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class TimetableServiceImpl implements TimetableService {

    static SQLTimetableDAO sqlTimetableDAO = new SQLTimetableDAO();

    public void saveToFile() {
        try {
            File fileToWrite = new File("output.txt");
            // Here we can ask user to input file path name, but to check whether program works correctly, i've inputted existed file
            FileWriter fileWriter = new FileWriter(fileToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sqlTimetableDAO.getTimetables().toString().trim());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByDepartureTime() {
        class SortByDepartureTime implements Comparator<Timetable> {

            @Override
            public int compare(Timetable o1, Timetable o2) {
                return o1.getDeparture().compareTo(o2.getDeparture());
            }
        }
        SortByDepartureTime sortByDepartureTime = new SortByDepartureTime();
        Collections.sort(sqlTimetableDAO.getTimetables(), sortByDepartureTime);
    }

    public void sortByAcceptableLength() {
        sqlTimetableDAO.readFromFile(new File("C:\\Users\\bbenr\\IdeaProjects\\BusStop\\src\\com\\BenRasha\\BusStop\\Source\\Input.txt"));
        for (int i =0;i<sqlTimetableDAO.getTimetables().size(); i++) {
            if ((sqlTimetableDAO.getTimetables().get(i).getArrival().getHour() * 60 +sqlTimetableDAO.getTimetables().get(i).getArrival().getMinute()) - (sqlTimetableDAO.getTimetables().get(i).getDeparture().getHour() * 60 + sqlTimetableDAO.getTimetables().get(i).getDeparture().getMinute()) > 60) {
                sqlTimetableDAO.getTimetables().remove(sqlTimetableDAO.getTimetables().get(i));
            }
        }
    }

    public void sortByEfficiency() {
        for (int i =0; i<sqlTimetableDAO.getTimetables().size()-1; i++) {
            int departureInMinutesI = sqlTimetableDAO.getTimetables().get(i).getDeparture().getHour()*60 + sqlTimetableDAO.getTimetables().get(i).getDeparture().getMinute();
            int arrivalInMinuteI = sqlTimetableDAO.getTimetables().get(i).getArrival().getHour()*60 + sqlTimetableDAO.getTimetables().get(i).getArrival().getMinute();
            for (int j = 1;j<sqlTimetableDAO.getTimetables().size(); j++) {
                int departureInMinuteJ = sqlTimetableDAO.getTimetables().get(j).getDeparture().getHour()*60 + sqlTimetableDAO.getTimetables().get(j).getDeparture().getMinute();
                int arrivalInMinuteJ = sqlTimetableDAO.getTimetables().get(j).getArrival().getHour()*60 + sqlTimetableDAO.getTimetables().get(j).getArrival().getMinute();
                if (departureInMinutesI == departureInMinuteJ && arrivalInMinuteI == arrivalInMinuteJ && sqlTimetableDAO.getTimetables().get(j).getCompanyName().equals("Grotty")) {
                    sqlTimetableDAO.getTimetables().remove(sqlTimetableDAO.getTimetables().get(j));
                } else if(departureInMinutesI == departureInMinuteJ && arrivalInMinuteI < arrivalInMinuteJ) {
                    sqlTimetableDAO.getTimetables().remove(sqlTimetableDAO.getTimetables().get(j));
                } else if(departureInMinutesI > departureInMinuteJ && arrivalInMinuteI == arrivalInMinuteJ) {
                    sqlTimetableDAO.getTimetables().remove(sqlTimetableDAO.getTimetables().get(j));
                } else if(departureInMinutesI > departureInMinuteJ && arrivalInMinuteI < arrivalInMinuteJ) {
                    sqlTimetableDAO.getTimetables().remove(sqlTimetableDAO.getTimetables().get(j));
                }
            }
        }
    }

    @Override
    public void sortByCompanyName() {
        class SortByCompanyName implements Comparator<Timetable> {

            @Override
            public int compare(Timetable o1, Timetable o2) {
                return o2.getCompanyName().compareTo(o1.getCompanyName());
            }
        }
        SortByCompanyName sortByCompanyName = new SortByCompanyName();
        Collections.sort(sqlTimetableDAO.getTimetables(),sortByCompanyName);
    }
}

