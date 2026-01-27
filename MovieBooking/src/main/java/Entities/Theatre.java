package Entities;

import Enums.City;

import java.util.List;

public class Theatre {
    String name;
    List<Screen> screenList;
    City city;

    public Theatre(String theatreId, List<Screen> screenList, City city){
        this.name = theatreId;
        this.screenList = screenList;
        this.city = city;
    }

    public String getTheatreName() {
        return name;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public City getCity() {
        return city;
    }
}
