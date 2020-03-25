package edu.gdut.gytw.volunteerMIS.entity;

public class VolunteerActivity {
    private int id;
    private String title;
    private String time;
    private String request;
    private String details;

    public VolunteerActivity() {
        this.title = null;
        this.time = null;
        this.request = null;
        this.details = null;
    }

    public VolunteerActivity(String title, String time, String request, String detailed) {
        this.title = title;
        this.time = time;
        this.request = request;
        this.details = detailed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
