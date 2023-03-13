package com.example.geektrust;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StationService {
    private List<String> trainListA = new ArrayList<>();
    private List<String> trainListB = new ArrayList<>();
    private Stations stations = new Stations();
    public void arrival(String input[]) {
        if(input[0].contains("TRAIN_A")) {
            trainListA.add(input[0]);
            trainListA.add(input[1]);
            for (int i = 0; i < input.length; i++) {
                if (stations.getStationList().contains(input[i])) {
                    trainListA.add(input[i]);
                }
            }
            System.out.print("ARRIVAL" + " ");
            for (String s : trainListA) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        else {
            trainListB.add(input[0]);
            trainListB.add(input[1]);
            for (int i = 0; i < input.length; i++) {
                if (stations.getStationList().contains(input[i])) {
                    trainListB.add(input[i]);
                }
            }
            System.out.print("ARRIVAL" + " ");
            for (String s : trainListB) {
                System.out.print(s + " ");
            }
            System.out.println();
            if(trainListA.contains(stations.getStationList().get(0))) {
                trainListA.remove(stations.getStationList().get(0));
            }
            if(trainListB.contains(stations.getStationList().get(0))) {
                trainListB.remove(stations.getStationList().get(0));
            }
            departure(trainListA, trainListB);
        }
    }

    public void departure(List<String> a, List<String> b) {
        a.remove(0);
        b.remove(0);
        if(a.size() == 1 && b.size() == 1) {
            System.out.println("JOURNEY_ENDED");
            return;
        }
        List<String> departureList = new ArrayList<>();
        departureList.add("TRAIN_AB");
        departureList.add(a.get(0));
        departureList.add(b.get(0));
        List<String> reverseList = new ArrayList<>();
        for(int i = stations.getStationList().size() - 1; i >= 0; i--) {
            reverseList.add(stations.getStationList().get(i));
        }
        for(String s : reverseList) {
            if(a.contains(s)) {
                departureList.add(s);
                a.remove(s);
                while (a.contains(s)) {
                    departureList.add(s);
                    a.remove(s);
                }
            }
            if(b.contains(s)) {
                departureList.add(s);
                b.remove(s);
                while (b.contains(s)) {
                    departureList.add(s);
                    b.remove(s);
                }
            }
        }
        System.out.print("DEPARTURE" + " ");
        for(String s : departureList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
