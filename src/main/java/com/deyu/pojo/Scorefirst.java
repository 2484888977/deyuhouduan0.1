package com.deyu.pojo;

public class Scorefirst {
    private int scoreid;
    private String scoreinfo;
    private int collegeid;
    private String scorebl;

    public Scorefirst(int scoreid, String scoreinfo, int collegeid, String scorebl) {
        this.scoreid = scoreid;
        this.scoreinfo = scoreinfo;
        this.collegeid = collegeid;
        this.scorebl = scorebl;
    }

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public String getScoreinfo() {
        return scoreinfo;
    }

    public void setScoreinfo(String scoreinfo) {
        this.scoreinfo = scoreinfo;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getScorebl() {
        return scorebl;
    }

    public void setScorebl(String scorebl) {
        this.scorebl = scorebl;
    }

    @Override
    public String toString() {
        return "Scorefirst{" +
                "scoreid=" + scoreid +
                ", scoreinfo='" + scoreinfo + '\'' +
                ", collegeid=" + collegeid +
                ", scorebl='" + scorebl + '\'' +
                '}';
    }
}
