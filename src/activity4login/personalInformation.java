package activity4login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author burceje_sd2023
 */
public class personalInformation {

    private String fname;

    public void setFname(String fname) {
        this.fname = fname;
    }
    private String lname;
    private int age;
    private int accNumber;
    private int id;

    public personalInformation() {
    }

    public personalInformation(int id, int accNumber, String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.accNumber = accNumber;
        this.id = id;
    }

    public personalInformation(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;

    }

    public personalInformation(int Id,int accNumber,String fname, String lname) {
        
        this.id = id;
        this.accNumber = accNumber;
        this.fname = fname;
        this.lname = lname;

    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  public String toString(){
        return String.format("%d\t%d\t%s\t%s\t%d", this.id,this.accNumber,this.fname,this.lname,this.age);
    }
}
