package com.deyu.pojo;

public class Scoresec {
    private int scoresecid;
    private String scoresecinfo;
    private int scorefirid;
    private int classid;
    private String score;

    public Scoresec(int scoresecid, String scoresecinfo, int scorefirid, int classid, String score) {
        this.scoresecid = scoresecid;
        this.scoresecinfo = scoresecinfo;
        this.scorefirid = scorefirid;
        this.classid = classid;
        this.score = score;
    }

    public int getScoresecid() {
        return scoresecid;
    }

    public void setScoresecid(int scoresecid) {
        this.scoresecid = scoresecid;
    }

    public String getScoresecinfo() {
        return scoresecinfo;
    }

    public void setScoresecinfo(String scoresecinfo) {
        this.scoresecinfo = scoresecinfo;
    }

    public int getScorefirid() {
        return scorefirid;
    }

    public void setScorefirid(int scorefirid) {
        this.scorefirid = scorefirid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scoresec{" +
                "scoresecid=" + scoresecid +
                ", scoresecinfo='" + scoresecinfo + '\'' +
                ", scorefirid=" + scorefirid +
                ", classid=" + classid +
                ", score='" + score + '\'' +
                '}';
    }
}
