package com.example.android.project4;
/**
 * Created by work on 8/4/17.
 */

public class ReportCard {

    private int stuNum;
    private String mathGrade;
    private String csGrade;
    private String bioGrade;
    private String physGrade;
    private String peGrade;


    public ReportCard(int stuNum, String mathGrade, String peGrade, String physGrade, String csGrade, String bioGrade) {
        this.stuNum=stuNum;
        this.bioGrade=bioGrade;
        this.peGrade=peGrade;
        this.physGrade=physGrade;
        this.csGrade=csGrade;
        this.mathGrade=mathGrade;
    }

    public int getStuNum(){
        return stuNum;
    }

    public void setStuNum(int stuNum){
        this.stuNum=stuNum;
    }

    public String getPeGrade() {
        return peGrade;
    }

    public String getBioGrade() {
        return bioGrade;
    }

    public String getCsGrade() {
        return csGrade;
    }

    public String getMathGrade() {
        return mathGrade;
    }

    public String getPhysGrade() {
        return physGrade;
    }

    public void setBioGrade(String bioGrade) {
        this.bioGrade = bioGrade;
    }

    public void setCsGrade(String csGrade) {
        this.csGrade = csGrade;
    }

    public void setMathGrade(String mathGrade) {
        this.mathGrade = mathGrade;
    }

    public void setPeGrade(String peGrade) {
        this.peGrade = peGrade;
    }

    public void setPhysGrade(String physGrade) {
        this.physGrade = physGrade;
    }

    @Override
    public String toString() {
        String report = "Student number: " + String.valueOf(getStuNum())+ "/nBiology Grade: " + this.getBioGrade() + "/nPE grade: " + this.getPeGrade()
                + "/nPhyisics grade: " + getPhysGrade() + "/nMath grade: " +getMathGrade()+"/nComputer scince grad: " + getCsGrade() ;
        return report;

    }
}
