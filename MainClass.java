import java.util.Scanner;
/**
 * This class doing a all input operations , run according to that and make the object of VendingMachine class and perform all the methods
 * that I create in VendingMachine Class
 *
 * @author  Satinder Singh,000824885
 */
public class MainClass {
    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Break Room !\nThere are two vending machine here:");
        /* Creating an object and set the values */
        VendingMachine v1 = new VendingMachine();
        v1.setProductName("Milk");
        v1.setCredit(0);
        v1.setProductPrice(4.47);
        v1.setProductQuantity(5);
        v1.setVendMoney(0);
        v1.setVendingNumber(1);
        /* Creating an object and set the values */
        VendingMachine v2 = new VendingMachine();
        v2.setProductName("Biscuits");
        v2.setCredit(0);
        v2.setProductPrice(3.98);
        v2.setProductQuantity(5);
        v2.setVendMoney(0);
        v2.setVendingNumber(2);

        /* boolean variables first set to true
         * mainCondition hold the execuation of main while loop
         * condition variable for internal while loop
         * */
        boolean condition = true, mainCondition = true;

        /*
         * isChoice2,isNumber,isChoice these boolean variables are for validating purposes
         * */
        boolean isChoice2, isNumber, isChoice;

        /*  Three integer variables which is set to zero
         * choice from out of 5
         * q means quantity
         * machineChoice which machine user wants to play with it*/
        int choice = 0, q = 0, machineChoice = 0;

        /* Two double variables which is set to zero
         * insertMoney takes the input from user how much user wants money to put in vending machine
         * changeInsert is the value that how much user wants that machine should return
         * */
        double insertMoney = 0, changeInsert = 0;

