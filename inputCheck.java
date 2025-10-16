import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
   Cesar Marquez
   CEN 3024C - Software Development 1
   October 20, 2025
   inputCheck.java v.2
   This will handle the user inputs
   There are 7 methods and a few overloading
 */
public class inputCheck {


    int number;
    String playerInfo;
    int age;
    String position;
    char dominantFoot;
    int playerStat;

    /*
    method: jerseyNumber
    parameters: arrayList string, string instruction
    return: int
    purpose: handles user input for player jersey and check if the number is taken
    requirements: jersey number range from 1-99
    */
    public boolean fileCheck(ArrayList<String> playerList, String fileName) {

        Path path = Paths.get(fileName);

        //try & catch for file opening if it exits
        try{
            BufferedReader br = Files.newBufferedReader(path);
            String line;

            while((line = br.readLine()) !=null){
                playerList.add(line);
            }
            br.close();

            if(playerList.isEmpty()){
                System.out.println("File: " + fileName + " is empty");
                System.out.println("Please try again");
                return false;
            }
            else{
                System.out.println("File: " + fileName + " was successfully found");
                return true;

            }
        }
        catch(IOException e){
            System.out.println("File not found, try again");

        }

        return false;
    }
    /*
    method: jerseyNumber
    parameters: arrayList string, string instruction
    return: int
    purpose: handles user input for player jersey and check if the number is taken
    requirements: jersey number range from 1-99
    */
    public int jerseyNumber(ArrayList<String> playerList, String instruction ) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{

                number = sc.nextInt();
                String searchJersey = String.valueOf(number);
                boolean takenJersey = false;

                for(int i = 0; i < playerList.size(); i++) {

                    //Each line from the file
                    String players = playerList.get(i);

                    //Get the part of the file line that I need
                    String playerNumber = players.split("-")[0];

                    if(playerNumber.equals(searchJersey)) {
                        System.out.println("Sorry, " + number + " is taken");
                        takenJersey = true;
                        break;
                    }

                }

                if(number <= 0 || number >= 100){
                    System.out.println("Sorry, jersey number need to be from 1-99");
                }
                else if(!takenJersey) {
                    pass = true;
                    return number;
                }

            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a integer");
                sc.next();

            }


        }while(!pass);

        return number;
    }

    /*
    Method Overloading
    method: jerseyNumber
    parameters: string instruction, arrayList string
    return: int
    purpose: handles user input for player jersey for calculate overall rating, release player, updateplayer
    requirements: jersey number range from 1-99
    */
    public int jerseyNumber(String instruction ) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{
                number = sc.nextInt();

                if(number <=0 || number >= 100 ){
                    System.out.println("Sorry, jersey number need to be from 1-99");
                }
                else{
                    pass = true;
                    return number;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a integer");
                sc.next();

            }

        }while(pass != true);

        return number;
    }

    /*
     method: playerInfo
    parameters: string instruction(name and nationality)
    return: String
    purpose: handles user input for player name & nationality
    requirements: none
   */
    public String playerInfo(String instruction) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{
                playerInfo = sc.nextLine();

                if(playerInfo.isBlank() || playerInfo.isEmpty()){
                    System.out.println("Sorry, you need to enter the player information");
                }

                //checks for input that is only numbers
                else if(playerInfo.matches("\\d+")){
                    System.out.println("Sorry, the player information cannot be only numbers");
                }

                else {
                    pass = true;
                    return playerInfo;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a string");
                sc.next();
            }

        }while(pass != true);

        return playerInfo;
    }

    /*
     method: playerAge
    parameters: string instruction(age)
    return: int
    purpose: handles user input for player age
    requirements: age from 18-45
   */
    public int playerAge(String instruction) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{
                age = sc.nextInt();

                if(age < 18 || age > 45 ){
                    System.out.println("Sorry, age need to be from 18-45");

                }

                else{
                    pass = true;
                    return age;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a integer");
                sc.next();

            }

        }while(pass != true);

        return age;
    }

    /*
    method: position
    parameters: string instruction(position)
    return: String
    purpose: handles user input for player position
    requirements: none
    */
    public String position(String instruction) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{
                position = sc.nextLine();

                if(position.isBlank() || position.isEmpty()){
                    System.out.println("Sorry, you need to enter the player's position");
                }

                //checks for input that is only numbers
                else if(position.matches("\\d+")){
                    System.out.println("Sorry, the player information cannot be numbers");
                }

                else {
                    pass = true;
                    return position;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a string");
                sc.next();
            }

        }while(pass != true);

        return position;
    }

    /*
   method: dominantFoot
   parameters: string instruction(dominant foot)
   return: char
   purpose: handles user input for player dominant foot
   requirements: can only be: L, R, B
   */
    public char dominantFoot(String instruction) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{

                dominantFoot = sc.next().charAt(0);
                //dominantFoot = Character.toUpperCase(dominantFoot);

                if(dominantFoot == 'L' || dominantFoot == 'l'){
                    pass = true;
                    return dominantFoot;
                }
                else if(dominantFoot == 'R' || dominantFoot == 'r'){
                    pass = true;
                    return dominantFoot;
                }
                else if(dominantFoot == 'B' || dominantFoot == 'b'){
                    pass = true;
                    return dominantFoot;
                }

                //checks for no inputs
                else if(dominantFoot =='\n'){
                    System.out.println("Sorry, no input was detected");
                }

                else {
                    System.out.println("Sorry, the only valid input are L, R, B");
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a char");
                sc.next();
            }

        }while(pass != true);

        return dominantFoot;
    }

    /*
     method: playerStat
    parameters: string instruction(athleticism, attack, defense, soccer skill)
    return: int
    purpose: handles user input for player stats
    requirements: age from 0-100
   */
    public int playerStat(String instruction) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        do{

            System.out.print(instruction);

            try{
                playerStat = sc.nextInt();

                if(playerStat < 0 || playerStat > 100 ){
                    System.out.println("Sorry, player stat need to be from 0-100");
                }

                else{
                    pass = true;
                    return playerStat;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a integer");
                sc.next();

            }

        }while(pass != true);



        return playerStat;
    }

    /*
  method: menu
  parameters: int menu cap
  return: int
  purpose: handles the menu
  */
    public int menu(String menu, int menuCap) {

        Scanner sc = new Scanner(System.in);
        boolean pass = false;

        int choice = 0;

        do{

            System.out.print(menu);

            try{

                choice = sc.nextInt();

                if(choice < 1 || choice > menuCap ){
                    System.out.println("Sorry, invalid choice");

                }
                else{
                    pass = true;
                    return choice;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalid input, it needs to be a integer");
                sc.next();
            }

        }while(pass != true);

        return choice;
    }
}
