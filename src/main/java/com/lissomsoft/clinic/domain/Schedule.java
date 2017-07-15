package com.lissomsoft.clinic.domain;

import java.util.List;

/**
 * Created by Lissomsoft on 06/15/17.
 */
public class Schedule {

    private Integer schedule_id;
    private Integer branch_id;
    private Integer doctor_id;
    private String start_time;
    private String end_time;
    private String start_date;
    private String end_date;
    private Integer end_type;
    private Integer no_of_occurenes;
    private Integer time;
    private Integer scount;
    private Schedule_day day_flag;
    private String day_flags;

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getEnd_type() {
        return end_type;
    }

    public void setEnd_type(Integer end_type) {
        this.end_type = end_type;
    }


    public Integer getNo_of_occurenes() {
        return no_of_occurenes;
    }

    public void setNo_of_occurenes(Integer no_of_occurenes) {
        this.no_of_occurenes = no_of_occurenes;
    }

    public Schedule_day getDay_flag() {
        return day_flag;
    }

    public void setDay_flag(Schedule_day day_flag) {
        this.day_flag = day_flag;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public String getDay_flags() {
        return day_flags;
    }

    public void setDay_flags(String day_flags) {
        this.day_flags = day_flags;
    }

    public  String toString(){

        return "Schedule {"+
                " branch_id ="+branch_id+
                " doctor_id =" +doctor_id+
                " start_time ="+start_time+
                " end_time ="+end_time+
                " start_date ="+start_date+
                " end_date ="+end_date+
                " end_type ="+end_type+
                " no_of_occurenes ="+no_of_occurenes+
                " day_flag ="+day_flag+
                " time ="+time+
                " scount ="+scount+
                " day_flags ="+day_flags+
                '}';
    }



}
