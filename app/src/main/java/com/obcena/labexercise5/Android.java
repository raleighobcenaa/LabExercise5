package com.obcena.labexercise5;

public class Android {
    int logo;
    String names, version, apiLvl, rDate, message;

    public Android(int logo, String names, String version, String apiLvl, String rDate, String message) {
        this.logo = logo;
        this.names = names;
        this.version = version;
        this.apiLvl = apiLvl;
        this.rDate = rDate;
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

    public int getLogo(){
        return logo;
    }

    public String getNames() {
        return names;
    }

    public String getVersion(){
        return version;
    }
    public String getApiLvl(){
        return apiLvl;
    }
    public String getRDate(){
        return rDate;
    }

}
