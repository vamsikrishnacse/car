package com.rishav.gloginexample;


public class Dataholder {
    private static Dataholder dataObject = null;

    private Dataholder() {
        // left blank intentionally
    }

    public static Dataholder getInstance() {
        if (dataObject == null)
            dataObject = new Dataholder();
        return dataObject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    private String txt1;
    private String seater,loc,rs,Rsphr,InitialRs,date,time,hours,locsrc;
    private int imgid;

    public String getLocsrc() {
        return locsrc;
    }

    public void setLocsrc(String locsrc) {
        this.locsrc = locsrc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRsphr() {
        return Rsphr;
    }

    public void setRsphr(String rsphr) {
        Rsphr = rsphr;
    }

    public String getInitialRs() {
        return InitialRs;
    }

    public void setInitialRs(String initialRs) {
        InitialRs = initialRs;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getSeater() {
        return seater;
    }

    public void setSeater(String seater) {
        this.seater = seater;
    }

    public String getName() {
        return txt1;
    }

    public void setName(String txt1) {
        this.txt1 = txt1;
    }
}

