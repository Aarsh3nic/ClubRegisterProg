
/*
-----------  Class: Tournament --(Prototype(Definition) Class)----
A class which creates private attributes and service methods to set and get data of
a new tournament registration such as number of tournaments registered,
periods, price and other info.
 */

import java.util.Scanner;

public class Tournament {

    private String[] period_desc = {"1 - Period 1: June 3-28", "2 - Period 2: July 1-26", "3 - Period 3: August 5-30"};
    private String[] period_registered = {"","",""};

    private int period_available = 3;

    Scanner scan = new Scanner(System.in);

    public Tournament(){

    }//constructor ends

    public void askToProceed(String mem_f_name){

        //Casually prompting the user to offer another service
        System.out.println("Oh wait you also get a chance to register for the upcoming Soccer Tournament !!\n");
        //scan.nextLine();  // To flush out next line character
        int period_choice;
        boolean isChosen;
        boolean register_more;
        do{
            //Welcome message displayed
            System.out.println("\t\t\t\t\t________________________________________");
            System.out.println("\t\t\t\t\tSummer of 2024 Tournaments Registration.");
            System.out.println("\t\t\t\t\t________________________________________");

            String move_forward = yesOrNo(mem_f_name);

            register_more = false;
             isChosen = false;

            switch (move_forward.toLowerCase()) {
                case "yes":

                        period_choice = validate();

                        isChosen = isRegistered(period_choice);

                        if(isChosen){  // To check if the Period is already chosen or not
                            System.out.println("\n\n!! Already CHOSEN !!");
                            register_more = true;
                        }

                        else{

                            setPeriod_registered(period_choice);

                            if(period_available == 0){
                                System.out.println("\n\t\t\t Wow!! You have registered for all the available " +
                                        "tournaments !!");
                            }
                            else{
                                register_more = true;
                            }
                        }//ideal choice else ends

                    break;
                //case - "YES" ends

                case "no":
                    if(period_available == 3){
                        System.out.println("Alright!! See you soon!!");
                    }

                    break;
                //case - "No" ends

            }

        }while(register_more || isChosen);

        //boolean isValid;

    }//askToProceed() ends

    private String yesOrNo(String mem_f_name){
        String answer;
        boolean isValid;
        do{
            System.out.println("\n\n*--> Do you wish to Register "+ mem_f_name +
                    " with Summer Registration (yes/no) ?");
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

    private int validate(){
        boolean isValid;
        int period_choice;
        do{
            isValid= true;
            System.out.println("\n\n* Periods Available to register your child:");
            for(int i =0 ; i < period_desc.length; i++){
                if(!period_desc[i].isBlank()) {
                    System.out.println("\t\t\t\t\t\t\t\t" + period_desc[i]);
                }
            }// for(choice period) loop ends


            System.out.println("\n\n--> Please Enter your choice:");
            period_choice = scan.nextInt();
            scan.nextLine();  // To flush out next line character
            if(period_choice <1 || period_choice >3){
                System.out.println("Invalid input:" + period_choice);
                System.out.println("Enter 1, 2 or 3 (according to your choice)!");
                isValid = false;
            }
        }while(!isValid);

        return period_choice;

    }//validate() ends

    public boolean isRegistered(int period_choice){

        for(int j=0;j< period_registered.length;j++ ){

            if(!period_registered[j].isBlank()) {
                if ((Integer.parseInt(period_registered[j].substring(0,1))) == period_choice) {
                    return true;
                }
            }
        }

        return false;
    }//isRegistered() ends

    public void setPeriod_registered(int period_choice) {

        period_available--; // reducing available periods after choice
        for(int j=0;j< period_registered.length;j++ ){
            if(period_registered[j].isBlank()){
                period_registered[j] = period_desc[period_choice -1];
                break;
            }
        }//for loop ends - check blank and register
        period_desc[period_choice -1] = "";

    }//setPeriod_registered() ends




    //  **------------------- Tournament DISPLAY snippet BEGINS -----------------------------------**
    public void displayTournaments(String mem_fullName){

        if(period_available==3){
            System.out.println( mem_fullName +" do not have any Summer 2024 Tournament registration.");
        }
        else{
            System.out.println("\n\n" + mem_fullName+
                    " is successfully registered in the following 2024 Summer Tournaments: ");
            for(int j=0;j< period_registered.length;j++ ){
                if(!period_registered[j].isBlank()){
                    System.out.println("\t\t\t\t\t"+ period_registered[j]);
                }
            }//for loop ends - check blank and display
            System.out.println("\n\nThe total Cost of the tournaments registrations is: "+
                    (3.00-period_available)*100 + "$");
        }


    }

    //  **------------------- Tournament DISPLAY snippet ENDS -----------------------------------**


//******************-----------GETTERS-----------******************************


    public String[] getPeriod_registered() {
        return period_registered;
    }


    public int getPeriod_available() {
        return period_available;
    }





}
