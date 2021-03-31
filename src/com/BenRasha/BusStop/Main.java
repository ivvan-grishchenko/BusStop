package com.BenRasha.BusStop;

import com.BenRasha.BusStop.Controller.ControllerImpl;

public class Main {

    public static void main(String[] args) {
        ControllerImpl controller = new ControllerImpl();
        controller.go();
    }
}
