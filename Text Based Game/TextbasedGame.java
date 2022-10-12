import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.Random;


public class TextbasedGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies ={"Zombie","Vampire","Witch","Dragon","Assassin"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage= 20;

        //Player variables

        int health = 100;
        int attackDamage= 30;
        int numHealthPootions= 3;
        int healthPotionMealAmount= 30;
        int healthPotionDropChance=50;

        boolean running= true;

        System.out.println("\t<#Welcome to the Dungeon");
         GAME:
        while(running)
        {
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("\t#"+enemy+" has appeared! #\n");
            while(enemyHealth>0)
            {
                System.out.println("\t#Your HP: "+health);
                System.out.println("\t#"+enemy+"'s HP: "+enemyHealth);
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink Potion");
                System.out.println("\t3.Run");

                String input = in.nextLine();

                if(input.equals("1"))
                {
                   int damageDealt= rand.nextInt(attackDamage);
                   int damageTaken= rand.nextInt(enemyAttackDamage);

                   health -= damageDealt;
                   enemyHealth-= damageTaken;

                   System.out.println("\t<You striked the "+enemy+" for "+damageDealt);
                   System.out.println("\t<You recieve "+damageTaken+" in retalliation");
                   if(health<1)
                   {
                    System.out.println("\t<You have taken too much damage, you are too weak to go on!");
                    break;
                   }


                }
                else if(input.equals("2"))
                {
                    if(numHealthPootions>0)
                    {
                        health+=numHealthPootions;
                        numHealthPootions--;
                        System.out.println("\t<You drink a health potion, healing yourself for "+healthPotionMealAmount+"."
                        +"\n You have "+numHealthPootions+" health potions left");
                    }
                    else
                    {
                        System.out.println("You have no health potions left, Defeat the enemies to get one!");
                    }
                }
                else if(input.equals("3"))
                {
                   System.out.println("You run away from the "+enemy);
                   
                   continue GAME;
                  
                }
                else 
                {
                    System.out.println("Invalid command");

                }

            }
            if(health<1)
            {
                System.out.println("\t<You limp out of dungeon, weak from battle");
                break;
            }
             System.out.println("\t------------------------------------");
             System.out.println("\t#"+enemy+" was defeated");
             System.out.println("\tYou have "+health+" HP left.#");
             if(rand.nextInt(100)<healthPotionDropChance)
             {
                numHealthPootions++;
                System.out.println("\tThe"+enemy+"dropped a health potions");
                System.out.println("\tYou now have"+numHealthPootions+"health potions");
             }
             System.out.println("---------------------------------");
             System.out.println("\tWhat would you like to do?");
             System.out.println("\t1.Continue Fighting");
             System.out.println("\t2.Exit Dungeon");

             String input = in.nextLine();
             while(!input.equals("1")&&!input.equals("2"))
             {
                System.out.println("!!!!Invalid command");
                input =in.nextLine();
             }
             if(input.equals("1"))
             {
                System.out.println("\t#You continue your adventure");
             }
             else if(input.equals("2"))
             {
                System.out.println("You exit the dungeon, successful from adventure");
                break;
             }

        
            }
        System.out.println("\t#######################");
        System.out.println("\tThanks for playing!");
        System.out.println("\t#######################");

    }

}
