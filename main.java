import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
   Cesar Marquez
   CEN 3024C - Software Development 1
   October 20, 2025
   main.java v.2
   This application is for the Liverpool F.C Roster Manager
   It will have the UI and the user will be able to interact with this program
 */
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        inputCheck inputCheck = new inputCheck();

        soccerPlayer soccerPlayer = new soccerPlayer();

        ArrayList<String> playerList = new ArrayList<String>();

        String jerseyIns = "Please enter player's jersey number from 1-99 : ";
        String ageIns = "Please enter player's age from 18-45 : ";
        String nameIns = "Please enter player's name: ";
        String nationalityIns = "Please enter player's nationality: ";
        String positionIns = "Please enter player's position: ";
        String footIns = "Please enter player's dominant foot; 'L' , 'R', or 'B': ";
        String athleIns = "Please enter player's athleticism from 0-100 : ";
        String attackIns = "Please enter player's attacking skill from 0-100: ";
        String defenseIns = "Please enter player's defense skill from 0-100: ";
        String soccerIns = "Please enter player's soccer skill from 0-100: ";

        String menuIns = "\nWhat would you like to select \n" +
                "==============================\n" +
                "|1)Read Data\n" +
                "|2)Display Roster (Display Data)\n" +
                "|3)Sign Player (Add Data)\n" +
                "|4)Release Player (Remove data)\n" +
                "|5)Update Player Data (Update data)\n" +
                "|6)Calculate Overall Rating (Custom Feature)\n" +
                "|7)Sort Player by Jersey Number (Custom Feature)\n" +
                "|8)Exit Program\n" +
                "==============================\n" +
                "Enter your choice: ";

        String updateIns =  "\nWhat would you like to update \n" +
                "==============================\n" +
                "|1)player's name\n" +
                "|2)Player's age\n" +
                "|3)Player Nationality\n" +
                "|4)player's position\n" +
                "|5)Player's dominant foot\n" +
                "|6)Player's athleticism\n" +
                "|7)Player's attacking skill\n" +
                "|8)Player's defense\n" +
                "|9)Player's soccer skill\n" +
                "|10)Exiting player update, back to main menu\n" +
                "==============================\n" +
                "Enter your choice: ";

        //menu cap options
        int menuCapOne = 8;
        int menuCapTwo = 10;
        int userChoice;

        //user input variables for soccer player
        int inputNumber;
        String inputName;
        String inputnationality;
        int inputAge;
        String inputPosition;
        char inputDominantFoot;
        int ath;
        int att;
        int def;
        int soc;
        float overallRating;

        boolean playerExits = false;

        //variables for return messages from methods
        String newPlayer;
        String message;

        //variable for files
        String userFile= "";
        boolean exits = false;
        boolean currentOpenFile = false;



        System.out.println();
        System.out.println("================================");
        System.out.println("  Liverpool F.C Roster Manager  ");
        System.out.println("================================");
        System.out.println();

        System.out.println("Header/Quick information");
        System.out.println("The purpose of this application is to manage the Liverpool F.C. players roaster.\n" +
                "As the new season starts soon, the coach needs to have access to  player information such as:\n" +
                "Jersey number, name, age, nationality, position, dominant foot, player athleticism, attacking skill, defense and soccer skills");


        /*
            This exit-controlled loop will have the UI
            Will display the menu with the options
            exit when the user wants to exit.
         */

        do{

            userChoice= inputCheck.menu(menuIns,menuCapOne);

            //Read Data
            if(userChoice == 1){

                System.out.println();
                System.out.println("====================");
                System.out.println("     Read Data      ");
                System.out.println("====================");
                System.out.println();

                //user cannot open multiple file
                if(currentOpenFile == true){
                    System.out.println("File: "+ userFile + " is already open");
                    System.out.println("Exit the program to enter the new file");
                }

                else{


                    do{

                        System.out.print("Please enter the file name: ");
                        userFile = sc.nextLine();
                        exits = inputCheck.fileCheck(playerList, userFile);

                        if(exits == true){
                            currentOpenFile = true;
                        }

//                        Path path = Paths.get(userFile);
//
//                        //try & catch for file opening if it exits
//                        try{
//                            BufferedReader br = Files.newBufferedReader(path);
//                            String line;
//
//                            while((line = br.readLine()) !=null){
//                                playerList.add(line);
//                            }
//                            br.close();
//
//                            if(playerList.isEmpty()){
//                                System.out.println("File: " + userFile + " is empty");
//                                System.out.println("Please try again");
//                            }
//                            else{
//                                System.out.println("File: " + userFile + " was successfully found");
//                                currentOpenFile = true;
//                                exits = true;
//
//                            }
//                        }
//                        catch(IOException e){
//                            System.out.println("File not found, try again");
//
//                        }

                    }while(!exits);
                }


            }

            //Display Roster (Display Data)
            else if(userChoice == 2){

                System.out.println();
                System.out.println("==============================");
                System.out.println("Display Roster (Display Data) ");
                System.out.println("==============================");
                System.out.println();

                soccerPlayer.displayRoster(playerList);

            }

            //Sign Player (Add Data)
            else if(userChoice == 3){

                System.out.println();
                System.out.println("==============================");
                System.out.println("    Sign Player (Add Data)    ");
                System.out.println("==============================");
                System.out.println();

                if(playerList.isEmpty()){
                    System.out.println("No data found");
                    System.out.println("Please enter the data file");
                }

                else{

                    inputNumber =       inputCheck.jerseyNumber(playerList, jerseyIns);
                    inputName =         inputCheck.playerInfo(nameIns);
                    inputAge =          inputCheck.playerAge(ageIns);
                    inputnationality =  inputCheck.playerInfo(nationalityIns);
                    inputPosition =     inputCheck.position(positionIns);
                    inputDominantFoot = inputCheck.dominantFoot(footIns);
                    ath =               inputCheck.playerStat(athleIns);
                    att =               inputCheck.playerStat(attackIns);
                    def =               inputCheck.playerStat(defenseIns);
                    soc =               inputCheck.playerStat(soccerIns);

                    //return message to the user
                    newPlayer = String.valueOf(inputNumber) +"-" + inputName + "-" + inputAge + "-" + inputnationality + "-" + inputPosition + "-" + inputDominantFoot + "-" + ath + "-" + att + "-" + def + "-" + soc;
                    message = soccerPlayer.signPlayer(playerList,newPlayer);

                    System.out.println();
                    System.out.println(message);
                }

            }

            //Release Player (Remove data)
            else if(userChoice == 4){

                System.out.println();
                System.out.println("==============================");
                System.out.println(" Release Player (Remove Data) ");
                System.out.println("==============================");
                System.out.println();

                if(playerList.isEmpty()){
                    System.out.println("No Roster found");
                }

                else{

                    inputNumber = inputCheck.jerseyNumber(jerseyIns);

                    message = soccerPlayer.releasePlayer(playerList,inputNumber);

                    System.out.println();
                    System.out.println(message);
                }

            }


            //Update Player Data (Update data)
            else if(userChoice == 5){

                System.out.println();
                System.out.println("==============================");
                System.out.println("  Update Player (Update Data) ");
                System.out.println("==============================");
                System.out.println();

                if(playerList.isEmpty()){
                    System.out.println("No Roster found");
                }

                else
                {


                    inputNumber = inputCheck.jerseyNumber(jerseyIns);

                    System.out.println();
                    playerExits = soccerPlayer.overallRating(inputNumber,playerList);

                    if(playerExits == true){

                        /*
                        This exit-controlled loop will the update menu
                        Will display the menu with the options to update player information
                        exit when the user wants to exit.
                        */
                        do{

                            //second menu
                            userChoice= inputCheck.menu(updateIns,menuCapTwo);

                            if(userChoice == 1){

                                //update name
                                inputName = inputCheck.playerInfo(nameIns);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputName );

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputName );
                                System.out.println(message);
                            }
                            else if(userChoice == 2){

                                //update age
                                inputAge = inputCheck.playerAge(ageIns);
                                String age = String.valueOf(inputAge);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, age);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, age);
                                System.out.println(message);
                            }
                            else if(userChoice == 3){

                                //update nationality
                                inputnationality = inputCheck.playerInfo(nationalityIns);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputnationality );

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputnationality );
                                System.out.println(message);
                            }
                            else if(userChoice == 4){

                                //update position
                                inputPosition = inputCheck.position(positionIns);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputPosition);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, inputPosition );
                                System.out.println(message);
                            }
                            else if(userChoice == 5){

                                //update dominant foot
                                inputDominantFoot = inputCheck.dominantFoot(footIns);
                                String foot = String.valueOf(inputDominantFoot);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, foot);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, foot);
                                System.out.println(message);
                            }
                            else if(userChoice == 6){

                                //update athleticism
                                ath = inputCheck.playerStat(athleIns);
                                String athel = String.valueOf(ath);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, athel);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, athel);
                                System.out.println(message);
                            }
                            else if(userChoice == 7){

                                //update attacking
                                att = inputCheck.playerStat(attackIns);
                                String attack = String.valueOf(att);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, attack);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, attack);
                                System.out.println(message);
                            }
                            else if(userChoice == 8){

                                //update defense
                                def = inputCheck.playerStat(defenseIns);
                                String defense = String.valueOf(def);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, defense);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, defense);
                                System.out.println(message);
                            }
                            else if(userChoice == 9){

                                //update soccer skills
                                soc =  inputCheck.playerStat(soccerIns);
                                String soccer= String.valueOf(soc);
                                soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, soccer);

                                message = soccerPlayer.updatePlayer(playerList, inputNumber, userChoice, soccer);
                                System.out.println(message);
                            }
                            else if(userChoice == 10){

                                System.out.println("Exit updating current soccer player");

                            }
                        }while(userChoice != 10);

                    }

                    else{
                        System.out.println("Sorry, player not found");
                    }

                }

            }

            //Calculate Overall Rating (Custom Feature)
            else if(userChoice == 6){

                System.out.println();
                System.out.println("==========================================");
                System.out.println("Calculate Overall Rating (Custom Feature) ");
                System.out.println("==========================================");
                System.out.println();

                if(playerList.isEmpty()){
                    System.out.println("No Roster found");
                }

                else{

                    inputNumber = inputCheck.jerseyNumber(jerseyIns);

                    overallRating = soccerPlayer.overallRating(playerList,inputNumber);

                    if(overallRating == 0){
                        System.out.println("Sorry player not found");
                        System.out.println("Overall rating: " + overallRating);
                    }

                    else{

                        System.out.printf("PlayerOverall rating: %.2f", overallRating);
                        System.out.println();
                    }
                }

            }


            //Sort Player (Custom Feature)
            else if(userChoice == 7){

                System.out.println();
                System.out.println("================================");
                System.out.println("  Sort Player (Custom Feature)  ");
                System.out.println("================================");
                System.out.println();

                message = soccerPlayer.sortPlayer(playerList);
                System.out.println(message);

                soccerPlayer.displayRoster(playerList);

            }

            //Exit Program
            else if(userChoice == 8){

                System.out.println();
                System.out.println("==================");
                System.out.println("   Exit Program   ");
                System.out.println("==================");
                System.out.println();

                //updated the file
                try{
                    Path exitPath = Paths.get(userFile);
                    Files.write(exitPath, playerList);
                }
                catch(IOException e){
                    System.out.println("Unable to write to the file");

                }

            }

        }while(userChoice!= 8);
    }
}
