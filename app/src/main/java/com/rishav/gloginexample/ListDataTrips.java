package com.rishav.gloginexample;

public class ListDataTrips {
    public String Name,Seater,LocSrc,LocDest,Rsphr,InitialRs,Hours,Date,Time,Totalprice;
    public int Imgid;

    public ListDataTrips(String name, String seater, String locSrc, String locDest, String rsphr, String initialRs,String Hours, String date, String time, String totalprice, int imgid) {
        this.Name = name;
        this.Seater = seater;
        this.LocSrc = locSrc;
        this.LocDest = locDest;
        this.Rsphr = rsphr;
        this.InitialRs = initialRs;
        this.Hours = Hours;
        this.Date = date;
        this.Time = time;
        this.Totalprice = totalprice;
        this.Imgid = imgid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSeater() {
        return Seater;
    }

    public void setSeater(String seater) {
        this.Seater = seater;
    }

    public String getLocSrc() {
        return LocSrc;
    }

    public void setLocSrc(String locSrc) {
       this. LocSrc = locSrc;
    }

    public String getLocDest() {
        return LocDest;
    }

    public void setLocDest(String locDest) {
        this.LocDest = locDest;
    }

    public String getRsphr() {
        return Rsphr;
    }

    public void setRsphr(String rsphr) {
        this.Rsphr = rsphr;
    }

    public String getInitialRs() {
        return InitialRs;
    }

    public void setInitialRs(String initialRs) {
        this.InitialRs = initialRs;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTime() {
        return Time;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.Totalprice = totalprice;
    }

    public int getImgid() {
        return Imgid;
    }

    public void setImgid(int imgid) {
        this.Imgid = imgid;
    }


}
