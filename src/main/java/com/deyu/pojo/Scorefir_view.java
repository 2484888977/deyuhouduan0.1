package com.deyu.pojo;

public class Scorefir_view {
    private int scoreid;
    private String scoreinfo;
    private int collegeid;
    private String scorebl;
    private String collegeinfo;

    public Scorefir_view(int scoreid, String scoreinfo, int collegeid, String scorebl, String collegeinfo) {
        this.scoreid = scoreid;
        this.scoreinfo = scoreinfo;
        this.collegeid = collegeid;
        this.scorebl = scorebl;
        this.collegeinfo = collegeinfo;
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

    public String getCollegeinfo() {
        return collegeinfo;
    }

    public void setCollegeinfo(String collegeinfo) {
        this.collegeinfo = collegeinfo;
    }

    @Override
    public String toString() {
        return "Scorefir_view{" +
                "scoreid=" + scoreid +
                ", scoreinfo='" + scoreinfo + '\'' +
                ", collegeid=" + collegeid +
                ", scorebl='" + scorebl + '\'' +
                ", collegeinfo='" + collegeinfo + '\'' +
                '}';
    }
}
