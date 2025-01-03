
/*
-----------  Class: FamilyMember --(Prototype(Definition) Class)------
A class which creates private attributes and service methods to set and get data of
a new family member such as name, address, phone and other info.

 */


import java.util.Scanner;

public class FamilyMember {

    Scanner scan = new Scanner(System.in);

    private String fam_fullName;
    private String fam_f_name ="";
    private String fam_l_name="";
    private String fam_address;
    private String fam_relation ="";
    private String fam_postal_code;
    private String fam_city;
    private String temp_phone;
    private long fam_phone;
    private boolean valid;
    private String error = "should have at least two characters.";
    private final String[] relation = {"Father","Mother", "GrandFather", "GrandMother", "Tutor",
            "Partner","Friend", "Other"};


    public FamilyMember(){

    }//constructor ends

    public FamilyMember(String fam_address, String fam_l_name, String fam_f_name) {
        this.fam_address = fam_address;
        this.fam_l_name = fam_l_name;
        this.fam_f_name = fam_f_name;
    }
    public String getFam_fullName() {
        return fam_fullName;
    }


//******************-----------SETTERS-----------******************************


    public void setFam_fullName() {
        String fam_fullName = "";
        String fam_f_name = "";
        String fam_l_name = "";

        do{
            System.out.println("\n* Please Enter Your family Member's First Name and Last Name:");


            fam_fullName = scan.nextLine();
            if(!fam_fullName.isBlank() && fam_fullName.contains(" ") && fam_fullName.split(" ").length>1) {
                //Checking for any kind of blank inputs
                fam_f_name = fam_fullName.split(" ")[0].trim();
                fam_l_name = fam_fullName.split(" ")[1].trim();

                valid = true;

                if (fam_f_name.length() < 2 || fam_l_name.length() < 2) {
                    valid = false;
                    System.out.println("Invalid first name or last name:  " + fam_fullName);
                    System.out.println("First Name and Last Name " + error);
                }
            }
            else{
                valid = false;
                System.out.println("Invalid first name or last name:  " + fam_fullName);
                System.out.println("First Name and Last Name " + error);
            }

        }while(!valid);
        //Adding validated Family member - Fullname to list

        this.fam_fullName = fam_fullName.trim();
        setFam_f_name(fam_f_name);
        setFam_l_name(fam_l_name);
    }//set - FULLNAME ends

    public void setFam_relation() {

        int num_relation;
        String fam_relation="";

        do{
            System.out.println("\n* Please Enter the Relationship between the family " +
                    "member and the new club member:");

            System.out.println("\t\t\t\t\t\t1 - Father\n" +
                    "\t\t\t\t\t\t2 - Mother\n"+
                    "\t\t\t\t\t\t3 - GrandFather\n"+
                    "\t\t\t\t\t\t4 - GrandMother\n"+
                    "\t\t\t\t\t\t5 - Tutor\n"+
                    "\t\t\t\t\t\t6 - Partner\n"+
                    "\t\t\t\t\t\t7 - Friend\n"+
                    "\t\t\t\t\t\t8 - Other\n");

            System.out.println("* Please Enter your choice (1-8):");

            num_relation = scan.nextInt();
            valid = true;

            if(num_relation >8 || num_relation <1){
                valid = false;
                System.out.println("Invalid Relationship: " + num_relation);
                System.out.println("Valid Relationship between 1 and 8");
            }

        }while(!valid);

        switch (num_relation){    //Assigning relation according to user's choice

            case 1:
                fam_relation = relation[0];
                break;

            case 2:
                fam_relation = relation[1];
                break;

            case 3:
                fam_relation = relation[2];
                break;

            case 4:
                fam_relation = relation[3];
                break;

            case 5:
                fam_relation = relation[4];
                break;

            case 6:
                fam_relation = relation[5];
                break;

            case 7:
                fam_relation = relation[6];
                break;

            case 8:
                fam_relation = relation[7];
                break;

        }

        //Adding validated Family member - relation to list
        this.fam_relation = fam_relation;
    }// set Family relation ends


