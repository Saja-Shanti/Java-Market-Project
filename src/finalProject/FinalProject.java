package finalProject;

import java.util.Scanner;

public class FinalProject {

    //method to check if card is empty
    public static boolean isEmptyCard(int array[]) {

        int sum = 0;

        boolean isEmpty = false;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        if (sum == 0) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public static void main(String[] args) {
        String productName[] = new String[100];
        int quantity[] = new int[100];
        float price[] = new float[100];
        int customer[] = new int[100];

        Scanner userInput = new Scanner(System.in);
        productName[0] = "Laptop";
        productName[1] = "Ipad";
        productName[2] = "Tv";
        productName[3] = "Conditioners";
        productName[4] = "Headfone";
        productName[5] = "Mobile";
        productName[6] = "Oven";
        productName[7] = "Power";
        productName[8] = "Watch";
        productName[9] = "Phone Smart cover";

        price[0] = 800;
        price[1] = 299.9F;
        price[2] = 549;
        price[3] = 300;
        price[4] = 3.5F;
        price[5] = 420;
        price[6] = 159.99f;
        price[7] = 15;
        price[8] = 60;
        price[9] = 11;

        quantity[0] = 0;
        quantity[1] = 30;
        quantity[2] = 49;
        quantity[3] = 23;
        quantity[4] = 3;
        quantity[5] = 20;
        quantity[6] = 15;
        quantity[7] = 1;
        quantity[8] = 3;
        quantity[9] = 21;

        int productNumber = 0;
        int userChoice;

        do {
            System.out.println(" <<< Please, Select What You Want to Do From The Below Menu >>> ");
            System.out.println("1)Show products in the store.\n"
                    + "2)Add to cart\n"
                    + "3)Remove from cart\n"
                    + "4)Display cart & total price.\n"
                    + "5)Exit.");
            System.out.println("------------------------------------------------------");

            userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    for (int i = 0; i < productName.length; i++) {

                        if (productName[i] != null) {

                            String notFound = quantity[i] == 0 ? "SOULD OUT!" : quantity[i] + "items"; //short hand if to print text based on item status
                            System.out.printf((i + 1) + ": " + productName[i] + " , " + notFound + " , " + price[i] + "$");
                            System.out.println();
                        } else {

                            quantity[i] = -1;
                            break;

                        }

                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.println("Please, Enter The Product Number to Add in Cart ");
                    productNumber = userInput.nextInt();

                    if (quantity[productNumber - 1] == -1 || productName[productNumber - 1] == null) {

                        System.out.println("Invalid Option.\n Sorry Your Choise Is  Not Currently Avilable.");
                       
                    } else if (quantity[productNumber - 1] == 0) {

                        System.out.println("The Product Is Sold Out!");
                     
                    } else {
                        if (customer[productNumber - 1] == 0) {

                            System.out.println("How Many " + productName[productNumber - 1].toLowerCase() + " do you want to add ?");
                        } else {

                            System.out.println(productName[productNumber - 1] + " Is Already Existed In The Cart. How Many " + productName[productNumber - 1].toLowerCase() + " to Add In The Cart ?");
                        }

                        int proCount = userInput.nextInt();

                        if (proCount <= quantity[productNumber - 1]) {
                            System.out.println("Done Successfully");

                            if (customer[productNumber - 1] == 0) {
                                customer[productNumber - 1] = proCount;


                            } else {
                                customer[productNumber - 1] += proCount;

                            }

                        } else {

                            System.out.println("The Required Quantity Is Not Availble : Please, Try Again");
                            proCount = userInput.nextInt();

                            if (proCount <= quantity[productNumber - 1]) {
                                System.out.println("Done Successfully");

                                if (customer[productNumber - 1] != 0) {

                                    customer[productNumber - 1] += proCount;

                                } else {

                                    customer[productNumber - 1] = proCount;
                                }

                            }
                        }

                        quantity[productNumber - 1] -= proCount;
                    }
                    break;

                case 3:

                    if (isEmptyCard(customer) == true) {

                        System.out.println("Your Card Is Allready Empty");
                        break;
                    }

                    System.out.println("Enter The Product Number to Remove It From The Cart");

                    int proRemove = userInput.nextInt();

                    if (customer[proRemove - 1] == 0) {

                        System.out.println("You don't have " + productName[proRemove - 1].toLowerCase() + " in your cart");
                        break;

                    } else {
                        System.out.println("How many " + productName[proRemove - 1].toLowerCase() + " do you want to remove");

                        int proRemoveCount = userInput.nextInt();

                        if (proRemoveCount <= customer[proRemove - 1]) {

                            System.out.println("Done Successfully");
                            customer[proRemove - 1] -= proRemoveCount;
                            quantity[proRemove - 1] += proRemoveCount;

                        } else {

                            System.out.println("Invalid Process. \n You just have " + customer[proRemove - 1] + " " + productName[proRemove - 1].toLowerCase());
                        }
                    }
                    break;

                case 4:

                    if (isEmptyCard(customer) == true) {

                        System.out.println("Your Card Is Empty");
                        break;

                    }

                    System.out.println("Your Cart Has Following Products:");

                    float sum = 0;
                    for (int i = 0; i < customer.length; i++) {

                        if (customer[i] > 0) {

                            System.out.println(productName[i] + "," + customer[i] + "items" + "," + " price" + price[i] * customer[i] + "$");
                            sum += (price[i] * customer[i]);

                        }
                    }

                    System.out.println();
                    System.out.println("Total Price = " + sum + "$");

                    break;

                case 5:

                    System.out.println("Bye!");
                    System.exit(0);

                default:

                    System.out.println("\"Invalid Value\"");

            }

        } while (userChoice != 5);

    }

}
