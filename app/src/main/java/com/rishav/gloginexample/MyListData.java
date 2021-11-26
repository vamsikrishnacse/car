package com.rishav.gloginexample;

public class MyListData {
    String name,x,loc,Rs,Rsphr,initialrs,locsrc;

    public String getLocsrc() {
        return locsrc;
    }

    public void setLocsrc(String locsrc) {
        this.locsrc = locsrc;
    }

    public String getRsphr() {
        return Rsphr;
    }

    public String getInitialrs() {
        return initialrs;
    }

    public void setInitialrs(String initialrs) {
        this.initialrs = initialrs;
    }

    public void setRs(String rsphr) {
        Rsphr = rsphr;
    }

    int imgid;

    public String getRs() {
        return Rs;
    }

    public void setRphr(String rs) {
        Rs = rs;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }



    public MyListData(String name, int imgid, String x, String loc, String Rs, String Rsphr, String Initialrs, String locsrc) {
        this.name = name;
        this.imgid = imgid;
        this.x=x;
        this.loc=loc;
        this.Rs = Rs;
        this.Rsphr = Rsphr;
        this.initialrs = Initialrs;
        this.locsrc = locsrc;
    }

    public String getName() {
        return name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

}
