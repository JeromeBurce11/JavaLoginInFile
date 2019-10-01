/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 2ndyrGroupC
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity4login;

import activity4login.personalInformation;
import activity4login.Accounts;
import activity4login.Schedule1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author burceje_sd2023
 */
public class Register {

    ArrayList<Accounts> Accounts1 = new ArrayList<Accounts>();
    ArrayList<personalInformation> PersonalInfo = new ArrayList<personalInformation>();
     ArrayList<Schedule1> Schedule = new ArrayList<Schedule1>();
    public int age;
    public String fname;
    public String lname;
    public int units;

    public void AddUserPass() {
        String username;
        boolean status = true;
        while (status) {
            System.out.print("Username: ");
            try {

                username = input.next();
                if (isString(username) == true) {
                    System.out.println("Invalid input!");
                } else {
                    while (true) {
                        try {
                            System.out.print("Password: ");
                            String password = input.next();
                            if (password.length() < 8) {
                                throw new Exception("Password must have 8 characters!");
                            } else {
                                while (true) {
                                    System.out.print("Confirm Password: ");
                                    String password1 = input.next();
                                    if (password.equals(password1)) {
                                        System.out.println(" password match!");
                                        System.out.println("you what to save your account?\n[1] yes\n[2] no");
                                        int SaveAns = input.nextInt();
                                        if (SaveAns == 1) {
                                            FileWriter fWriter = new FileWriter("Account.txt", true);
                                            BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                                            String line = reader.readLine();
                                            while (line != null) {
                                                if (line.length() != 0) {
                                                    ++id;
                                                    //  ++accID;
                                                }
                                                line = reader.readLine();
                                            }
                                            PrintWriter writer = new PrintWriter(fWriter);
                                            writer.println(id + "\t" + username + "\t" + password);

                                            // Accounts1.add(new Accounts(id, username, password));
                                            writer.close();

                                            status = false;
                                            break;
                                        } else {
                                            option();
                                        }

                                    } else {
                                        System.out.println(" Mismatch password!");
                                    }
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }

                    }
                }
            } catch (Exception e) {
                break;
            }

        }
    }

    //LoginClass a = new LoginClass();
    Scanner input = new Scanner(System.in);
    static int id = 1;

    public boolean isString(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void option() throws IOException {

        boolean flag = true;
        while (flag) {
            System.out.println("+++++Student Enrollment+++++\nSelect an option: \n1 = CREATE ACCOUNT\n2 = RETRIEVE\n3 = UPDATE\n4 = DELETE\n5 = SEARCH\n6 = Exit");
            int optionAns = input.nextInt();
            switch (optionAns) {
                case 1:
                    System.out.println("-----------------Creating an account!-----------------");
                    AddUserPass();
                    personalInformation();
                    courseUnitSched();
                    System.out.println(Accounts1);
                    break;
                case 2:
                    System.out.println("SHOW:\n[1] ACCOUNTS\n[2] PERSONAL INFORMATION\n[3] SCHEDULES\n");
                    int retrieveOptionAns = input.nextInt();
                    switch(retrieveOptionAns){
                        case 1:
                            this.retrieveDataInFileAccounts();
                            break;                        
                        case 2:
                            this.retrieveDataInFilePersonalInfo();
                            break;
                        case 3:
                            this.retrieveDataInFileSchedule();
                            break;
                    }

                    break;
                case 3:
                    UpdatePersonalInfo();

                    break;
                case 4:
                    System.out.println(Accounts1);
                    break;
                case 5:

                    break;
                case 6:
                    flag = false;

            }
        }
    }

//    public void Retrieve() {
//        System.out.println("--- Retrieve Accounts ---");
//
//        for (int i = 0; i < this.Accounts1.size(); i++) {
//            System.out.println(Accounts1.get(i));
//        }
//        System.out.println("--- Retrieve Personal Information ---");
//        for (int i = 0; i < this.PersonalInfo.size(); i++) {
//            System.out.println(PersonalInfo.get(i).getId() + "\t" + PersonalInfo.get(i).getAccNumber() + "\t" + PersonalInfo.get(i).getFname() + "\t" + PersonalInfo.get(i).getAge() + "\n");
//        }
//    }

    public void UpdatePersonalInfo() {
        System.out.println("--- Update Personal Accounts ---");
        // System.out.println("Select\n[1] Accouts\n[2] Personal Information\n[3] Schedules");
        System.out.println("Enter a AccountId:");
        int in = input.nextInt();
        for (int i = 0; i < PersonalInfo.size(); i++) {
            if (PersonalInfo.get(i).getAccNumber() == in) {
                Scanner newInput = new Scanner(System.in);
                System.out.println("Enter new firstname:");
                String newfirstname = newInput.nextLine();
                this.PersonalInfo.get(i).setFname(newfirstname);

                System.out.println("Enter new lastname:");
                String newlastname = newInput.nextLine();
                this.PersonalInfo.get(i).setLname(newlastname);
                System.out.println("Enter new age:");
                int age = newInput.nextInt();
                this.PersonalInfo.get(i).setAge(age);

            }
        }

    }

    public void save() throws IOException {
        this.clearTheFile();
        FileWriter fWriter = new FileWriter("personalInformation.txt", true);
        PrintWriter writer = new PrintWriter(fWriter);
        BufferedReader reader = new BufferedReader(new FileReader("personalInformation.txt"));
        String line = reader.readLine();
        int AccountId = 1;
        while (line != null) {
            if (line.length() != 0) {
                AccountId++;
                //  ++accID;
            }
            line = reader.readLine();
        }
        String course;
        for (personalInformation e : this.PersonalInfo) {
            writer.println(e);
        }
        writer.close();
    }

    public void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("personalInformation.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
     public void retrieveDataInFileAccounts() throws IOException {
        System.out.println("--- RETRIEVE ---");
        System.out.println("\n*********************** ACCOUNTS ***********************");
        Accounts1 = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\Activity4Login\\Account.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] partsA = line.split("\t");
                Accounts1.add(new Accounts(Integer.parseInt(partsA[0]), partsA[1], partsA[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
     public void retrieveDataInFilePersonalInfo() throws IOException {
        System.out.println("--- RETRIEVE ---");
        System.out.println("\n************************ PERSONAL INFORMATION *******************************");
        Accounts1 = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\Activity4Login\\personalInformation.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] partsA = line.split("\t");
                Accounts1.add(new Accounts(Integer.parseInt(partsA[0]), partsA[1], partsA[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
        public void retrieveDataInFileSchedule() throws IOException {
        System.out.println("--- RETRIEVE ---");
        System.out.println("\n************************ SCHEDULE *******************************");
        Accounts1 = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\Activity4Login\\personalInformation.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] partsA = line.split("\t");
                Accounts1.add(new Accounts(Integer.parseInt(partsA[0]), partsA[1], partsA[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    
    
   

    public void deleteDataInFile() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("personalInformation.txt"));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();

        }

    }

    public void courseUnitSched() {

        while (true) {
            System.out.println("You want to add a subject?\nPress 1 = if yes\nPress 0 = if no");
            int ans = input.nextInt();
            try {
                if (ans == 1) {
                    System.out.print("Course: ");
                    String course = input.next();
                    checkUnit();
                    System.out.print("Schedule: ");
                    String schedule = input.next();

                    FileWriter fWriter = new FileWriter("schedule.txt", true);

                    PrintWriter writer = new PrintWriter(fWriter);
                    BufferedReader reader = new BufferedReader(new FileReader("Schedule.txt"));
                    String line = reader.readLine();
                    int AccountId = 1;
                    while (line != null) {
                        if (line.length() != 0) {
                            AccountId++;
                            //  ++accID;
                        }
                        line = reader.readLine();
                    }
                    writer.println(AccountId + "\t" + id + "\t" + course + "\t" + units + "\t" + schedule + "\n");
//                    Schedule.add(new Schedule(id, AccountId, course, units, schedule));

                    writer.close();

                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }
        System.out.println("Your schedule was been saved.");

    }

    public void personalInformation() {
        try {
            this.checkFname();
            this.checkLname();
            this.checkAge();

            FileWriter fWriter = new FileWriter("personalInformation.txt", true);
            PrintWriter writer = new PrintWriter(fWriter);

            BufferedReader reader = new BufferedReader(new FileReader("personalInformation.txt"));
            String line = reader.readLine();
            int AccountId = 1;
            while (line != null) {
                if (line.length() != 0) {
                    AccountId++;

                }
                line = reader.readLine();
            }

            writer.println(id + "\t" + AccountId + "\t" + fname + "\t" + lname + "\t" + age + "\n");
            PersonalInfo.add(new personalInformation(id, AccountId, fname, lname, age));

            writer.close();
        } catch (Exception e) {
            System.out.println(" input is require!");

        }
    }

    public void checkAge() {

        String ageS;
        while (true) {

            try {

                while (true) {
                    System.out.println("age: ");
                    Scanner age = new Scanner(System.in);
                    ageS = age.nextLine();
                    int convert = Integer.parseInt(ageS);
                    if (convert == 0) {
                        System.out.println("months of age!");
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("invalid input!");
            }
        }
        this.age = Integer.parseInt(ageS);
    }

    public void checkUnit() {

        String unit;
        while (true) {
            try {
                while (true) {
                    System.out.println("Unit: ");
                    Scanner units = new Scanner(System.in);
                    unit = units.nextLine();
                    int convert = Integer.parseInt(unit);
                    if (convert == 0) {
                        System.out.println("unit must not equal to 0 !");
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Unit must be an integer!");
            }
        }
        this.units = Integer.parseInt(unit);
    }

    public void checkFname() {
        String FName = null;

        while (true) {
            System.out.println("enter Firstname: ");
            Scanner firstname = new Scanner(System.in);
            try {
                FName = firstname.nextLine();
                Integer.parseInt(FName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;

            }

        }
        this.fname = FName;
    }

    public void checkLname() {
        String LName = null;
        while (true) {
            System.out.println("enter Lastname: ");
            Scanner lastname = new Scanner(System.in);
            try {
                LName = lastname.nextLine();
                Integer.parseInt(LName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;

            }

        }
        this.lname = LName;
    }

}
