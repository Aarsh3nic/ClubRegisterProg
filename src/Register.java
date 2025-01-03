
/*
-----------  Class: Register --(Driver Class)------
A class which creates objects of all the other classes and calls their methods
to run the program accordingly to register new Family Member and Club member.
It also prompts to check if the user wants to register to Summer tournaments or
want to register more members.

-----------            Functionality of Program     ----------------------
This Java program helps add new members to the Montréal Youth Soccer Club (MYSC).
Users can register up to 20 new members by entering their first name, last name, and birthdate.
After all members are added, the program sorts and displays the list of new members in alphabetical
order by their first and last names. It also shows who the youngest and oldest members are based on their birthdates.
This makes it easy to manage and organize new club members.
 */



public class Register {

    public static void main(String[] args) {

         int member_index = 0;
         boolean addMore;
         boolean move_next;

         //Declaring Array of objects
         FamilyMember[] familyMember = new FamilyMember[20];
         ClubMember[] clubMember = new ClubMember[20];
         Tournament[] tournament = new Tournament[20];
         SortIt sorted = new SortIt();

         //Declaring arrays to store names and birthdates temporarily
         String[][] separated_names = new String[20][2];
         int[][] date_list = new int[20][3]; // 0- year, 1- month, 2- day


        //-------------------------------- Input: ** BIG LOOP **  STARTS -----------------------------------------
        do {

            addMore=false;

            //Initialising objects
            familyMember[member_index] = new FamilyMember();
            clubMember[member_index] = new ClubMember();
            tournament[member_index] = new Tournament();

            //--------------------------Family Member INPUT starts-------------------------------
            familyMember[member_index].setFam_fullName();
            familyMember[member_index].setFam_relation();
            familyMember[member_index].setFam_address();
            familyMember[member_index].setFam_city();
            familyMember[member_index].setFam_postal_code();
            familyMember[member_index].setFam_phone();

            //--------------------------Family Member INPUT ends-------------------------------


            //--------------------------Club Member INPUT starts-------------------------------

            clubMember[member_index].setMem_fullName();
            move_next = clubMember[member_index].setMem_birth_year();

            if(move_next){
                clubMember[member_index].setMem_birth_month();
                clubMember[member_index].setMem_birth_day();
                clubMember[member_index].setMem_gender();
                clubMember[member_index].setMem_address();
                clubMember[member_index].setMem_city();
                clubMember[member_index].setMem_postal_code();
                clubMember[member_index].setMem_phone();
                clubMember[member_index].setNum_membership();

                //--------------------------Club Member INPUT ends-------------------------------


                // ******************* SUMMER TOURNAMENT REGISTRATION STARTS ******************************

                tournament[member_index].askToProceed(clubMember[member_index].getMem_f_name());
                tournament[member_index].displayTournaments(clubMember[member_index].getMem_fullName());
                addMore = familyMember[member_index].addMember();

            }// To validate if user want to continue after wrong/right birth-year
            else{
                sorted.printFooter();
                System.exit(0);
            }


            member_index++; // incrementing count of members

        }while(addMore);

        member_index--; // to deduct an extra increment
        //-------------------------------- Input: ** BIG LOOP **  Ends -----------------------------------------


//      **----------------------------------------      DISPLAY      -------------------------------------------**


        sorted.printHeader(member_index);

//                                           **------ MEMBER DETAILS ---------**

        for(int i =0 ; i<=member_index ; i++){

            sorted.printClubHeader(i);

            familyMember[i].printFamilyMember(clubMember[i].getMem_fullName(), clubMember[i].getNum_membership());
            clubMember[i].printClubMember();

//                               **------ Sorting names ---------**

            //initializing Date array to Associate names with it

                date_list[i][0] = clubMember[i].getMem_birth_year();
                date_list[i][1] = clubMember[i].getMem_birth_month();
                date_list[i][2] = clubMember[i].getMem_birth_day();

                //adding names to array
                separated_names[i][0] = clubMember[i].getMem_f_name();
                separated_names[i][1] = clubMember[i].getMem_l_name();

        }//for ends

        //======================== Display: Alphabetically SORTED names ==================================

        sorted.sortByName(member_index, separated_names, date_list);
        sorted.printSortedNames(member_index);

        //======================== Display : Names Sorting according to age ==================================

        sorted.sortByDate(member_index);
        sorted.printDateSortedNames(member_index);
        sorted.printFooter();

    }//main method ends


}//Register Class ends
