/*************************************
 * Project: FinalAssessment.
 * Programmer: Ali Syed
 * Date: June 10, 2021
 * Program: FinalAssessment.java
 * Description: Creating a Role-playing game battle between Mario and Bowser
 * utilizing the many concepts taught in the course so far. The user will also
 * have the option to play as Bowser or Luigi.
 *************************************/

package pkgfinal.assessment;
import java.util.Scanner;

public class FinalAssessment { //Start of Public Class.

public static void main(String[] args) { //Start of Main Method.
    
    Scanner scanN = new Scanner (System.in); //Create Numeric Scanner.
    Scanner scanS = new Scanner (System.in); //Create Statement Scanner.
    
    //Create a variable that will display the number of turns that have passed.
    int turn_count = 1; //This will increase by 1 each time an action is performed.
    
    //Create HP (Hit Point) variables.    
    int bowser_HP = 0; // This variable starts off at zero but will vary for the character depending on who the user chooses to play as.
    int mario_HP = 0; // This variable starts off at zero but will vary for the character depending on who the user chooses to play as.
    int luigi_HP = 0; // This variable starts off at zero but will become a set amount if the user chooses to play as Luigi.
    
    //Create variables that will store the total damage for each character. Displayed during combat report.
    int totaldamage_M = 0; //Stores the total damage Mario has taken from enemy attacks.
    int totaldamage_L = 0; //Stores the total damage Luigi has taken from enemy attacks.
    int totaldamage_B = 0; //Stores the total damage Bowser has taken from enemy attacks.
    
    /*These variables will be used if the user chooses to play as Mario.
    Mario's Jump and Hammer attack are counterparts to Bowser's Punch and Firebreath.
    The variable Mario_attack will be used to initialize Mario's attacks.
    */
    int mario_attack; //This variable will be used whenver Mario uses an attack. Both when he's the player and enemy character.
    int jump; //Attack command if user plays as Mario. Also used by Mario if the user plays as Bowser.
    int jump_reportcount = 0; //Number of jumps used if the user plays Mario. Displayed during combat report.
    int hammer; //Attack command if the user plays as Mario. Also used by Mario if the user plays as Bowser.
    int hammer_reportcount = 0; //Number of hammer swings used if the user plays as Mario. Displayed during combat report.
    int fire_flower; //Attack command if the user plays as Mario. Also used by Mario if the user plays as Bowser.
    int fireflower_count = 2; //Number of Firee Flowers remaining if the user plays as Mario.
    int fireflower_reportcount = 0; //Number of Fire flowers used. Displayed during combat report.
    int ice_flower; //Attack command if the user plays as Mario. Also used by Mario if the user plays as Bowser.
    int iceflower_count = 2; //Number of Ice Flowers remaining if the user plays as Mario.
    int iceflower_reportcount = 0; //Number of Ice flowers used if the user plays as Mario. Displayed during combat report.
    int mushroom_count = 2; //Healing command if the user plays as Mario. Also used by Mario if the user plays as Bowser.
    int mushroom_reportcount = 0; //Number of mushrooms used if the user plays as Mario. Displayed during combat report.
    
    /* These variables will be used by the enemy if the player chose to play as Bowser.
    Mario will still use the Jump, Hammer, Fire_flower, Ice_flower and Mushroom variables.
    */
    int mega_mushroom; //Enemy attack used by Mario if the user chooses to play as Bowser.
    int copy_flower; //Enemy attack used by Mario if the user chooses to play as Bowser.
    int boomerang_flower; //Enemy attack used by Mario if the user chooses to play as Bowser.
    
    //These variables will be used by the enemy if the player chooses to play as Mario.
    int bowser_attack; //This variable will be used whenever Bowser uses an attack. Both when he's the player character and the enemy. 
    int punch; //Attack command if the user plays as Bowser. Also used by Bowser if user plays as Mario.
    int punch_reportcount = 0; //Number of punches used. Displayed during Combat Report.
    int claw; //Enemy attack used by Bowser if user plays as Mario.
    int ground_pound; //Enemy attack used by Bowser if user plays as Mario. 
    int shell_spin; //Enemy attack used by Bowser if user plays as Mario. 
    int fire_breath; //Attack command if the user plays as Bowser. Also used by Bowser if user plays as Mario.
    int firebreath_reportcount = 0; //Number of fire breaths used. Displayed during Combat Report.
    
    //These variables will be used by the enemy if the player chooses to play as Luigi.
    int shell_cannon; //Enemy attack used by Bowser if user plays as Luigi.
    int weakened_shellcannon; //Weakened version of shell cannon used by Bowser if the user plays as Luigi.
    int flying_slam; //Enemy attack used by Bowser if user plays as Luigi.
    int weakened_flyingslam; //Weakened version of flying slam used by Bowser if the user plays as Luigi.
    int meteor_rain; //Enemy attack used by Bowser if user plays as Luigi.
    int weakened_meteorrain; //Weakened version of meteor rain used by Bowser if the user plays as Luigi.
    int hammer_throw; //Enemy attack used by Bowser if user plays as Luigi.
    int weakened_hammerthrow; //Weakened version of hammer throw used by Bowser if the user plays as Luigi.
    int mechakoopa_mayhem; //Enemy attack used by Bowser if user plays as Luigi.
    int weakened_mechakoopamayhem; //Weakened version of mechakoopa mayhem used by Bowser if the user plays as Luigi.
    
    /*
    These variables will be used if the user chooses to play as Bowser.
    Bowser will also use the Punch and Fire_breath attack.
    These two attacks are counterparts to Mario's Jump and Hammer.
    The variable Bowser_attack will be used to initialize Bowser's attacks.
    Bowser will not use the following variables if the user is playing as him:
    Claw, Ground_pound and Shell_spin.
    */
    int goomba_storm; //Attack command if the user plays as Bowser.
    int goombastorm_count = 1; //Total number of Goomba storms remaining.
    int goombastorm_reportcount = 0; //Total number of Goomba storms used. Displayed during Combat Report.
    int shyguy_squad; //Attack command if the user plays as Bowser.
    int shyguysquad_count = 1; //Total number of Shy Guy squads remaining.
    int shyguysquad_reportcount = 0; //Total number of Shy Guy squads used. Displayed during Combat Report.
    int koopa_corps; //Attack command if the user plays as Bowser.
    int koopacorps_count = 1; //Total number of Koopa corps remaining.
    int koopacorps_reportcount = 0; //Total number of Koopa corps used. Displayed during Combat Report.
    int bobomb_blitz; //Attack command if the user plays as Bowser.
    int bobombblitz_count = 1; //Total number of Bob-omb Blitz's remaining.
    int bobombblitz_reportcount = 0; //Total number of Bob-omb Blit'z used. Displayed during Combat Report.
    int magikoopa_brigade; //Attack command if the user plays as Bowser.
    int magikoopabrigade_count = 1; //Total number of Magikoopa Brigades remaining.
    int magikoopabrigade_reportcount = 0; //Total number of Magikoopa Brigades used. Displayed during Combat Report.
    int drumstick_count = 3; //Healing command if the user plays as Bowser.
    int drumstick_reportcount = 0; //Total number of Drumsticks used. Displayed during Combat Report.
    
    //These variables will be used by the player if they choose to play as Luigi.
    int luigi_attack; //This variable will be used whenever Luigi uses an attack.
    int thunder; //Attack command if the user plays as Luigi.
    int thunder_reportcount = 0; //Total number of thunder attacks used. Displayed during Combat Report.
    int greenmissle; //Attack command if the user plays as Luigi.
    int greenmissle_reportcount = 0; //Total number of green missles used. Displayed during Combat Report.
    int capefeather; //Attack command if the user plays as Luigi.
    int capefeather_count = 1; //Total number of Cape feathers remaining.
    int capefeather_reportcount = 0; //Total number of Cape feathers used. Displayed during Combat Report.
    int tanookisuit; //Attack command if the user plays as Luigi.
    int tanookisuit_count = 1; //Total number of Tanooki suits remaining.
    int tanookisuit_reportcount = 0; //Total number of Tanooki suits used. Displayed during Combat Report.
    int blueshell; //Attack command if the user plays as Luigi.
    int blueshell_count = 1; //Total number of Blue shells remaining.
    int blueshell_reportcount = 0; //Total number of Blue shells used. Displayed during Combat Report.
    
    //Variable that will store the user's player choice.
    int user_choice; 
    
    //Variable that stores user's choice for skipping the story.
    String skip_story;
    
    do { //Do while loop that asks the user if they want to skip the story. 
    System.out.println("Would you like to hear the story? Please input Yes or No.");
    skip_story = scanS.nextLine(); //Prompt user.
    
    //If statement for if the user chooses not to skip the story.
    if (skip_story.equalsIgnoreCase("Yes")) {
    story();
    break;
    }
    
    //If the user chooses to skip the story.
    else if (skip_story.equalsIgnoreCase("no")){ 
    System.out.println("You have chosen to skip the story.");
    System.out.println("\n");
    break;
    }
    //If the user enters an invalid option.
    else {
    System.out.println("Please enter a valid option.");
    }
    
    } while ((!"yes".equals(skip_story)) || (!"no".equals(skip_story)));
    
        //Display the title.
        title();
        
        do { //Do while loop that will ask the user which character they want to play as.
        //Player select screen. 
        System.out.println("Please select your player character. Input a number from 1 to 3.");
        System.out.println("1. Mario");
        System.out.println("2. Bowser");
        System.out.println("3. Luigi");
        user_choice = scanS.nextInt();
        
        //If statement for if the user enters an invalid option.
        if (user_choice != 1 || user_choice != 2 || user_choice !=3) {
        System.out.println("Please enter a valid option.");
        }
        } while (user_choice == 0 || user_choice >= 4 );
        
        //Scenario 1: Player has chosen Mario.
        if (user_choice == 1) {
        System.out.println("You have chosen Mario.");
        
        mario_HP = mario_HP + 50; //Set Mario's HP to 50.
        bowser_HP = bowser_HP + 100; //Set Bowser's HP to 100.
        
        //Provide the user information about Mario's moves.
        mario_info ();
        
        //Beggining the fight.
        beginning_fight();
        
        do { //Loop that stores both Mario and Bowser's turns.    
        //Display Mario's current HP and attack options.
        System.out.println("Turn " + turn_count); //Keeps track of number of turns.
        System.out.println("\n");
        System.out.println("Player Phase...");
        System.out.println("Mario has " + mario_HP + " HP left."); //Displays Mario's current HP.
        System.out.println("\n");    
        System.out.println("What will Mario do? Select from the following commands.");
        System.out.println("Input a number from 1 to 5.");
        System.out.println("1. Jump");
        System.out.println("2. Hammer");
        System.out.println("3. Fire Flower");
        System.out.println("4. Ice Flower");
        System.out.println("5. Mushroom");
        
        //Display amount of Fire flowers, Ice flowers and Mushrooms.
        System.out.println("Number of Fire flowers: " + fireflower_count);
        System.out.println("Number of Ice flower: " + iceflower_count);
        System.out.println("Number of Mushrooms: " + mushroom_count);
        mario_attack = scanS.nextInt(); //Prompt user for attack command.
    
        switch (mario_attack) { //Start of Switch 1.
        case 1: { //Case 1: Jump command was chosen.
        System.out.println("Mario leaped forward!");
        
        //Damage range of Jump command.
        jump = (int)(10+ Math.random()*(4)); 
        //Display amount of damamge dealt from the Jump.
        System.out.println("Mario dealed " + jump + " points of damage with his jump."); 
        //Subtract damage dealt from Bowser's current HP.
        bowser_HP = bowser_HP - jump; 
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        jump_reportcount++; //Increase number of Jumps used by 1.
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\n***********Mario*********");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 1.
        
        case 2: { //Case 2: Hammer command was chosen.
            
        System.out.println("Mario swung his mighty hammer!");
        hammer = (int)(9+ Math.random()*(4)); //Damage range of Hammer.
        //Display amount of damage dealt from the Hammer.
        System.out.println("Mario dealed " + hammer + " points of damage with his hammer."); 
        //Subtract damage dealt from Bowser's HP.
        bowser_HP = bowser_HP - hammer; 
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");   
        hammer_reportcount++; //Increase number of Hammer attacks used by 1.
        turn_count++; //Increase nmber of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 2.
        
        case 3: { //Case 3: Fire flower was chosen.
            
        //If statement that will bring the user to the enter command screen if they have no fire flowers left.    
        if (fireflower_count == 0) { 
        System.out.println("You are out of fire flowers.");
        continue;
        }
        
        System.out.println("Mario powered himself up with the fire flower!");
        fire_flower = (int)(15+ Math.random()*(5)); //Damage range of Fire flower.
        //Display amount of damage dealt from the Fire flower.
        System.out.println("Mario dealed " + fire_flower + " points of damage with the fire flower."); 
        fireflower_count --; //Decrease number of Fire flowers remaining by 1.
        //Subtract damage dealt from Bowser's HP.
        bowser_HP = bowser_HP - fire_flower; 
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        fireflower_reportcount++; //Increase number of Fire flowers used by 1.
        turn_count++; //Increase number of Turna passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 3.
        
        case 4: { //Case 4: Ice flower was chosen.
            
        //If statement that will take the user back to the command screen if they have no Ice flowers left.    
        if (iceflower_count == 0) {
        System.out.println("You are out of ice flowers.");
        continue;
        }
        
        System.out.println("Mario powered himself up with the ice flower.");
        ice_flower = (int)(15+ Math.random()*(3)); //Damage range of Ice flower.
        //Display amount of damage dealt with the Ice flower.
        System.out.println("Mario dealed " + ice_flower + " points of damage with the ice flower."); 
        //Display additional damage dealt.
        System.out.println("The ice flower dealed an extra 5 damage!"); 
        iceflower_count --; //Decrease number of Ice flowers remaining by 1.
        //Subtract damage dealt from Bowser's HP.
        bowser_HP = bowser_HP - ice_flower - 5; 
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left."); 
        iceflower_reportcount++; //Increase number of Fire flowers used by 1.
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 4.
        
        case 5: { //Case 5: Mushroom was chosen.
        // If statement that will send the user back to the command screen if they have no Mushrooms left.
        if (mushroom_count == 0) { 
        System.out.println("You are out of mushrooms.");
        continue;
        }
        
        System.out.println("Mario used a mushroom to recover 30 HP."); //Display amount of HP recovered.
        mario_HP = mario_HP + 30; //Increase Mario's HP by the amount recovered.
        mushroom_count --; //Decrease number of Mushrooms remaining by 1.
        //Display Mario's HP after he healed himself.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        mushroom_reportcount++; //Increase number of Mushrooms used by 1.
        turn_count++; //Increase number of Turns passed by 1.
        break;    
        } //End of Case 5.
        
        default: { //Default output if the user enters an invalid input.
        System.out.println("That is an invalid input. Please input a valid command.");
        continue;
        } //End of default output.
        } //End of switch.
        
        System.out.println("Turn " + turn_count); //Display total number of Turns passed.
        System.out.println("\n");
        System.out.println("Enemy Phase...");
        System.out.println("Now its my turn, Mario!");
        bowser_attack = (int)(1+ Math.random()*(5)); //Randomly generate Bowser's choice of attack.
    
        switch (bowser_attack) { //Start of Switch 2.
        case 1: { //Case 1: Punch was chosen.
            
        System.out.println("Bowser balled his hand into a fist and lunged it at Mario!");
        punch = (int)(8+ Math.random()*(3)); //Damage range of Punch.
        //Display amount of damage dealt from the Punch.
        System.out.println("Bowsered dealed " + punch + " damage with his punch."); 
        //Subtract damage dealt from Mario's current HP.
        mario_HP = mario_HP - punch; 
        //Increase total damage dealt to Mario by amount of damage dealt from the Punch.
        totaldamage_M = totaldamage_M + punch; 
        //Display Mario's HP after the damage he's taken.
        System.out.println("Mario has " + mario_HP + " HP left.");
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Mario's HP drops below 0.
        if (mario_HP <= 0) {
        //Print Bowser's first ending.    
        bowser_ending();
        
        //Print out Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 1.
        
        case 2: { //Case 2: Claw was chosen.
        System.out.println("Bowser moved forward and slashed at Mario with his claw!");
        claw = (int)(7+ Math.random()*(3)); //Damage range of Claw.
        //Display amount of damage dealt from the Claw.
        System.out.println("Bowser dealed " + claw + " points of damage with his claw."); 
        //Subtract amount of damage dealt from Mario's current HP.
        mario_HP = mario_HP - claw; 
        //Increase total damage dealt to Mario by amount of damage dealt from the Claw.
        totaldamage_M = totaldamage_M + claw; 
        //Display Mario's HP after the damage he's taken.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        turn_count++; //Increase number of turns that passed by 1.
        
        //If statement for if Mario's HP drops below 0.
        if (mario_HP <= 0) {
        //Print Bowser's first ending.    
        bowser_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 2.
        
        case 3: { //Case 3: Shell spin was chosen.
        System.out.println("Bowser jumped high and ground pounded Mario!");
        ground_pound = (int)(9+ Math.random()*(3)); //Damage range of Ground pound.
        //Display amount of damage dealt from the Ground pound.
        System.out.println("Bowser dealed " + ground_pound + " points of damage with his ground pound."); 
        //Subtract damage dealt from Mario's HP.
        mario_HP = mario_HP - ground_pound; 
        //Increase total damage dealt to Mario by amount of damage dealt from Ground pound.
        totaldamage_M = totaldamage_M + ground_pound; 
        //Display Mario's HP after the damage he's taken.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        turn_count++; //Increase number of turns that passed by 1.
        
        //If statement for if Mario's HP drops below 0.
        if (mario_HP <= 0) {
        //Print Bowser's first ending.    
        bowser_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 3. 
        
        case 4: { //Case 4: Shell spin was chosen.
        System.out.println("Bowser retracted into his shell and rammed into Mario!");
        shell_spin = (int)(10+ Math.random()*(2)); //Damage range of Shell spin.
        //Display amount of damage dealt from the Shell spin.
        System.out.println("Bowser dealed " + shell_spin + " points of damage with his shell spin."); 
        //Subtract damage dealt from Mario's current HP.
        mario_HP = mario_HP - shell_spin; 
        //Increase total damage dealt to Mario by amount of damage dealt from the Shell spin.
        totaldamage_M = totaldamage_M + shell_spin; 
        //Display Mario's HP after the damage he's taken.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        turn_count++; //Increase number of Turns that passed by 1.
        
        //If statement for if Mario's HP drops below 0.
        if (mario_HP <= 0) {
        //Print Bowser's first ending.
        bowser_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 4. 
        
        case 5: { // Case 5: Fire breath was chosen.
        System.out.println("Bowser opened his mouth and launched a breath of fire at Mario!"); 
        fire_breath = (int)(12+ Math.random()*(3)); //Damage range of Fire breath.
        //Display amount of damage dealt from Fire breath.
        System.out.println("Bowser dealed " + fire_breath + " points of damage with his fire breath."); 
        //Subtract damage dealt from Mario's current HP.
        mario_HP = mario_HP - fire_breath; 
        //Increase total damage dealt to Mario by amount of damage dealt from Fire breath.
        totaldamage_M = totaldamage_M + fire_breath; 
        //Display Mario's HP after the damage he's taken.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        turn_count++; //Increase number of turns passed by 1.
        
        //If statement for if Mario's HP drops below 0.
        if (mario_HP <= 0) {
        //Print Bowser's first ending.    
        bowser_ending();
        
        //Print Mario's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nMario");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_M);
        System.out.println("Number of Jumps used: " + jump_reportcount);
        System.out.println("Number of Hammer swings used: " + hammer_reportcount);
        System.out.println("Number of Fire flowers used: " + fireflower_reportcount);
        System.out.println("Number of Ice flower used: " + iceflower_reportcount);
        System.out.println("Number of Mushrooms used " + mushroom_reportcount);
        System.out.println("Thank you for playing.");
        return;
        }
        break;
        } //End of Case 5.    
        
        } //End of Switch 2.
        
        
        } while (bowser_HP >0); //End of Do-while loop 1.   
        } //End of Scenario 1.
        
        
        if (user_choice == 2) { //Start of Scenario 2.
        System.out.println("You have chosen Bowser.");
        //Set Bowser's HP to 80.
        bowser_HP = bowser_HP + 80;
        //Set Mario's HP to 120.
        mario_HP = mario_HP + 120; 
         
        //Display information about Bowser's attacks.
        bowser_info();
        
        //Beggining the fight.
        beginning_fight();
         
        do { //Start of Do-while loop 2.
        
        System.out.println("Turn " + turn_count); //Display number of Turns that passed.
        System.out.println("\n");
        System.out.println("Player Phase...");
        
        //Display Bowser's current HP and attack options.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        System.out.println("\n");    
        System.out.println("What will Bowser do? Select from the following commands.");
        System.out.println("Input a number from 1 to 8.");
        System.out.println("1. Punch");
        System.out.println("2. Fire breath");
        System.out.println("3. Goomba Storm");
        System.out.println("4. Shy Guy Squad");
        System.out.println("5. Koopa Corps");
        System.out.println("6. Bob-omb Blitz");
        System.out.println("7. Magikoopa Brigade");
        System.out.println("8. Drumstick");
        //Display amount of Drumsticks remaining.
        System.out.println("Number of Drumsticks: " + drumstick_count);
        bowser_attack = scanS.nextInt(); //Prompt user for attack command.    
        
        switch (bowser_attack) { //Start of Switch 3.
        
            case 1: { //Case 1: Punch was chosen.
            System.out.println("Take THIS!");
            System.out.println("Bowser balled his hand into a fist and lunged it at Mario!");
            punch = (int)(10+ Math.random()*(4)); //Damage range of Punch.
            //Display amount of damage dealt from the Punch.
            System.out.println("Bowser dealed " + punch + " points of damage with his punch.");
            //Subtract amount of damage dealt from Mario's HP.
            mario_HP = mario_HP - punch; 
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); 
            punch_reportcount++; //Increase number of punches uesed by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            //If statement for if Mario's HP drops below 0.
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
    
           //Print Bowser's Combat Report for the fight.
           System.out.println("Now printing Combat Report...");
           System.out.println("\n\n******COMBAT REPORT******");
           System.out.println("\n\nBowser");
           System.out.println("Number of turns passed: " + turn_count);
           System.out.println("Total damage taken " + totaldamage_B);
           System.out.println("Number of Punches thrown: " + punch_reportcount);
           System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
           System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
           System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
           System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
           System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
           System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
           System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
           return;
           }
           break;
           } //End of Case 1.
            
            case 2: { //Case 2: Fire breath was chosen.
            System.out.println("Feeling a little cold? Don't worry...THIS will help!");
            System.out.println("Bowser opened his mouth and launched a breath of fire at Mario!");
            fire_breath = (int)(9+ Math.random()*(4)); //Damage range of Fire breath.
            //Display amount of damage dealt from the Fire breath.
            System.out.println("Bowser dealed " + fire_breath + " points of damage with his fire breath.");
            //Subtract amount of damage dealt from Mario's HP.
            mario_HP = mario_HP - fire_breath; 
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); //
            firebreath_reportcount++; //Increase number of fire breaths used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
           //Print Bowser's Combat Report for the fight.
           System.out.println("Now printing Combat Report...");
           System.out.println("\n\n******COMBAT REPORT******");
           System.out.println("\n\nBowser");
           System.out.println("Number of turns passed: " + turn_count);
           System.out.println("Total damage taken " + totaldamage_B);
           System.out.println("Number of Punches thrown: " + punch_reportcount);
           System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
           System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
           System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
           System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
           System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
           System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
           System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break;
            } //End of Case 2.
            
            case 3: { //Case 3: Goomba storm was chosen.
                
            //If statement for if the user has no Goomba storms remaining.    
            if (goombastorm_count == 0) {
            System.out.println("Crud..the Shy Guys are exhausted. I better try something else.");
            continue;
            }
            
            System.out.println("Goombas, attack!");
            System.out.println("Bowser ordered his Goombas to charge at Mario!");
            System.out.println("Bowser set each of his Goombas on fire causing"
            + " them to jump high into the sky and crash down on Mario one after the other!");
            goomba_storm = (int)(20+ Math.random()*(3)); //Damage range of Goomba storm.
            goombastorm_count--; //Decrease number of Goomba storms remaining by 1.
            //Display amount of damage dealt from Goomba storm.
            System.out.println("Bowser dealed " + goomba_storm + " points of damage with his Goombas."); 
            //Subtract amount of damage dealt from Mario's HP.
            mario_HP = mario_HP - goomba_storm; 
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); 
            goombastorm_reportcount++; //Increase number of Goomba storms used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
            //Print Bowser's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nBowser");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken " + totaldamage_B);
            System.out.println("Number of Punches thrown: " + punch_reportcount);
            System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
            System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
            System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
            System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
            System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
            System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
            System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break;
            } //End of Case 3.
            
            case 4: { //Case 4: Shy Guy squad was chosen.
                
            //If statement for if the user has no Shy Guy squads remaining.
            if (shyguysquad_count == 0) {
            System.out.println("Crud..the Shy Guys are exhausted. I better try something else.");
            continue;
            }
            
            System.out.println("Shy guys, prepare for battle!");
            System.out.println("Bowsered ordered his Shy Guys to roll him as far back as possible!");
            System.out.println("Bowser then rolled into Mario with tremendous speed!");
            shyguy_squad = (int)(18+ Math.random()*(6)); //Damage range of Shy Guy squad.
            shyguysquad_count--; //Decrease number of Shy Guy squads remaining by 1.
            //Display amount of damage dealt from Shy Guy squad. 
            System.out.println("Bowser dealed " + shyguy_squad + " points of damage with his Shy Guys.");
            //Subtract amount of damage dealt from Mario's current HP.
            mario_HP = mario_HP - shyguy_squad; 
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); 
            shyguysquad_reportcount++; //Increase number of Shy Guy squads used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
            //Print Bowser's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nBowser");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken " + totaldamage_B);
            System.out.println("Number of Punches thrown: " + punch_reportcount);
            System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
            System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
            System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
            System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
            System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
            System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
            System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break;
            } //End of Case 5.
            
            case 5: { //Case 5: Koopa corps was chosen.
                
            //If statement for if the user has no Koopa corps remaining.    
            if (koopacorps_count == 0) {
            System.out.println("Crud..the Koopas are exhausted. I better try something else.");
            continue;
            }   
            
            System.out.println("Koopas, front and center!");
            System.out.println("Bowser retracted into his shell and knocked the Koopas into Mario!");
            koopa_corps = (int)(18+ Math.random()*(1)); //Damage range of Koopa corps.
            koopacorps_count--; //Decrease number of Koopa corps remaining by 1.
            //Display amount of damage dealt from Koopa corps.
            System.out.println("Bowser dealed " + koopa_corps + " points of damage with his Koopas."); 
            //Subtract amount of damage dealt from Mario's current HP.
            mario_HP = mario_HP - koopa_corps; 
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); 
            koopacorps_reportcount++; //Increase number of Koopa corps used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
            //Print Bowser's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nBowser");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken " + totaldamage_B);
            System.out.println("Number of Punches thrown: " + punch_reportcount);
            System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
            System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
            System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
            System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
            System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
            System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
            System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break;
            } //End of Case 5.
            
            case 6: { //Case 6: Bob-omb blitz was chosen.
            //If statement for if the user has no Bob-omb Blitz's remaining.    
            if (bobombblitz_count == 0) {
            System.out.println("Crud..no more Bob-ombs left. I better try something else.");
            continue;
            }
            
            System.out.println("Bob-ombs, engage the enemy!");
            System.out.println("Bowser alligned the Bob-ombs carefully before having them explode into Mario!");
            bobomb_blitz = (int)(18+ Math.random()*(8)); //Damage range of Bob-omb Blitz.
            bobombblitz_count--; //Decrease number of Bob-omb Blitz's remaining by 1.
            System.out.println("Bowser dealed " + bobomb_blitz + " points of damage with his Bob-ombs."); //Display amount of damage dealt.
            mario_HP = mario_HP - bobomb_blitz; //Subtract amount of damage dealt from Mario's current HP.
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left.");
            bobombblitz_reportcount++; //Increase number of Koopa corps used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
            //Print Bowser's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nBowser");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken " + totaldamage_B);
            System.out.println("Number of Punches thrown: " + punch_reportcount);
            System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
            System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
            System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
            System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
            System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
            System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
            System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break; 
            } //End of Case 6.
            
            case 7: { //Case 7: Magikoopa brigade was chosen.
                
            //If statement for if the user has no Magikoopa Brigades remaining.    
            if (magikoopabrigade_count == 0) {
            System.out.println("Crud..the Magikoopas are out of magic. I better try something else.");
            continue;
            }
            
            System.out.println("Magikoopas, raise your wands!");
            System.out.println("Bowser ordered the Magikoopas to release a powerful magic attack at Mario!");
            magikoopa_brigade = (int)(18+ Math.random()*(12)); //Damage range of Magikoopa Brigade.
            magikoopabrigade_count--; //Decrease number of Magikoopa Brigades remaining by 1.
            System.out.println("Bowser dealed " + magikoopa_brigade + " points of damage with his Magikoopas."); //Display amount of damage dealt.
            mario_HP = mario_HP - magikoopa_brigade; //Subtract amount of damage dealt from Mario's HP.
            //Display Mario's HP after the damage he's taken.
            System.out.println("Mario has " + mario_HP + " HP left."); 
            magikoopabrigade_reportcount++; //Increase number of Magikoopa Brigades used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            if (mario_HP <= 0) {
            //Print Bowser's first ending.    
            bowser_ending();
        
            //Print Bowser's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nBowser");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken " + totaldamage_B);
            System.out.println("Number of Punches thrown: " + punch_reportcount);
            System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
            System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
            System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
            System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
            System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
            System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
            System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
            return;
            }
            break;
            } //End of Case 7.
            
            case 8: { //Case 8: Drumstick was chosen.
            //If statement for if the user has no Drumsticks remaining.    
            if (drumstick_count == 0) {
            System.out.println("...No more Drumsticks...");
            continue;
            }    
            
            System.out.println("Bowser ate a drumstick to recover 40 HP."); //Display amount of HP Bowser recovered.
            bowser_HP = bowser_HP + 40; //Add amount of recovered HP to Bowser's current HP.
            drumstick_count--; //Decrease number of Drumsticks remaining.
            //Display Bowser's HP after he healed himself.
            System.out.println("Bowser has " + bowser_HP + " HP left."); 
            drumstick_reportcount++; //Increase number of Drumsticks used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            break;
            } //End of Case 8.
            
            default: { //Default case if the user has entered an invalid input.
            System.out.println("You have entered an invalid input. Please try again.");
            continue;
            } //End of Default case.
            } //End of Switch 3.
        
        System.out.println("Turn " + turn_count); //Display number of Turns passed.
        System.out.println("Enemy Phase...");
        mario_attack = (int)(1+ Math.random()*(8)); //Randomly generate Mario's choice of attack.
        
        switch (mario_attack) { //Start of Switch 4.
        case 1: { //Case 1: Jump was chosen
        System.out.println("Mario leaped forward!");
        jump = (int)(10+ Math.random()*(4)); //Damage range of Jump.
        System.out.println("Mario dealed " + jump + " points of damage with his jump."); //Display amount of damage dealt from Jump attack.
        bowser_HP = bowser_HP - jump; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + jump; //Increase total damage dealt to Bowser by amount of damage dealt from Jump. 
        
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left."); 
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 1.
        
        case 2: { //Case 2: Hammer was chosen.
        System.out.println("Mario swung his mighty hammer!");
        hammer = (int)(9+ Math.random()*(4)); //Damage range of Hammer attack.
        System.out.println("Mario dealed " + hammer + " points of damage with his hammer."); //Display amount of damage dealt from Hammer attack.
        bowser_HP = bowser_HP - hammer; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + hammer; //Increase total damage dealt to Bowser by amount of damage dealt from Hammer attack.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");  
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.
        mario_ending();
        
        //Print Bowser's Combat Report.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 2.
        
        case 3: { //Case 3: Fire flower was chosen.   
        System.out.println("Mario powered himself up with the fire flower!");
        fire_flower = (int)(15+ Math.random()*(5)); //Damage range of Fire flower.
        System.out.println("Mario dealed " + fire_flower + " points of damage with the fire flower."); //Display amount of damage dealt from Fire flower.
        bowser_HP = bowser_HP - fire_flower; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + fire_flower; //Increase total amount of damage dealt to Bowser by amount of damage taken from Fire flower.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 3.
        
        case 4: { //Case 4: Ice flower was chosen.
        System.out.println("Mario powered himself up with the ice flower.");
        ice_flower = (int)(16+ Math.random()*(3)); //Damage range of Ice flower.
        System.out.println("Mario dealed " + ice_flower + " points of damage with the ice flower."); //Display amount of damage dealt from Ice flower.
        System.out.println("The ice flower dealed an extra 5 damage!"); //Display critical damage dealt.
        bowser_HP = bowser_HP - ice_flower - 5; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + ice_flower + 5; //Increaee total amount of damage dealt to Bowser by amount of damage dealt from Ice flower.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left."); 
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 4.
        
        case 5: { //Case 5: Mushroom was chosen.   
        System.out.println("Mario used a mushroom to recover 30 HP."); //Display amount of HP recovered from Mushroom.
        mario_HP = mario_HP + 30; //Add amount of HP recovered to Mario's current HP.
        //Display Mario's HP after he healed himself.
        System.out.println("Mario has " + mario_HP + " HP left."); 
        turn_count++; //Increase number of Turns that passed by 1.
        break;    
        } //End of Case 5.
        
        case 6: { //Case 6: Mega mushroom was chosen.
        System.out.println("Mario used a mega mushroom to turn giant and stomp Bowser!");
        mega_mushroom = (int)(20+ Math.random()*(6)); //Damage range of Mega Mushroom.
        System.out.println("Mario dealed " + mega_mushroom + " points of damage with the mega mushroom."); //Display amount of damage dealt from Mega Mushroom.
        bowser_HP = bowser_HP - mega_mushroom; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + mega_mushroom; //Increase total amount of damage dealt to Bowser by amount of damage dealt from Mega mushroom.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        turn_count++; //Increase number of Turns that passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 6.
        
        case 7: { //Case 7: Copy flower was chosen.
        System.out.println("Mario used the copy flower to clone himself!");
        System.out.println("The clones all attacked Bowser with powerful jumps!");
        copy_flower = (int)(18+ Math.random()*(6)); //Damage range of Copy flower.
        System.out.println("Mario dealed " + copy_flower + " points of damage with the copy flowers."); //Display amount of damage dealt from Copy flower.
        bowser_HP = bowser_HP - copy_flower; //Subtract amount of damage dealt from Bowser's current HP.
        totaldamage_B = totaldamage_B + copy_flower; //Increase total amount of damage dealt to Bowser by amount of damage dealt from Copy flower.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left."); 
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Print Mario's ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 7.
        
        case 8: { //Case 8: Boomerang flower was chosen.
        System.out.println("Mario used the boomerang flower and fired boomerangs at Bowser!");
        boomerang_flower = (int)(17+ Math.random()*(6)); //Damage range of Boomerang flower.
        System.out.println("Mario dealed " + boomerang_flower + " points of damage with the boomerang flower."); //Display amount of damage dealt from Boomerang flower.
        mario_HP = mario_HP - boomerang_flower; //Subtract amount of damage dealt from Mario's current HP.
        totaldamage_B = totaldamage_B + boomerang_flower; //Increase total amount of damage dealt to Bowser by amount of damage dealt from Boomeranf flower.
        //Display Bowser's HP after the damage he's taken.
        System.out.println("Bowser has " + bowser_HP + " HP left.");
        turn_count++; //Increase number of Turns passed by 1.
        
        //If statement for if Bowser's HP drops below 0.
        if (bowser_HP <= 0) {
        //Mario ending.    
        mario_ending();
        
        //Print Bowser's Combat Report for the fight.
        System.out.println("Now printing Combat Report...");
        System.out.println("\n\n******COMBAT REPORT******");
        System.out.println("\n\nBowser");
        System.out.println("Number of turns passed: " + turn_count);
        System.out.println("Total damage taken: " + totaldamage_B);
        System.out.println("Number of Punches thrown: " + punch_reportcount);
        System.out.println("Number of Fire breaths used: " + firebreath_reportcount);
        System.out.println("Number of Goomba storms used: " + goombastorm_reportcount);
        System.out.println("Number of Shy Guy squads used: " + shyguysquad_reportcount);
        System.out.println("Number of Koopa Corps used: " + koopacorps_reportcount);
        System.out.println("Number of Bob-omb Blitz's used: " + bobombblitz_reportcount);
        System.out.println("Number of Magikoopa Brigades used: " + magikoopabrigade_reportcount);
        System.out.println("Number of Drumsticks eaten " + drumstick_reportcount);
        return;
        }
        break;
        } //End of Case 8.
        
        } //End of Switch 4.
      
        } while (mario_HP >0); //End of Do-while loop 2. 
        
        } //End of Scenario 2.
        
        if (user_choice == 3) { //Start of Scenario 3.
        System.out.println("You have chosen Luigi.");
        luigi_HP = luigi_HP + 70; //Set Luigi's HP to 70.
        bowser_HP = bowser_HP + 100; //Set Bowser's HP to 100.
        System.out.println("\n");
        
        //Display information about Luigi's attacks.
        luigi_info();
      
        //Beggining the fight.
        beginning_fighttwo();
        
        do { //Start of Do-while loop 3.   
        //Display Luigi's current HP and attack options.
        System.out.println("Turn " + turn_count); //Display number of Turns that passec by 1.
        System.out.println("\n");
        System.out.println("Player Phase...");
        System.out.println("Luigi has " + luigi_HP + " HP left."); //Display Luigi's current HP.
        System.out.println("\n");    
        System.out.println("What will Luigi do? Select from the following commands.");
        System.out.println("Input a number from 1 to 5.");
        System.out.println("1. Thunder");
        System.out.println("2. Green Missle");
        System.out.println("3. Cape Feather");
        System.out.println("4. Tanooki Suit");
        System.out.println("5. Blue Shell");
        luigi_attack = scanS.nextInt(); //Prompt user.
        
        switch (luigi_attack) { //Start of Switch 5.
            case 1: { //Case 1: Thunder was chosen.
            System.out.println("Luigi launched a bolt of lightning at Bowser!");
            thunder = (int)(16+ Math.random()*(8)); //Damage range of Thunder.
            System.out.println("Luigi dealed " + thunder + " points of damage with his thunder attack."); //Display amount of damage dealt from Thunder.
            bowser_HP = bowser_HP - thunder; //Subtract amount of damage dealt from Bowser's current HP.
            //Display Bowser's HP after the damage he's taken.
            System.out.println("Bowser has " + bowser_HP + " HP left.");
            thunder_reportcount++; //Increase amount of Thunder attacks used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 1.
            
            case 2: { //Case 2: Green missle was chosen.
            System.out.println("Luigi gathered energy and launched himselt at Bowser!");
            greenmissle = (int)(19+ Math.random()*(3)); //Damage range of Green missle.
            System.out.println("Luigi dealed " + greenmissle + " points of damage with his green missle attack."); //Displau amount of damage dealt from Green missle.
            bowser_HP = bowser_HP - greenmissle; //Subtract amount of damage dealt from Bowser's current HP.
            //Display Bowser's HP after the damage he's taken.
            System.out.println("Bowser has " + bowser_HP + " HP left.");
            greenmissle_reportcount++; //Increase number of Green missles used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 2.
            
            case 3: { //Case 3: Cape feather was chosen.
            //If statement for if user has no cape feathers remaining.    
            if (capefeather_count == 0) {
            System.out.println("You have no cape feathers remaining. Please select a different attack.");
            continue;
            }    
            System.out.println("Luigi used the cape feather and striked Bowser with tremendous power!");
            capefeather = (int)(20+ Math.random()*(6)); //Damage range of Cape feather.
            System.out.println("Luigi dealed " + capefeather + " points of damage with the cape feather."); //Display amount of damage dealt from Cape feather.
            bowser_HP = bowser_HP - capefeather; //Subtract amount of damage dealt from Bowser's current HP.
            //Display Bowser's HP after the damage he's taken.
            System.out.println("Bowser has " + bowser_HP + " HP left.");
            capefeather_count--; //Decrease number of cape feathers remaining by 1.
            capefeather_reportcount++; //Increase number of cape feathers used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 3.
            
            case 4: { //Case 4: Tanooki suit was chosen.
            //If statement for if user has no tanooki suits remaining.    
            if (tanookisuit_count == 0) {
            System.out.println("You have no Tanooki suits remaining. Please select a different attack.");
            continue;
            }    
            System.out.println("Luigi transformed into a Kitsune with the tanooki suit and attacked Bowser at a blinding speed!");
            tanookisuit = (int)(17+ Math.random()*(10)); //Damage range of Tanooki suit.
            System.out.println("Luigi dealed " + tanookisuit + " points of damage with the tanooki suit."); //Display amount of damage dealt from Tanooki suit.
            bowser_HP = bowser_HP - tanookisuit; //Subtract amount of damage dealt from Bowser's current HP.
            //Display Bowser's HP after the damage he's taken.
            System.out.println("Bowser has " + bowser_HP + " HP left."); 
            tanookisuit_count--; //Decreaae number of Tanooki suits remaining by 1.
            tanookisuit_reportcount++; //Increase number of Tanooki suits used by 1.
            turn_count++; //Increase number of Turns passed by 1.
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 4.
            
            case 5: { //Case 5: Blue shell was chosen.
                
            //If statement for if the user has no Blue shells remaining.  
            if (blueshell_count == 0) {
            System.out.println("You have no Blue shells remaining. Please select a different attack.");
            continue;
            }
            
            System.out.println("Luigi used the blue shell and rammed into Bowser!");
            System.out.println("Luigi's defense was strengthened! From now on, Luigi will take less damage from Bowser's attacks!");
            blueshell = (int)(12+ Math.random()*(8)); //Damage range of Blue shell.
            System.out.println("Luigi dealed " + blueshell + " points of damage with the blue shell."); //Display amount of damage dealt from Blue shell.
            bowser_HP = bowser_HP - blueshell; //Subtract amount of damage dealt from Bowser's HP.
            //Display Bowser's HP after the damage he's taken.
            System.out.println("Bowser has " + bowser_HP + " HP left.");
            blueshell_count--; //Decrease number of Blue shells remaining by 1.
            blueshell_reportcount++; //Increase number of Blue shells used by 1.
            turn_count++; //Increase number of Turns that have passed by 1.
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 5.
            
            } //End of Switch 5.
        
            System.out.println("Turn " + turn_count); //Display number of Turns that have passed.
            System.out.println("Enemy phase...");
            System.out.println("Here I come, Green 'Stache!");
            bowser_attack = (int)(1+ Math.random()*(5)); //Randomly generate Bowser's choice of attack.
        
            switch (bowser_attack) { //Start of Switch 6.
            case 1: { //Case 1: Shell cannon was chosen.
            System.out.println("Bowser fired spikes from his shell!");
            shell_cannon = (int)(19+ Math.random()*(4)); //Damage range of Shell cannon.
            weakened_shellcannon = (int)(19+ Math.random()*(4) - 7); //Damage range of weakened Shell cannon.
            
            //Increase number of turns that passed by 1.
            turn_count++; 
            
            //If statement for if the user has used the Blue shell and boosted their defense.
            if (blueshell_count == 0) {
            System.out.println("Bowser dealed " + weakened_shellcannon + " points of damage with his shell cannon."); //Display amount of damage dealt from Shell cannon.
            System.out.println("Luigi took 7 less damage because of the blue shell boost!");
            luigi_HP = luigi_HP - weakened_shellcannon; //Subtract amount of damage dealt from Luigi's HP.
            totaldamage_L = totaldamage_L + weakened_shellcannon; //Increase total amount of damage dealt to Luigi by amount of damage dealt from Shell cannon.
            }
            
            //Else statement for if the user has not used the Blue shell.
            else {
            System.out.println("Bowser dealed " + shell_cannon + " points of damage with his shell cannon.");
            luigi_HP = luigi_HP - shell_cannon;
            totaldamage_L = totaldamage_L - shell_cannon;
            }
            
            //Display Luigi's HP after the damage he's taken.
            System.out.println("Luigi has " + luigi_HP + " HP left.");
            //If statement for if Luigi's HP drops below 0.
            if (luigi_HP < 0) {
            //Print Bowser's 2nd ending.    
            bowser_endingtwo();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("\n");
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 1.
            
            case 2: { //Case 2: Flying slam was chosen.
            System.out.println("Bowser grabbed Luigi and jumped high up before body slamming him!");
            flying_slam = (int)(16+ Math.random()*(10)); //Damage range of Flying slam.
            weakened_flyingslam = (int)(16+ Math.random()*(10) - 7); //Damage range of weakened Flying slam.
            
            //Increase number of turns that passed by 1.
            turn_count++; 
            
            //If statement for if the user has used the Blue shell and gained the defense boost.
            if (blueshell_count == 0) { 
            System.out.println("Bowser dealed " + weakened_flyingslam + " points of damage with his flying slam."); //Display amount of damage dealt from the flying slam. 
            System.out.println("Luigi took 7 less damage because of the blue shell boost!");
            luigi_HP = luigi_HP - weakened_flyingslam; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + weakened_flyingslam; //Increase total amount of damage dealt to Luigi by amount of damage dealt from the Flying slam.
            }
            
            //Else statement for if the user has not used the Blue shell.
            else {
            System.out.println("Bowser dealed " + flying_slam + " points of damage with his flying slam."); //Display amount of damage dealt from the Flying slam.
            luigi_HP = luigi_HP - flying_slam; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + flying_slam; //Increase total amount of damage dealt to Luigi by amount of damage dealt from the Flying slam.
            }
            
            //Display Luigi's HP after the damage he's taken.
            System.out.println("Luigi has " + luigi_HP + " HP left.");
            
            //If statement for if Luigi's HP drops below 0.
            if (luigi_HP < 0) {
            //Print Bowser's 2nd ending.    
            bowser_endingtwo();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 2.
            
            case 3: { //Case 3: Meteor rain was chosen.
            System.out.println("Bowser launched a breath of fire at Luigi!");
            System.out.println("Luigi managed to deflect it dealing 10 damage!");
            bowser_HP = bowser_HP - 10; //Subtract counter damage from Bowser's current HP.
            //Increase number of turns that passed by 1.
            turn_count++; 
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending.    
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            
            System.out.println("Bowser retracted into his shell and launched himself at the sky as fire surrounded his shell!");
            System.out.println("Fire started to rain from the sky hitting Luigi!");
            meteor_rain = (int)(20+ Math.random()*(8)); //Damage range of Meteor rain.
            weakened_meteorrain = (int)(20+ Math.random()*(8) - 7); //Damage range of weakened Meteor rain.
            
            //If statement for if user has used Blue shell and received the defense boost.
            if (blueshell_count == 0) { 
            System.out.println("Bowser dealed " + weakened_meteorrain + " points of damage with his meteor rain."); //Display amount of damage dealt from Meteor rain.
            System.out.println("Luigi took 7 less damage because of the blue shell boost!");
            luigi_HP = luigi_HP - weakened_meteorrain; //Subtract total amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + weakened_meteorrain; //Increase total amount of damage dealt to Luigi by amount of damage dealt from Meteor rain.
            }
            
            //Else statement for if user has not used Blue shell.
            else {
            System.out.println("Bowser dealed " + meteor_rain + " points of damage with his meteor rain."); //Display amount of damage dealt from Meteor rain.
            luigi_HP = luigi_HP - meteor_rain; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + meteor_rain; //Increase total amount of damage dealt to Luigi by amount of damage dealt from Meteor rain.
            }
            
            //Display Luigi's HP after the damage he's taken.
            System.out.println("Luigi has " + luigi_HP + " HP left.");
            
            //If statement for if Luigi's HP drops below 0.
            if (luigi_HP < 0) {
            //Print Bowser's 2nd ending.    
            bowser_endingtwo();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 3.
            
            case 4: { //Case 4: Hammer throw was chosen.
            System.out.println("Bowser began throwing hammers at Luigi!");
            hammer_throw = (int)(17+ Math.random()*(10)); //Damage range of Hammer throw.
            weakened_hammerthrow = (int)(17+ Math.random()*(10) - 7); //Damage range of weakened Hammer Throw.
            
            //Increase number of turns that passed by 1.
            turn_count++; 
            
            //If statement for if user has used the Blue shell and received the defense boost.
            if (blueshell_count == 0) { 
            System.out.println("Bowser dealed " + weakened_hammerthrow + " points of damage with his hammers."); //Display amount of damage dealt from Hammer throw.
            System.out.println("Luigi took 7 less damage because of the blue shell boost!");
            luigi_HP = luigi_HP - weakened_hammerthrow; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + weakened_hammerthrow; //Increase total amount of damage dealt to Luigi by amount of damage taken from the Hammer throw.
            }
            
            //Else statement for if user has not used the Blue shell.
            else {
            System.out.println("Bowser dealed " + hammer_throw + " points of damage with his hammers."); //Display amount of damage dealt from Hammer throe.
            luigi_HP = luigi_HP - hammer_throw; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + hammer_throw; //Increase total amount of damage dealt to Luigi by amount of damage dealt from the Hammer throw.
            }
            
            //Display Luigi's HP after the damage he's taken.
            System.out.println("Luigi has " + luigi_HP + " HP left.");
            
            //If statement for if Luigi's HP drops below 0.
            if (luigi_HP < 0) {
            //Print Bowser's 2nd ending.    
            bowser_endingtwo();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 4.
            
            case 5: { //Case 5: Mechakoopa mayhem was chosen.
            System.out.println("Mechakoopas, charge!");
            System.out.println("Luigi managed to knock a few Mechakoopas back dealing 5 damage!");
            bowser_HP = bowser_HP - 5; //Subtract counter attack damage from Bowser's current HP.
            //Increase number of turns that passed by 1.
            turn_count++; 
            
            //If statement for if Bowser's HP drops below 0.
            if (bowser_HP < 0) {
            //Print Luigi's ending. 
            luigi_ending();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            
            System.out.println("The Mechakoopas all tackled Luigi!");
            mechakoopa_mayhem = (int)(19+ Math.random()*(6)); //Damage range of Mechakoopa Mayhem.
            weakened_mechakoopamayhem = (int)(19+ Math.random()*(6) - 7); //Damage range of weakened Mechakoopa Mayhem.
            
            //If statement for if user has used the Blue shell and received the defense boost.
            if (blueshell_count == 0) {
            System.out.println("Bowser dealed " + weakened_mechakoopamayhem + " points of damage with his mechakoopas."); //Display amount of damage from Mechakoopa mayhem.
            System.out.println("Luigi took 7 less damage because of the blue shell boost!");
            luigi_HP = luigi_HP - weakened_mechakoopamayhem; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + weakened_mechakoopamayhem; //Increase total amount of damage dealt to Luigi by amount of damage dealt from Mechakoopa mayhem.
            }
            
            //Else statement for if user has not used the Blue shell.
            else {
            System.out.println("Bowser dealed " + mechakoopa_mayhem + " points of damage with his mechakoopas."); //Display amount of damage dealt from Mechakoopa mayhem.
            luigi_HP = luigi_HP - mechakoopa_mayhem; //Subtract amount of damage dealt from Luigi's current HP.
            totaldamage_L = totaldamage_L + mechakoopa_mayhem; //Increase total amount of damage dealt to Luigi by amount of damage dealt from Mechakoopa mayhem.
            }
            
            //Display Luigi's HP after the damage he's taken.
            System.out.println("Luigi has " + luigi_HP + " HP left.");
            
            //If statement for if Luigi's HP drops below 0.
            if (luigi_HP < 0) {   
            //Print Bowser's 2nd ending.    
            bowser_endingtwo();
            
            //Print Luigi's Combat Report for the fight.
            System.out.println("Now printing Combat Report...");
            System.out.println("\n\n******COMBAT REPORT******");
            System.out.println("\n\nLuigi");
            System.out.println("Number of turns passed: " + turn_count);
            System.out.println("Total damage taken: " + totaldamage_L);
            System.out.println("Number of Thunder attacks used: " + thunder_reportcount);
            System.out.println("Number of Green missles used: " + greenmissle_reportcount);
            System.out.println("Number of Cape feather used: " + capefeather_reportcount);
            System.out.println("Number of Tanooki suits used: " + tanookisuit_reportcount);
            System.out.println("Number of Blue shells used: " + blueshell_reportcount);
            System.out.println("\n");
            System.out.println("Thank you for playing.");
            return;
            }
            break;
            } //End of Case 5.
            
        } //End of Switch 6.
        } while (bowser_HP > 0); //End of Do-while loop 3.   
        } //End of Scenario 3.
        
    } //End of Main Method.

    public static void story () {
    //Story will be displayed in the main method.    
    System.out.println("Beginning story...");
    System.out.println("\n");
    System.out.println("Once upon a time in the Mushroom Kingdom,");
    System.out.println("There lived a princess named Peach.");
    System.out.println("One day, the Koopa King known as Bowser arrived at her highnesses' palace and kidnapped her.");
    System.out.println("With the princess now a hostage,");
    System.out.println("Bowser was ready to rule over the entire Mushroom Kingdom with an iron fist.");
    System.out.println("The Mushroom Kingdom only has a single hope left...");
    System.out.println("That hope came in the form of a champion...");
    System.out.println("His name...is Mario.");
    System.out.println("Ending story...");
    System.out.println("\n");
    }

    public static void title () {
    //Title screen will be displayed in the main method.    
    System.out.println("\t▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽");
    System.out.println("\t⧐⧐⧐⧐MARIO AND LUIGI RPG!⧐⧐⧐⧐⧐");
    System.out.println("\t△△△△△△△△△△△△△△△△△△△"); 
    System.out.println("\n");
    }

    public static void beginning_fight () {
    //Beggining the fight.
    System.out.println("At Bowser Castle...");
    System.out.println("\n");
    System.out.println("BWAHAHAHA! So you're the one I've heard so much about.");
    System.out.println("Mario was it? Welcome to my castle.");
    System.out.println("But I'm afraid you've come here without permission.");
    System.out.println("Coming all the way here all for the sake of a princess.");
    System.out.println("I'm afraid I'm going to have to teach you some manners.");
    System.out.println("Come Mario! Because It's....");
    System.out.println("SHOWTIME!");
    System.out.println("\n");    
    }
    
    public static void beginning_fighttwo () {
    System.out.println("At Bowser Castle...");
    System.out.println("\n");
    System.out.println("BWAHAHAHA! So the green stache has finally come out of hiding.");
    System.out.println("Luigi was it? Welcome to my castle.");
    System.out.println("Can you hear that? That sounda like your brother screaming for help.");
    System.out.println("Coming all the way here...just to be defeated by me. What a shame.");
    System.out.println("But don't worry. Once I'm"
    + " through with you, I'll make sure your brother follows you to the afterlife!");
    System.out.println("Come Green 'Stache! Because It's....");
    System.out.println("SHOWTIME!");
    System.out.println("\n");    
    }

    public static void mario_info () {
    //Display information about Mario's attacks.    
    System.out.println("Mario has 5 moves at his disposal.");
    System.out.println("The first is his Jump attack where he stomps his foe.");
    System.out.println("The second is his Hammer attack where he strikes his foe with a mallet.");
    System.out.println("The third is his fire flower power-up. With it, Mario can unleash a ball of fire at the foe.");
    System.out.println("The fourth is his ice flower power-up. With it, Mario can unlease a ball of ice at the foe.");
    System.out.println("Last but not least, Mario has Mushrooms at his disposal which he can use to restore his HP.");
    System.out.println("Be warned. Mario only has 2 of both fire and ice flowers and only 4 mushrooms at his disposal.");
    System.out.println("Once he runs out of them, he will be unable to use them for the remainder of the battle.");
    System.out.println("Use these skills to put a stop to Bowser's evil scheme. For the sake of the Mushroom Kingdom.");
    System.out.println("Good luck, Mario!");    
    }
    
    public static void bowser_info () {
    //Display information about Bowser's attacks.
    System.out.println("Bowser has 8 moves at his disposal.");
    System.out.println("The first is his Punch attack where he lunges a fist at his foe.");
    System.out.println("The second is his Fire breath attack where he strikes his foe with a breath of fire.");
    System.out.println("The third is the Goomba Storm. Where he sets his Goombas on fire and causes them to rain down upon the foe.");
    System.out.println("The fourth is the Shy Guy Squad. Where the Shy Guys roll Bowser's shell as far back as they can before he rams into the foe.");
    System.out.println("The fifth is the Koopa Corps. Where he causes his Koopas to tackle into the foe by hitting them with his shell.");
    System.out.println("The sixth is the Bob-omb Blitz. Where he alligns six Bob-ombs where the foe is before causing them to explode upon contact.");
    System.out.println("The seventh is the Magikoopa Brigade. Where he orders his Magikoopas to fire a ball of magic at the foe.");
    System.out.println("Last but not least, Bowser can eat Drumsticks to restore 40 HP.");
    System.out.println("Be warned. Bowser can only use each of his minions' attack once per battle. He only has 3 Drumsticks at his disposal.");
    System.out.println("Once he runs out of them, he will be unable to use them for the remainder of the battle.");
    System.out.println("Use these skills to put a stop to Mario so you can rule with an iron fist.");
    System.out.println("Crush them, Bowser!");    
    }
    
    public static void luigi_info () {
    //Display information about Luigi's attacks.
    System.out.println("Luigi has 5 moves at his disposal.");
    System.out.println("The first is his Thunder attack where he launches a bolt of lightning at the foe.");
    System.out.println("The second is his Green missle attack where he"
    + " charges energy inside himself and launches himself at the foe like a missle.");
    System.out.println("The third is his Cape feather power-up. With it, Luigi can strike his foe with immense power.");
    System.out.println("The fourth is his Tanooki suit power-up. With it, Luigi"
    + " can take on the form of a kitsune and strike the foe at a shocking speed.");
    System.out.println("Last but not least, Luigi has a Blue shell which he uses to ram into his foe."
    + " The blue shell also increases his defense for the remainder of the fight.");
    System.out.println("Be warned. Luigi only has 1 Cape feather, Tanooki suit and Blue shell at his disposal.");
    System.out.println("Once he runs out of them, he will be unable to use them for the remainder of the battle.");
    System.out.println("While he has more health than Mario, he isn't as good at taking attacks.");
    System.out.println("Use these skills to put a stop to Bowser's evil scheme. For the sake of the Mushroom Kingdom.");
    System.out.println("Good luck, Luigi! Succeed where Mario failed!");    
    }
    
    public static int weakened_shellcannon () {
    //Damage of Shell Cannon if the blue shell defense boost is active.    
    int weakened_shellcannon = (int)(19+ Math.random()*(4) - 7);  
    return (weakened_shellcannon); //Return the Shell Cannon damage to the main method.
    } //End of Method 2.
    
    public static int weakened_flyingslam () {
    //Damage of Flying Slam if the blue shell defense boost is active.    
    int weakened_flyingslam = (int)(16+ Math.random()*(10) - 7);
    return (weakened_flyingslam); //Return the Flying Slam damage to the main method.   
    } //End of Method 3.
    
    public static int weakened_meteorrain () {
    //Damage of Meteor Rain if the blue shell defense boost is active.    
    int weakened_meteorrain = (int)(20+ Math.random()*(8) - 7);    
    return (weakened_meteorrain); //Return the Meteor Rain damage to the main method.   
    } //End of Method 4.
    
    public static int weakened_hammerthrow () {
    //Damage of Hammer Throw if the blue shell defense boost is active.    
    int weakened_hammerthrow = (int)(17+ Math.random()*(10) - 7);   
    return (weakened_hammerthrow); //Return the Hammer Throw damage to the main method.
    } //End of Method 5.
    
    public static int mechakoopa_mayhem () {
    //Damage of Mechakoopa Mayhem if the blue shell defense boost is active.    
    int weakened_mechakoopamayhem = (int)(19+ Math.random()*(6) - 7);    
    return (weakened_mechakoopamayhem); //Return the Mechakoopa Mayhem damage to the main method.   
    } //End of Method 6.
    
    public static void mario_ending () {
    //Print Mario's ending to the main method.    
    System.out.println("NOOO!!! HOW CAN THIS BE POSSIBLE?!");
    System.out.println("After all the trouble I went through...");
    System.out.println("How could it...end like this....");
    System.out.println("Mario swung his hammer and sent Bowser flying!");
    System.out.println("Mario ran towards the dungeon where Princess Peach was held hostage.");
    System.out.println("Once he arrived there, Mario used the dungeon key to unlock her cell.");
    System.out.println("Thank you for saving me, Brave Mario...let's go back to the palace.");
    System.out.println("With the defeat of Bowser...peace prevailed. Now it's time for Mario to get his reward.");
    System.out.println("A homemade cake!");
    System.out.println("THE END");
    System.out.println("\n");
    } //End of Method 7.
    
    public static void bowser_ending () {
    //Print Bowser's 1st ending to the main method.    
    System.out.println("BWAHAHAHA!! You were a fool to stand against me, Mario!");
    System.out.println("Now its time to say GOODBYE!");
    System.out.println("So long you loser!");
    System.out.println("Bowser widened his mouth and released a breath of fire.");
    System.out.println("Mario was too wounded to escape and was burned alive.");
    System.out.println("With the defeat of the Mushroom Kingdom's last hope, Mario...");
    System.out.println("King Bowser Koopa was now ruler of the Mushroom Kingdom.");
    System.out.println("In due time, the whole kingdom was redesigned to suit his tastes.");
    System.out.println("There was no longer a Mushroom Kingdom. Now it was known as....");
    System.out.println("Neo Bowser Kingdom");
    System.out.println("\n");
    System.out.println("GAME OVER");
    System.out.println("\n");
    } //End of Method 8.
    
    public static void bowser_endingtwo () {
    //Print Bowser's 2nd ending to the main method.    
    System.out.println("BWAHAHA!!! Just like your brother, you too have fallen!");
    System.out.println("Sayanora, Green 'Stache!");
    System.out.println("Bowser launched a breath of fire at Luigi incinerating him!");
    System.out.println("BWAHAHAHAHA!!!! Victory is MINE!!!");
    System.out.println("With the defeat of Luigi and Mario before him, there stood nothing that could get in Bowser's way.");
    System.out.println("King Bowser Koopa was now ruler of the Mushroom Kingdom.");
    System.out.println("In due time, the whole kingdom was redesigned to suit his tastes.");
    System.out.println("There was no longer a Mushroom Kingdom. Now it was known as....");
    System.out.println("Neo Bowser Kingdom");
    System.out.println("\n");
    System.out.println("GAME OVER");
    System.out.println("\n");        
    } //End of Method 9.
    
    public static void luigi_ending () {
    //Print Luigi's ending to the main method.    
    System.out.println("GAAAAAHHH!!! IMPOSSIBLE! I defeated Mario....");
    System.out.println("How could I lose to his younger brother....");
    System.out.println("Luigi sent Bowser packing with a bolt of lightning!");
    System.out.println("Luigi quickly ran to the dungeon and freed both Peach and Mario!");
    System.out.println("Luigi, you saved us both!");
    System.out.println("Bro, you really are amazing...come on. Let's go home.");
    System.out.println("With the defeat of Bowser, Mario, Luigi and Peach all returned to the Mushroom Kingdom.");
    System.out.println("A grand feast awaited both Mario and Luigi for their hardwork.");
    System.out.println("THE END");
    System.out.println("\n");    
    } //End of Method 10.
    
} //End of main class.