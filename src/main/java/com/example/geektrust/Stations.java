package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    private List<String> stationList;

    public Stations() {
        stationList = new ArrayList<>();
        stationList.add("HYB");
        stationList.add("NGP");
        stationList.add("ITJ");
        stationList.add("BPL");
        stationList.add("AGA");
        stationList.add("NDL");
        stationList.add("PTA");
        stationList.add("NJP");
        stationList.add("GHY");
    }

    public List<String> getStationList() {
        return stationList;
    }

    public void setStationList(List<String> stationList) {
        this.stationList = stationList;
    }
}
