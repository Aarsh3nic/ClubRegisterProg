
/*
-----------  Class: SortIt --(Prototype(Definition) Class)------
A class which creates private attributes and service methods to sort the given data
by name and age also to print the sorted list to display it to the user in a formatted manner.
 */

import java.util.Arrays;

public class SortIt {



    private String[][] separated_names= new String[20][2];
    private int[][] date_list = new int[20][3]; // 0- year, 1- month, 2- day


    public SortIt(){

    }//constructor ends

    public void sortByName(int member_index, String[][] separated_names, int[][] date_list){
        String[] temp_name;
        int[] temp_date;
        for(int i = 0; i<=member_index- 1; i++){

            for(int j = i +1; j<=member_index; j++){

                if((separated_names[i][0].toUpperCase()).compareTo(separated_names[j][0].toUpperCase()) >0){
                    temp_name = separated_names[i];
                    separated_names[i] = separated_names[j];
                    separated_names[j] = temp_name;


                    //to change DOB accordingly
                    temp_date = date_list[i];
                    date_list[i] = date_list[j];
                    date_list[j] = temp_date;

                }

            }

        }

        // For Same FIRST NAMES - Sorting by LAST name:

        for(int i = 0; i<=member_index - 1; i++){
            //first = i;

            for(int j = i +1; j<=member_index; j++){

                if((separated_names[i][0].toUpperCase()).compareTo(separated_names[j][0].toUpperCase()) ==0){
                    //first = j;
                    if((separated_names[i][1].toUpperCase()).compareTo(separated_names[j][1].toUpperCase()) >0) {

                        temp_name = separated_names[i];
                        separated_names[i] = separated_names[j];
                        separated_names[j] = temp_name;


                        //to change DOB accordingly
                        temp_date = date_list[i];
                        date_list[i] = date_list[j];
                        date_list[j] = temp_date;
                    }


                }

            }

        }

        this.separated_names = Arrays.copyOf(separated_names, separated_names.length);
        this.date_list = Arrays.copyOf(date_list, date_list.length);

    }//sortByName() ends


    public void sortByDate(int member_index){
        String[] temp_name;
        int[] temp_date;
        //================= Date sorting(age) Starts ==============================
        for(int i = 0 ; i<=member_index-1 ; i++){

            for(int j = i +1; j<=member_index; j++) {

                if(date_list[i][0] < date_list[j][0]){//if year less
                    temp_date = date_list[i];
                    date_list[i] = date_list[j];
                    date_list[j] = temp_date;

                    //to shift name - index as well accordingly
                    temp_name = separated_names[i];
                    separated_names[i] = separated_names[j];
                    separated_names[j] = temp_name;

                }
                else if (date_list[i][0] == date_list[j][0]) {//if year SAME

                    if(date_list[i][1] < date_list[j][1]){//if month less
                        temp_date = date_list[i];
                        date_list[i] = date_list[j];
                        date_list[j] = temp_date;

                        //to shift name - index as well accordingly
                        temp_name = separated_names[i];
                        separated_names[i] = separated_names[j];
                        separated_names[j] = temp_name;

                    }
                    else if (date_list[i][1] == date_list[j][1]) {//if month same

                        if(date_list[i][2] < date_list[j][2]){//if date less
                            temp_date = date_list[i];
                            date_list[i] = date_list[j];
                            date_list[j] = temp_date;

                            //to shift name - index as well accordingly
                            temp_name = separated_names[i];
                            separated_names[i] = separated_names[j];
                            separated_names[j] = temp_name;

                        }
                    }

                }

            }

        }
        //================= Date(age) sorting ends ==============================


    }

    public void printSortedNames(int member_index){
        System.out.println("\n\n\t\tFollowing is the list of the new Members:");
        System.out.println("\t\t-----------------------------------------");

        for(int i = 0; i<=member_index ; i++){
            System.out.println(separated_names[i][0] +" "+ separated_names[i][1]);

        }
    }

    public void printDateSortedNames(int member_index){
        //======================== Display : Names Sorting according to age ==================================

        System.out.println("\n\nThe Youngest new club member who is born on "+date_list[0][2] + "/" +
                date_list[0][1] + "/"+
                date_list[0][0] + " is : " + separated_names[0][0] + " "+
                separated_names[0][1]);
        System.out.println("The Oldest new club member who is born on "+date_list[member_index][2] + "/" +
                date_list[member_index][1] + "/"+
                date_list[member_index][0] + " is : " + separated_names[member_index][0] + " "+
                separated_names[member_index][1]);

    }


    public void printHeader(int member_index){
        System.out.println("\n\n\t\t-----------------------------------------------------------");
        System.out.println("\t\tMontreal Youth Soccer Club (MYSC) have "+ (member_index+1) +" New Registrations:");
        System.out.println("\t\t-----------------------------------------------------------");
    }

    public void printClubHeader(int i){
        System.out.println("\t\t\t\t\t_____________________________________");
        System.out.println("\t\t\t\t\tNew Club Member " + (i+1) +" Registration Details.");
        System.out.println("\t\t\t\t\t_____________________________________");
    }

    //To print end message
    public void printFooter(){
        System.out.println("\n\n\t\t\t\t\t____________________________________________");
        System.out.println("\t\t\t\t\tThank you for using our Registration System.");
        System.out.println("\t\t\t\t\t____________________________________________\n\n");
    }

    public String[][] getseparated_names() {
        return separated_names;
    }

    public int[][] getDate_list() {
        return date_list;
    }
}

