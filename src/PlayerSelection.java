/*
 * Name of project: PlayerSelection (Team Selection Simulator)
 * Name of author: Jachin Hugh Dzidumor Kpogli
 * Date created: 19th September, 2025
 * Purpose: This program allows user input for a single player's name, age, height (in m),
 *          weight(in lbs) and jersey number. It then converts the weight to kg and height to 
 *          cm. It then uses this data to determine their category, position, attacker status, eligibility,
 *          lineup and final decision. Finally, it generates a Player Report based on user input and determined data.
 */

import java.util.Scanner; // Import Scanner class to read user input from stdin

public class PlayerSelection {
    public static void main(String[] args) throws Exception {

        //Constants declaration
        final float POUND = 0.45359237f;
        final float METER = 100;

        Scanner sc = new Scanner(System.in); // Create Scanner object

        // Read player details and convert when needed (ie. height and weight)
        System.out.println("Enter the player's name: ");
        String name = sc.nextLine();
        System.out.println("Enter the player's age: ");
        byte age = sc.nextByte();
        System.out.println("Enter the player's height in meters: ");
        double height_in_cm =  METER * (float) sc.nextDouble(); // initially in meters
        System.out.println("Enter the player's weight in lbs: ");
        double weight_in_kg = (int) (POUND * (float) sc.nextDouble()); // initially in pounds
        System.out.println("Enter the player's jersey_number: ");
        byte jersey_number = sc.nextByte();

        // Determine player category
        String playerCategory;
        if (age<20) playerCategory = "Rising Star";
        else if (age>=20 && age<=30) playerCategory = "Prime Player";
        else playerCategory = "Veteran";

        // Determine player position
        String playerPosition;
        switch (jersey_number) {
            case 1: playerPosition = "Goalkeeper"; break;
            case 5:
            case 2: playerPosition ="Defender"; break;
            case 8:
            case 6: playerPosition = "Midfielder"; break;
            case 11:
            case 7: playerPosition  = "Winger"; break;
            case 9: playerPosition = "Striker"; break;
            case 10: playerPosition = "Playmaker"; break;
            default: playerPosition = "Player position not known"; 
        }

        // Determine attacker status
        String attackerStatus = (jersey_number == 9)? "Yes":"No";

        // Determine eligibility
        String playerEligibility = "";
        boolean eligibility_bool_flag = (age>=18 && age <= 35 && weight_in_kg < 90);
        
        if (eligibility_bool_flag) {
            playerEligibility = "Eligible";
        }
        else if (age < 18) {
            playerEligibility = "Not Eligible";
        }
        else if (age > 35) {
            playerEligibility = "Not Eligible";
        }
        else if (weight_in_kg >= 90 || age < 18) {
            playerEligibility = "Not Eligible";
        }
        else if (!eligibility_bool_flag) {
            playerEligibility = "Not Eligible";
        }

        // Determine lineup decision
        String playerLineup;
        if (playerCategory=="Prime Player") {
            if (weight_in_kg < 80) {
                playerLineup = "Starting lineup";
            } else {
                playerLineup = "Bench";
            }
        }
        else playerLineup = "Bench";

        // Determine final decision
        String final_decision = (eligibility_bool_flag)? "Play": "Rest";

        // Display Player Report
        System.out.println("\nPlayer Report");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + playerCategory +")");
        System.out.println("Height: " + height_in_cm + "cm");
        System.out.println("Weight: " + weight_in_kg + "kg");
        System.out.println("Jersey: " + jersey_number);
        System.out.println("Position: " + playerPosition);
        System.out.println("Attacker jersey: " + attackerStatus);
        System.out.println("Eligibility: " + playerEligibility);
        System.out.println("Lineup Decision: " + playerLineup);
        System.out.println("Final Decision: " + final_decision);


        /*
            Unwanted fall-through demo
        */
        //Allow fall-through for player position determination
        switch (jersey_number) {
            case 1: playerPosition = "Goalkeeper"; break;
            case 5: playerPosition = "Defender"; break;
            case 2: playerPosition = "Defender";
            case 8: playerPosition = "Midfielder"; break;
            case 6: playerPosition = "Midfielder";
            case 11: playerPosition = "Winger"; break;
            case 7: playerPosition = "Winger";
            case 9: playerPosition = "Striker"; break;
            case 10: playerPosition = "Playmaker"; break;
            default: playerPosition = "Player position not known"; 
        }

        // Display Player Report
        System.out.println("\n\nPlayer Report (unwanted fall-through allowed)");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + playerCategory +")");
        System.out.println("Height: " + height_in_cm + "cm");
        System.out.println("Weight: " + weight_in_kg + "kg");
        System.out.println("Jersey: " + jersey_number);
        System.out.println("Position: " + playerPosition);
        System.out.println("Attacker jersey: " + attackerStatus);
        System.out.println("Eligibility: " + playerEligibility);
        System.out.println("Lineup Decision: " + playerLineup);
        System.out.println("Final Decision: " + final_decision);
    }
}
