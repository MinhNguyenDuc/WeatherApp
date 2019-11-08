package com.example.weatherapi;

public class Weather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhase;
    private Temperature Temperature;


    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhase() {
        return IconPhase;
    }

    public void setIconPhase(String iconPhase) {
        IconPhase = iconPhase;
    }

    public com.example.weatherapi.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.weatherapi.Temperature temperature) {
        Temperature = temperature;
    }
}