    public void setFam_address() {

        String fam_address="";

        scan.nextLine();  // To flush out next line character
        do{
            System.out.println("\n* Please Enter Your Address:");

            fam_address = scan.nextLine();
            valid = true;

            if(fam_address.length()<2){
                valid = false;
                System.out.println("Invalid Address: " + fam_address);
                System.out.println("Address " + error);
            }

        }while(!valid);
        //Adding validated Family member - Address to list

        this.fam_address = fam_address;
    }

    public void setFam_city() {
        String fam_city;
        do{
            System.out.println("\n* Please Enter Your City:");

            fam_city = scan.nextLine();
            valid = true;

            if(fam_city.length()<2){
                valid = false;
                System.out.println("Invalid City: " + fam_city);
                System.out.println("City " + error);
            }

        }while(!valid);
        //Adding validated Family member - city to list

        this.fam_city = fam_city;
    }


    public void setFam_postal_code() {
        String fam_postal_code;
        do{
            System.out.println("\n* Please Enter Your Postal Code (A1A1A1):");

            fam_postal_code = scan.nextLine().toUpperCase();
            valid = true;

            if(fam_postal_code.length() != 6){
                valid = false;
                System.out.println("Invalid Postal code: " + fam_postal_code);
                System.out.println("Postal Code " + "should have six characters (Leave no space)");
            }

        }while(!valid);

        this.fam_postal_code = fam_postal_code;
    }



    public void setFam_phone() {
        long fam_phone;
        do{
            System.out.println("\n* Please Enter Your Phone Number:");

            fam_phone = scan.nextLong();
            valid = true;

            if(fam_phone <1000000000){
                valid = false;
                System.out.println("Invalid Phone: " + fam_phone);
                System.out.println("Valid Phone Number contains at least 10 digits.");
            }

        }while(!valid);
        this.fam_phone = fam_phone;
    }

    public boolean addMember(){
        String answer = yesOrNo();
        switch(answer.toLowerCase()){

            case "yes":
                System.out.println("Alright!!, Let's go!");
                return true;

            case "no":
                System.out.println("\n\n\t\t\t * Okay, See you soon. BYE\n");
                return false;

            default: return false; // required by compiler to set
        }

    }

    private String yesOrNo(){
        String answer;
        scan.nextLine();  // To flush out next line character
        boolean isValid;
        do{
            System.out.println("\n**--> Do you wish to add more members to the club (yes/no) ?");
            answer = scan.nextLine();

            if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")){
                isValid = true;
            }
            else{
                System.out.println("Please enter a valid choice (yes/no)");
                isValid = false;
            }

        }while(!isValid);

        return answer;
    }

    public void setFam_f_name(String fam_f_name) {
        this.fam_f_name = fam_f_name;
    }


    public void setFam_l_name(String fam_l_name) {
        this.fam_l_name = fam_l_name;
    }



//******************-----------GETTERS-----------******************************

    public long getFam_phone() {
        return fam_phone;
    }

    public String[] getRelation() {
        return relation;
    }

    public String getFam_city() {
        return fam_city;
    }

    public String getFam_postal_code() {
        return fam_postal_code;
    }

    public String getFam_relation() {
        return fam_relation;
    }

    public String getFam_address() {
        return fam_address;
    }

    public String getFam_l_name() {
        return fam_l_name;
    }

    public String getFam_f_name() {
        return fam_f_name;
    }

//******************-----------Display methods-----------******************************

    public void printFamilyMember(String mem_fullName, int num_membership){
        // Family member info
        System.out.println(getFam_fullName()+" "+ getFam_relation() +
                " of the new MYSC club member");
        System.out.println(mem_fullName +
                " with new MYSC club membership #" + num_membership );
        System.out.println("Lives at: "+ getFam_address() + " in the city of " + getFam_city() +
                " with postal code " + getFam_postal_code() );
        temp_phone = ""+ getFam_phone();
        System.out.println("Has the following Telephone Number: " + temp_phone.substring(0,3) +
                "-" + temp_phone.substring(3,6) + "-" + temp_phone.substring(6,10));

    }

}//class ends
