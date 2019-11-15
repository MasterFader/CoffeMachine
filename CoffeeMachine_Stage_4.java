        package machine;

        import java.util.Scanner;

public class CoffeeMachine {

    private static int useWater(int waterAvailable, int waterNeeded){
        return waterAvailable - waterNeeded;
    }
    private static int useMilk(int milkAvailable, int milkNeeded){
        return milkAvailable - milkNeeded;
    }
    private static int useCoffee(int coffeeAvailable, int coffeeNeeded){
        return coffeeAvailable - coffeeNeeded;
    }
    private static int useCups(int cupsAvailable){
        return cupsAvailable- 1;
    }
    private static int collectMoney(int moneyAvailable, int moneyNeeded){
        return moneyAvailable + moneyNeeded;
    }
    private static String missingIngredient(int waterAvailable, int milkAvailable, int coffeeAvailable, int cupsAvailable, int waterNeeded, int milkNeeded, int coffeeNeeded){
        String ingredient = null;
        if (waterAvailable < waterNeeded ) {
            ingredient = "water";
        } else if (coffeeAvailable < coffeeNeeded) {
            ingredient = "coffee";
        } else if (milkAvailable < milkNeeded) {
            ingredient =  "milk";
        } else if (cupsAvailable == 0) {
            ingredient =  "cups";
        }
        return ingredient;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //default Ingredients available:
        int availableWater = 400;
        int availableMIlk = 540;
        int availableCoffee = 120;
        int availableCups = 9;
        int availableMoney = 550;

        //cicle Variables
        String menuChoice;
        String beverageChoice;

        //espresso ingredients:
        int espressoWater = 250, espressoCoffee = 16;
        //latte ingredients:
        int latteWater = 350, latteMilk = 75, latteCoffee = 20;
        //cappuccino ingredients:
        int cappuccinoWater = 200, cappuccinoMilk = 100, cappuccinoCoffee = 12;
        //prices:
        int espressoPrice = 4, lattePrice = 7, cappuccinoPrice = 6;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            menuChoice = scanner.next();
            System.out.println();

            switch (menuChoice) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    beverageChoice = scanner.nextLine();
                    System.out.println();

                    switch (beverageChoice) {
                        case "1":
                            if (availableWater >= espressoWater && availableCoffee >= espressoCoffee && availableCups > 0) {

                                availableWater = useWater(availableWater, espressoWater);
                                availableCoffee = useCoffee(availableCoffee,espressoCoffee);
                                availableCups = useCups(availableCups);
                                availableMoney = collectMoney(availableMoney,espressoPrice);
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                break;

                            } else {
                                System.out.println("Sorry, not enough " + missingIngredient(availableWater,availableMIlk,availableCoffee,availableCups,espressoWater,availableMIlk,espressoCoffee)+"!");
                                System.out.println();
                                break;
                            }
                        case "2":
                            if (availableWater >= latteWater && availableCoffee >= latteCoffee && availableMIlk >= latteMilk && availableCups > 0) {

                                availableWater = useWater(availableWater, latteWater);
                                availableMIlk = useMilk(availableMIlk,latteMilk);
                                availableCoffee = useCoffee(availableCoffee,latteCoffee);
                                availableCups = useCups(availableCups);
                                availableMoney = collectMoney(availableMoney,lattePrice);
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                break;

                            } else {

                                System.out.println("Sorry, not enough " + missingIngredient(availableWater,availableMIlk,availableCoffee,availableCups,latteWater,latteMilk,latteCoffee)+"!");
                                System.out.println();
                                break;
                            }
                        case "3":
                            if (availableWater >= cappuccinoWater && availableCoffee >= cappuccinoCoffee && availableMIlk >= cappuccinoMilk && availableCups > 0) {

                                availableWater = useWater(availableWater, cappuccinoWater);
                                availableMIlk = useMilk(availableMIlk,cappuccinoMilk);
                                availableCoffee = useCoffee(availableCoffee,cappuccinoCoffee);
                                availableCups = useCups(availableCups);
                                availableMoney = collectMoney(availableMoney,cappuccinoPrice);
                                System.out.println("I have enough resources, making you a coffee!");
                                System.out.println();
                                break;

                            } else {

                                System.out.println("Sorry, not enough " + missingIngredient(availableWater,availableMIlk,availableCoffee,availableCups,cappuccinoWater,cappuccinoMilk,cappuccinoCoffee)+"!");
                                System.out.println();
                                break;
                            }
                        case "back":
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    availableWater += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    availableMIlk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want ");
                    availableCoffee += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    availableCups += scanner.nextInt();
                    System.out.println();
                    break;

                case "take":
                    System.out.println("I gave you " + availableMoney);
                    availableMoney = 0;
                    System.out.println();
                    break;

                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(availableWater + " of water");
                    System.out.println(availableMIlk + " of milk");
                    System.out.println(availableCoffee + " of coffee beans");
                    System.out.println(availableCups + " of disposable cups");
                    System.out.println("&"+availableMoney + " of money");
                    System.out.println();
                    break;

                case "exit":
                    break;
            }
        }while (!menuChoice.equals("exit"));

    }
}
