/*
-----------  Class: ClubMember --(Prototype(Definition) Class)----
A class which creates private attributes and service methods to set and get data of
a new club member such as name, address, phone and other info.

 */

import java.util.Scanner;

public class ClubMember {

    private String mem_fullName, mem_f_name="", mem_l_name="";
    private String  mem_address;
    private String temp_phone;
    private long mem_phone;
    private String mem_postal_code;
    private String mem_city;
    private String team;
    private String move_forward;
    private int  mem_birth_day, mem_birth_month, mem_birth_year, num_relation;
    private int num_membership;
    private char mem_gender;
    private boolean valid, correct_entry;
    private String error = "should have at least two characters.";

    Scanner scan = new Scanner(System.in);

    public ClubMember(){

    }//constructor ends


//******************-----------SETTERS-----------******************************




    public void setMem_fullName() {
        String mem_fullName;
        String mem_f_name="";
        String mem_l_name="";
        //scan.nextLine();  // To flush out next line character

        do{
            System.out.println("\n* Please Enter the new club Member's First Name and Last Name:");

            mem_fullName = scan.nextLine();
            if(!mem_fullName.isBlank() && mem_fullName.contains(" ") && mem_fullName.split(" ").length>1) {
                mem_f_name = mem_fullName.split(" ")[0].trim();
                mem_l_name = mem_fullName.split(" ")[1].trim();

                valid = true;

                if (mem_f_name.length() < 2 || mem_l_name.length() < 2) {
                    valid = false;
                    System.out.println("Invalid first name or last name:  " + mem_fullName);
                    System.out.println("First Name and Last Name " + error);
                }
            }
            else{
                valid = false;
                System.out.println("Invalid first name or last name:  " + mem_fullName);
                System.out.println("First Name and Last Name " + error);
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Fullname to list

        this.mem_fullName = mem_fullName;
        setMem_f_name(mem_f_name);
        setMem_l_name(mem_l_name);
    }


    public boolean setMem_birth_year() {
        int mem_birth_year;
        do{
            System.out.println("\n* Please Enter the Year Of Birth (2014 and 2020):");

            mem_birth_year = scan.nextInt();
            scan.nextLine();  // To flush out next line character

            if(mem_birth_year>2020 || mem_birth_year <2014){
                valid = false;
                System.out.println("Invalid Year Of Birth: " + mem_birth_year);
                System.out.println("Valid Year Of Birth between 2014 and 2020");

                do {
                    System.out.println("\n*--> Do you wish to continue (yes/no) ?");
                    move_forward = scan.nextLine();
                    correct_entry = true;
                    switch (move_forward.toLowerCase()) {
                        case "yes":
                            System.out.println("Alright!!");
                            break;

                        case "no":
                            valid = true;
                            System.out.println("\n\n\t\t\t * Sorry, There is no membership for your child's age.");
                            return false;
                            //break;

                        default:
                            System.out.println("Please enter a valid choice (yes/no)");
                            correct_entry = false;
                    }
                }while(!correct_entry);

            }
            else{
                valid = true;
            }

        }while(!valid);

        this.mem_birth_year = mem_birth_year;
        return true;
        //Adding validated NEW CLUB Member - Birth Year to list

    }//Setting BIRTH YEAR ENDS


    public void setMem_birth_month() {
        int mem_birth_month;

        do{
            System.out.println("\n* Please Enter the Month Of Birth (1 - 12):");

            mem_birth_month = scan.nextInt();

            if(mem_birth_month>12 || mem_birth_month <1){
                valid = false;
                System.out.println("Invalid Month Of Birth: " + mem_birth_month);
                System.out.println("Valid Month Of Birth between 1 and 12");

            }
            else{
                valid = true;
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Birth Month to list
        this.mem_birth_month = mem_birth_month;
    }


    public void setMem_birth_day() {
        int mem_birth_day;
        do{
            System.out.println("\n* Please Enter the Day Of Birth (1 - 31):");

            mem_birth_day = scan.nextInt();

            if(mem_birth_day>31 || mem_birth_day <1){
                valid = false;
                System.out.println("Invalid Day Of Birth: " + mem_birth_day);
                System.out.println("Valid Day Of Birth between 1 and 31");

            }
            else{
                valid = true;
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Birth Day to list
        this.mem_birth_day = mem_birth_day;
    }

    public void setMem_gender() {
        char mem_gender;
        scan.nextLine();  // To flush out next line character
        do{
            System.out.println("\n* Please Enter the Gender Of the new club member (M/F): ");

            mem_gender = scan.nextLine().toLowerCase().charAt(0);

            if(Character.compare(mem_gender, 'm') != 0 && Character.compare(mem_gender, 'f') != 0){
                valid = false;
                System.out.println("Invalid Gender " + mem_gender);
                System.out.println("Choose among Male ('M') or Female ('F') !");

            }
            else{
                valid = true;
            }

        }while(!valid);

        this.mem_gender = mem_gender;

        if(Character.compare(mem_gender, 'm') == 0){
            setTeam("Boys");
        }
        else{
            setTeam("Girls");

        }
    }

    public void setMem_address() {
        String mem_address;
        do{
            System.out.println("\n* Please new club member's Address:");

            mem_address = scan.nextLine();
            valid = true;

            if(mem_address.length()<2){
                valid = false;
                System.out.println("Invalid Address: " + mem_address);
                System.out.println("Address " + error);
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Address to list

        this.mem_address = mem_address;
    }


//    public void setTemp_phone(String temp_phone) {
//        this.temp_phone = temp_phone;
//    }

    public void setMem_postal_code() {
        String mem_postal_code;
        do{
            System.out.println("\n* Please Enter new club member's Postal Code (A1A1A1):");

            mem_postal_code = scan.nextLine().toUpperCase();
            valid = true;

            if(mem_postal_code.length() != 6){
                valid = false;
                System.out.println("Invalid Postal code: " + mem_postal_code);
                System.out.println("Postal Code " + "should have six characters (Leave no space)");
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Postal Code to list
        this.mem_postal_code = mem_postal_code;
    }

    public void setMem_city() {
        String mem_city;
        do{
            System.out.println("\n* Please Enter new club member's City:");

            mem_city = scan.nextLine();
            valid = true;

            if(mem_city.length()<2){
                valid = false;
                System.out.println("Invalid City: " + mem_city);
                System.out.println("City " + error);
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - City to list
        this.mem_city = mem_city;
    }

    public void setMem_phone() {
        long mem_phone;

        do{
            System.out.println("\n* Please Enter new club member's Phone Number:");

            mem_phone = scan.nextLong();
            valid = true;

            if(mem_phone <1000000000){
                valid = false;
                System.out.println("Invalid Phone: " + mem_phone);
                System.out.println("Valid Phone Number contains at least 10 digits.");
            }

        }while(!valid);
        //Adding validated NEW CLUB Member - Phone to list
        this.mem_phone = mem_phone;
    }

    public void setNum_membership() {
        //Generating MEMBERSHIP number
        int max = 9999;
        int min = 1000;
        int range = max - min + 1;
        this.num_membership = (int)( Math.random() * range) + min;
    }


    public void setTeam(String team) {
        this.team = team;
    }

    public void setMem_f_name(String mem_f_name) {
        this.mem_f_name = mem_f_name;
    }


    public void setMem_l_name(String mem_l_name) {
        this.mem_l_name = mem_l_name;
    }


    public void setNum_relation(int num_relation) {
        this.num_relation = num_relation;
    }


//******************-----------GETTERS-----------******************************

    public String getMem_fullName() {
        return mem_fullName;
    }

    public String getMem_f_name() {
        return mem_f_name;
    }

    public String getMem_l_name() {
        return mem_l_name;
    }

    public String getMem_address() {
        return mem_address;
    }


    public String getMem_postal_code() {
        return mem_postal_code;
    }

    public int getMem_birth_day() {
        return mem_birth_day;
    }

    public int getMem_birth_month() {
        return mem_birth_month;
    }

    public int getMem_birth_year() {
        return mem_birth_year;
    }

    public int getNum_relation() {
        return num_relation;
    }

    public String getTeam() {
        return team;
    }

    public String getMem_city() {
        return mem_city;
    }

    public char getMem_gender() {
        return mem_gender;
    }

    public long getMem_phone() {
        return mem_phone;
    }

    public int getNum_membership() {
        return num_membership;
    }

    //******************-----------Display methods-----------******************************

    public void printClubMember(){
        // New Club member info
        System.out.println("\n\nThe new club member " + getMem_fullName() + " who lives at: "
                + getMem_address()  + " in the city of " + getMem_city()  +
                " with postal code " + getMem_postal_code()  );
        temp_phone = ""+ getMem_phone();
        System.out.println("Has the following Telephone Number: " + temp_phone.substring(0,3) +
                "-" + temp_phone.substring(3,6) + "-" + temp_phone.substring(6,10) +
                " is successfully added to the MYSC " + getTeam() + " teams.");
    }



}//end of class
