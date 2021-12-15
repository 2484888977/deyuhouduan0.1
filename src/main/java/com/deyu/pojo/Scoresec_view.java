package com.deyu.pojo;

public class Scoresec_view {
    private int scoresecid;
    private String scoresecinfo;
    private int scorefirid;
    private int classid;
    private String score;
    private String scoreinfo;
    private String classinfo;

    public Scoresec_view(int scoresecid, String scoresecinfo, int scorefirid, int classid, String score, String scoreinfo, String classinfo) {
        this.scoresecid = scoresecid;
        this.scoresecinfo = scoresecinfo;
        this.scorefirid = scorefirid;
        this.classid = classid;
        this.score = score;
        this.scoreinfo = scoreinfo;
        this.classinfo = classinfo;
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

    public String getScoreinfo() {
        return scoreinfo;
    }

    public void setScoreinfo(String scoreinfo) {
        this.scoreinfo = scoreinfo;
    }

    public String getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }

    @Override
    public String toString() {
        return "scoresec_view{" +
                "scoresecid=" + scoresecid +
                ", scoresecinfo='" + scoresecinfo + '\'' +
                ", scorefirid=" + scorefirid +
                ", classid=" + classid +
                ", score='" + score + '\'' +
                ", scoreinfo='" + scoreinfo + '\'' +
                ", classinfo='" + classinfo + '\'' +
                '}';
    }
}
