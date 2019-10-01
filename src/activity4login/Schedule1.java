/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity4login;

/**
 *
 * @author 2ndyrGroupC
 */
public class Schedule1 {

    static void add(Schedule1 schedules) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int id;
    private int accId;
    private String course;
    private int year;
    private int units;
    private String schedule;
    private String subject;

    public Schedule1() {
    }

    public Schedule1(int id, int accId, String course,  String schedule,  int units) {
        this.id = id;
        this.accId = accId;
        this.course = course;
     
        this.units = units;
        this.schedule = schedule;
       
    }

    public Schedule1(int id, int AccountId, String course, int units, String schedule) {
        this.id = id;
        this.accId = AccountId;
        this.course = course;
        this.units = units;
        this.schedule = schedule;
        //To change body of generated methods, choose Tools | Templates.
    }

    Schedule1(int parseInt, int parseInt0, String element, String element0, String element1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
