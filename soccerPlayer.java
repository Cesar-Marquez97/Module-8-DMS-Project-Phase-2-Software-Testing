import java.util.*;
/*
   Cesar Marquez
   CEN 3024C - Software Development 1
   October 20, 2025
   soccerPlayer.java v.2
   This will handle soccer player info and cover the CRUD
   There are seven methods and a few overloading
 */
public class soccerPlayer {

    private int jerseyNumber;
    private String playerName;
    private int age;
    private String nationality;
    private String position;
    private char dominantFoot;
    private int athleticism;
    private int attackingSkill;
    private int defense;
    private int soccerSkill;

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public char getDominantFoot() {
        return dominantFoot;
    }

    public void setDominantFoot(char dominantFoot) {
        this.dominantFoot = dominantFoot;
    }

    public int getAthleticism() {
        return athleticism;
    }

    public void setAthleticism(int athleticism) {
        this.athleticism = athleticism;
    }

    public int getAttackingSkill() {
        return attackingSkill;
    }

    public void setAttackingSkill(int attackingSkill) {
        this.attackingSkill = attackingSkill;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSoccerSkill() {
        return soccerSkill;
    }

    public void setSoccerSkill(int soccerSkill) {
        this.soccerSkill = soccerSkill;
    }

    /*
      method: signPlayer (add data)
      parameters: arraylist String playerList, string new player
      return: String
      purpose: add a new player to the roster
      requirements: none
    */
    public String signPlayer(ArrayList<String> playerList, String newPlayer) {


        String signInfo = newPlayer;

        //brekaing the string into part
        String jersey = signInfo.split("-")[0];
        String name = signInfo.split("-")[1];
        String age = signInfo.split("-")[2];
        String nationality = signInfo.split("-")[3];
        String position = signInfo.split("-")[4];
        String foot = signInfo.split("-")[5];
        String playerAth = signInfo.split("-")[6];
        String playerAtt = signInfo.split("-")[7];
        String playerDef = signInfo.split("-")[8];
        String playerSoc = signInfo.split("-")[9];

        String message =    "Successfully Signed Player: \n" +
                            "Jersey Number: " + jersey + "\n" +
                            "Player Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Nationality: " + nationality + "\n" +
                            "Position: " + position + "\n" +
                            "Dominant Foot: " + foot + "\n" +
                            "Athleticism: " + playerAth + "\n" +
                            "Attacking Skill: " + playerAtt + "\n" +
                            "Defense: " + playerDef + "\n" +
                            "Soccer Skill: " + playerSoc + "\n";

        playerList.add(newPlayer);

        return message;
    }

    /*
      method: release player (remove data)
      parameters: arraylist String playerList, int jerseyNumber
      return: String
      purpose: remove specific player from the roster
      requirements: none
    */
    public String releasePlayer(ArrayList<String> playerList, int jerseyNumber) {

        String searchJersey = String.valueOf(jerseyNumber);

        for (int i = 0; i < playerList.size(); i++) {

            //Each line from the file
            String players = playerList.get(i);

            //brekaing the string into part
            String jersey = players.split("-")[0];
            String name = players.split("-")[1];
            String age = players.split("-")[2];
            String nationality = players.split("-")[3];
            String position = players.split("-")[4];
            String foot = players.split("-")[5];
            String playerAth = players.split("-")[6];
            String playerAtt = players.split("-")[7];
            String playerDef = players.split("-")[8];
            String playerSoc = players.split("-")[9];

            if (jersey.contains(searchJersey)) {

                String message = "Successfully Release Player: \n" +
                        "Jersey Number: " + jersey + "\n" +
                        "Player Name: " + name + "\n" +
                        "Age: " + age + "\n" +
                        "Nationality: " + nationality + "\n" +
                        "Position: " + position + "\n" +
                        "Dominant Foot: " + foot + "\n" +
                        "Athleticism: " + playerAth + "\n" +
                        "Attacking Skill: " + playerAtt + "\n" +
                        "Defense: " + playerDef + "\n" +
                        "Soccer Skill: " + playerSoc + "\n";

                playerList.remove(i);

                return message;

            }

        }
        return "player not found";
    }

    /*
       method: displayRoster
       parameters: arrayList string playerList
       return: void
       purpose: display current player roster
       requirements: none
     */
    public void displayRoster(ArrayList<String> playerList) {

        if (playerList.isEmpty()) {
            System.out.println("No Roster");
        }
        else {

            System.out.println();
            for (String s : playerList) {

                System.out.println("Liverpool player");

                //split the data to display
                String[] playerData = s.split("-");

                System.out.println("Jersey Number: " + playerData[0]);
                System.out.println("Player Name: " + playerData[1]);
                System.out.println("Age: " + playerData[2]);
                System.out.println("Nationality: " + playerData[3]);
                System.out.println("Position: " + playerData[4]);
                System.out.println("Dominant Foot: " + playerData[5]);
                System.out.println("Athleticism: " + playerData[6]);
                System.out.println("attacking Skill: " + playerData[7]);
                System.out.println("Defense: " + playerData[8]);
                System.out.println("Soccer Skill: " + playerData[9]);
                System.out.println();

            }
        }


    }

    /*
      method: sortPlayer
      parameters: arrayList string playerList
      return: String
      purpose: sort the player jersey number from small to large
      requirements: none
    */
    public String sortPlayer(ArrayList<String>playerList){


        if (playerList.isEmpty()) {
            return "No Roster";
        }

        else{

            //using the comparator for this task
            Collections.sort(playerList, new Comparator<String>() {

                //sorting the player based on jersey from small number to largest
                @Override
                public int compare(String player1, String player2) {

                    int temp1 = Integer.parseInt(player1.split("-")[0]);
                    int temp2 = Integer.parseInt(player2.split("-")[0]);

                    if (temp1 > temp2) {
                        //temp2 is smallest
                        return 1;
                    }
                    else if (temp1 < temp2) {
                        //temp1 is smallest
                        return -1;
                    }
                    else
                        // both equal
                        return 0;

                }
            });

            return "Successfully Sorted";

        }
    }

    /*
      method: UpdatePlayer (update data)
      parameters: arrayList string playerList, int jerseyNumber, int senction, string info
      return: String
      purpose: update information from a specific player
      requirements: none
    */
    public String updatePlayer(ArrayList<String>playerList, int jerseyNumber, int section, String info) {

        String searchJersey = String.valueOf(jerseyNumber);


        int index;

        for (int i = 0; i < playerList.size(); i++) {

            //Each line from the file
            String players = playerList.get(i);

            //brekaing the string into part
            String jersey = players.split("-")[0];

            String name = players.split("-")[1];
            String age = players.split("-")[2];
            String nationality = players.split("-")[3];
            String position = players.split("-")[4];
            String foot = players.split("-")[5];
            String playerAth = players.split("-")[6];
            String playerAtt = players.split("-")[7];
            String playerDef = players.split("-")[8];
            String playerSoc = players.split("-")[9];

            //conditional statement to updated player information
            if (jersey.contains(searchJersey)) {

                //index of which file line to updated
                index = i;

                String message =    "\n==============================================\n" +
                        "Update Player Information: \n" +
                        "Jersey Number: " + jersey + "\n" +
                        "Player Name: " + name + "\n" +
                        "Age: " + age + "\n" +
                        "Nationality: " + nationality + "\n" +
                        "Position: " + position + "\n" +
                        "Dominant Foot: " + foot + "\n" +
                        "Athleticism: " + playerAth + "\n" +
                        "Attacking Skill: " + playerAtt + "\n" +
                        "Defense: " + playerDef + "\n" +
                        "Soccer Skill: " + playerSoc + "\n" +
                        "==============================================\n";

                //Update name
                if(section == 1){
                    name = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated name: " + name +"\n"+
                            message;


                }

                //Update age
                else if(section == 2){
                    age = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated age: " + age +"\n"+
                            message;
                }

                //Update nationality
                else if(section == 3){
                    nationality = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated nationality: " + nationality+"\n"+
                            message;
                }

                //Update position
                else if(section == 4){
                    position = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated position: " + position+"\n"+
                            message;
                }

                //Update dominant foot
                else if(section == 5){
                    foot = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated foot: " + foot+"\n"+
                            message;
                }

                //Update athleticism
                else if(section == 6){
                    playerAth = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated athleticism: " + playerAth+"\n"+
                            message;
                }

                //Update attack skill
                else if(section == 7){
                    playerAtt = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated attacking skills: " + playerAtt+"\n"+
                            message;
                }

                //Update defense
                else if(section == 8){
                    playerDef = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated defense: " + playerDef+"\n"+
                            message;
                }

                //Update soccer skills
                else if(section == 9){
                    playerSoc = info;

                    String updateInfo = jersey+"-"+name+"-"+age+"-"+nationality+"-"+position+"-"+foot+"-"+playerAth+"-"+playerAtt+"-"+playerDef+"-"+playerSoc;
                    playerList.set(index, updateInfo);

                    return "\nUpdated attacking skills: " + playerSoc+"\n"+
                            message;
                }

            }

        }
        return "fail to updated";
    }

    /*
      method: overallRating (Custom action)
      parameters: ArrayList String, int jerseyNumber
      return: float
      purpose: calculate the overall player rating
      requirements: none
     */
    public float overallRating(ArrayList<String> playerList, int jerseyNumber) {

        String searchJersey = String.valueOf(jerseyNumber);

        for(int i = 0; i < playerList.size(); i++) {

            //Each line from the file
            String players = playerList.get(i);

            //Get the part of the file line that I need
            String playerNumber = players.split("-")[0];
            String playerName = players.split("-")[1];
            String playerAth = players.split("-")[6];
            String playerAtt = players.split("-")[7];
            String playerDef = players.split("-")[8];
            String playerSoc = players.split("-")[9];

            if(playerNumber.contains(searchJersey)) {

                System.out.println("player: " + playerName);

                int ath = Integer.parseInt(playerAth);
                int att = Integer.parseInt(playerAtt);
                int def = Integer.parseInt(playerDef);
                int soc = Integer.parseInt(playerSoc);

                //calculation
                return (float) (ath + att + def + soc) / 4;
            }

        }
        return 0;
    }

    /*
      Method Overloading
      method: overallRating (Custom action) - For Update player
      parameters: int jerseyNumber , ArrayList String
      return: boolean
      purpose: display of the player information if the player exits
      requirements: none
     */
    public boolean overallRating(int jerseyNumber ,ArrayList<String> playerList) {

        String searchJersey = String.valueOf(jerseyNumber);

        for (int i = 0; i < playerList.size(); i++) {

            //Each line from the file
            String players = playerList.get(i);

            //Get the part of the file line that I need
            String playerNumber = players.split("-")[0];
            String playerName = players.split("-")[1];
            String age = players.split("-")[2];
            String nationality = players.split("-")[3];
            String position = players.split("-")[4];
            String foot = players.split("-")[5];
            String playerAth = players.split("-")[6];
            String playerAtt = players.split("-")[7];
            String playerDef = players.split("-")[8];
            String playerSoc = players.split("-")[9];

            if (playerNumber.contains(searchJersey)) {

                System.out.println("player Name: " + playerName);
                System.out.println("player Age: " + age);
                System.out.println("player Nationality: " + nationality);
                System.out.println("player Position: " + position);
                System.out.println("player Dominant Foot: " + foot);
                System.out.println("player Athleticism: " + playerAth);
                System.out.println("player Attacking Skill: " + playerAtt);
                System.out.println("player Defense: " + playerDef);
                System.out.println("player Athleticism: " + playerSoc);
                System.out.println();

                return true;
            }

        }
        return false;
    }
}




