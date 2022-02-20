package com.example.gymapp;

import java.util.ArrayList;

public class Work {
    String wourkoutname ;
    String useremail;
    String wourkoutDate;
    static ArrayList<Work> works = new ArrayList<>();

    public Work(String wourkoutname, String useremail, String wourkoutDate) {
        this.wourkoutname = wourkoutname;
        this.useremail = useremail;
        this.wourkoutDate = wourkoutDate;
    }

    public String getWourkoutname() {
        return wourkoutname;
    }

    public void setWourkoutname(String wourkoutname) {
        this.wourkoutname = wourkoutname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getWourkoutDate() {
        return wourkoutDate;
    }

    public void setWourkoutDate(String wourkoutDate) {
        this.wourkoutDate = wourkoutDate;
    }

    public static ArrayList<Work> getWorks() {
        return works;
    }

    public static void setWorks(ArrayList<Work> foods) {
        Work.works = foods;
    }
}