        while (mainCondition) {
            /* Call to string method which print whole statement */
            v1.toString(v1);
            v2.toString(v2);

            /*
             * In this do-while. It just validating that user only enter number. If not, it is continue running
             */
            do {
                System.out.println("Which Machine?");
                if (sc.hasNextInt()) {
                    machineChoice = sc.nextInt();
                    isNumber = true;
                } else {
                    System.out.println("INVALID ENTRY, TRY AGAIN");
                    isNumber = false;
                    sc.next();
                }
            }
            while (!(isNumber));

            System.out.println();
            condition = true;
            /*
             * If user enter more than 2 or less than 1, It starts again.
             */
            switch (machineChoice) {
                case 1:
                    /*
                     * Case 1 run if user choose first vending machine
                     * This internal while loop contains the options that vending machine have. Unlees you press 5
                     * you will stay in this loop or 4 to exit the program
                     */
                    while (condition) {
                        /*
                         * This function is declared at the end of this program. It just print options.
                         */
                        lineOfOptions();
                        /*
                         * In this do-while. It just validating that user only enter number.
                         * If not, it is continue running
                         */
                        do {
                            System.out.println("Your choice ?");
                            if (sc.hasNextInt()) {
                                choice = sc.nextInt();
                                isChoice = true;
                            } else {
                                System.out.println("INVALID ENTRY, TRY AGAIN");
                                isChoice = false;
                                sc.next();
                            }
                        }
                        while (!(isChoice));

                        /*
                         * howMuch1,change1,quantity1 these are use for validating purposes
                         */
                        boolean howMuch1 = false, change1, quantity1;

                        /*
                         * This switch runs under vending machine 1.It works upon what user enter a number to
                         * run particular command.If user enter wrong this still running
                         */
                        switch (choice) {
                            case 1:
                                /*
                                 * If user wants to insert money in this
                                 * In this do-while. It just validating that user only enter number.
                                 * If not, it is continue running
                                 */
                                do {
                                    System.out.println("How Much ?");
                                    if (sc.hasNextDouble()) {
                                        insertMoney = sc.nextDouble();
                                        if (insertMoney < 0) {
                                            howMuch1 = false;
                                        } else if (insertMoney == 1 || insertMoney == 2 || insertMoney == 0.25 || insertMoney == 0.05 || insertMoney == 0.10) {
                                            howMuch1 = true;
                                        }
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        howMuch1 = false;
                                        sc.next();
                                    }
                                }
                                while (!(howMuch1));
                                /*
                                 * I call two functions here.One is taking money and store into the machine
                                 * and second print statement
                                 */
                                v1.addMoney(insertMoney);
                                v1.toString(v1);
                                break;
                            case 2:
                                /*
                                 * If user wants cash back.changeInsert takes how much amount user wants back.
                                 * This do-while loop will run to validate if user input other that integer then it runs
                                 */
                                do {
                                    System.out.println("How much change?");
                                    if (sc.hasNextDouble()) {
                                        changeInsert = sc.nextDouble();
                                        if
                                        (changeInsert > v1.getCredit() || changeInsert <= -1) {
                                            System.out.println("ERROR!, TRY AGAIN!");
                                            change1 = false;
                                        } else {
                                            change1 = true;
                                        }
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        change1 = false;
                                        sc.next();
                                    }
                                }
                                while (!(change1));
                                if (change1) {
                                    /*
                                     * if changeInsert amount is acceptable then this will ru8n
                                     * Here I call two methods.One do the operation of cashback
                                     * and second print the statement
                                     */
                                    v1.change(v1.getCredit(), changeInsert);
                                    v1.toString(v1);
                                }
                                break;
                            case 3:
                                /*
                                 * This will execuate when user wants to vend an item
                                 */

                                /*
                                 * If Machine do not have more products.
                                 */
                                if (v1.getProductQuantity() == 0) {
                                    System.out.println("NO MORE STOCKS, SORRY");
                                    break;
                                }

                                /*
                                 * This is for Validate input.
                                 */
                                do {
                                    System.out.println("Quantity Plz");
                                    if (sc.hasNextInt()) {
                                        q = sc.nextInt();
                                        quantity1 = true;
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        quantity1 = false;
                                        sc.next();
                                    }
                                }
                                while (!(quantity1));

                                /*
                                 * If user credit is less than for its quantity demand then this block is run
                                 */
                                if (v1.getCredit() < v1.getProductPrice() * q) {
                                    System.out.println("ERROR of CREDIT!, TRY AGAIN!");
                                    break;
                                }

                                /*
                                 * IF user demand more stocks than it have or user enter negative value,this block run
                                 */
                                if (q > v1.getProductQuantity() || q < 0) {
                                    System.out.println("ERROR!, TRY AGAIN!");
                                    break;
                                } else {
                                    /*
                                     * if user quantity is acceptable then this will run
                                     * Here I call two methods.One do the operation of vend
                                     * and second print the statement
                                     * */
                                    v1.vend(q, v1.getCredit());
                                    v1.toString(v1);
                                }
                                break;
                            case 4:
                                /*
                                 * If user wants to exit the program
                                 * It set boolean variables to false which terminate the loop
                                 */
                                condition = false;
                                mainCondition = false;
                                System.out.println("GOODBIE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                break;
                            case 5:
                                /*
                                 * If user wants to Return to main menu
                                 * It set boolean variable to false which terminate the loop
                                 */
                                condition = false;
                                break;
                            default:
                                System.out.println("Invalid!!!!!!! Enter correctly.\n");

                        }
                    }
                    break;
                case 2:
                    /*
                     * Case 2 run if user choose second vending machine
                     * This internal while loop contains the options that vending machine have.Unlees you press 5
                     * you will stay in this loop or 4 to exit the program
                     */
                    while (condition) {
                        /*
                         * This function is declared at the end of this program. It just print options.
                         */
                        lineOfOptions();
                        /*
                         * In this do-while. It just validating that user only enter number.
                         * If not, it is continue running
                         */
                        do {
                            System.out.println("Your choice ?");
                            if (sc.hasNextInt()) {
                                choice = sc.nextInt();
                                isChoice2 = true;
                            } else {
                                System.out.println("INVALID ENTRY, TRY AGAIN");
                                isChoice2 = false;
                                sc.next();
                            }
                        }
                        while (!(isChoice2));
                        /*
                         * howMuch2,change2,quantity2 these are use for validating purposes
                         */
                        boolean howMuch2, change2, quantity2;
                        /*
                         * This switch runs under vending machine 2.It works upon what user enter a number to
                         * run particular command.If user enter wrong this still running
                         */
                        switch (choice) {
                            case 1:
                                /*
                                 * If user wants to insert money in this
                                 * In this do-while. It just validating that user only enter number.
                                 * If not, it is continue running
                                 */
                                do {
                                    System.out.println("How Much ?");
                                    if (sc.hasNextDouble()) {
                                        insertMoney = sc.nextDouble();
                                        if (insertMoney < 0) {
                                            howMuch2 = false;
                                        } else {
                                            howMuch2 = true;
                                        }
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        howMuch2 = false;
                                        sc.next();
                                    }
                                }
                                while (!(howMuch2));
                                /*
                                 * I call two functions here.One is taking money and store into the machine
                                 * and second print statement
                                 */
                                v2.addMoney(insertMoney);
                                v2.toString(v2);
                                break;

                            case 2:
                                /*
                                 * If user wants cash back.changeInsert takes how much amount user wants back.
                                 * This do-while loop will run to validate if user input other that integer then it runs
                                 */
                                do {
                                    System.out.println("How much change?");
                                    if (sc.hasNextDouble()) {
                                        changeInsert = sc.nextDouble();
                                        if
                                        (changeInsert > v2.getCredit() || changeInsert <= -1) {
                                            System.out.println("ERROR!, TRY AGAIN!");
                                            change2 = false;
                                        } else {
                                            change2 = true;
                                        }
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        change2 = false;
                                        sc.next();
                                    }
                                }
                                while (!(change2));
                                if (change2) {
                                    /*
                                     * if changeInsert amount is acceptable then this will run
                                     * Here I call two methods.One do the operation of cashback
                                     * and second print the statement
                                     */
                                    v2.change(v2.getCredit(), changeInsert);
                                    v2.toString(v2);
                                }
                                break;
                            case 3:
                                /*
                                 * This will execuate when user wants to vend an item
                                 */

                                /*
                                 * If Machine do not have more products.
                                 */
                                if (v2.getProductQuantity() == 0) {
                                    System.out.println("NO MORE STOCKS, SORRY");
                                    break;
                                }
                                /*
                                 * This is for Validate input.
                                 */
                                do {
                                    System.out.println("Quantity Plz");
                                    if (sc.hasNextInt()) {
                                        q = sc.nextInt();
                                        quantity2 = true;
                                    } else {
                                        System.out.println("INVALID ENTRY, TRY AGAIN");
                                        quantity2 = false;
                                        sc.next();
                                    }
                                }
                                while (!(quantity2));
                                /*
                                 * If user credit is less than for its quantity demand then this block is run
                                 */
                                if (v2.getCredit() < v2.getProductPrice() * q) {
                                    System.out.println("ERROR of Quantity or Credit!, TRY AGAIN!");
                                    break;
                                }
                                /*
                                 * IF user demand more stocks than it have or user enter negative value,this block run
                                 */
                                if (q > v2.getProductQuantity() || q < 0) {
                                    System.out.println("ERROR!, TRY AGAIN!");
                                    break;
                                } else {
                                    /*
                                     * if user quantity is acceptable then this will run
                                     * Here I call two methods.One do the operation of vend
                                     * and second print the statement
                                     * */
                                    v2.vend(q, v2.getCredit());
                                    v2.toString(v2);
                                }
                                break;
                            case 4:
                                /*
                                 * If user wants to exit the program
                                 * It set boolean variables to false which terminate the loop
                                 */
                                condition = false;
                                mainCondition = false;
                                System.out.println("GOODBIE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                break;
                            case 5:
                                /*
                                 * If user wants to Return to main menu
                                 * It set boolean variable to false which terminate the loop
                                 */
                                condition = false;
                                break;
                            default:
                                System.out.println("Invalid!!!!!!! Enter correctly.\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong Chooice.......");
            }

        }
    }

    static void lineOfOptions() {
        System.out.println("1 Enter Money");
        System.out.println("2 Get change Back");
        System.out.println("3 Vend an item");
        System.out.println("4 Leave the break room");
        System.out.println("5 Return to Main menu");
    }
}