package cinema;

import java.util.Scanner;

public class Cinema {

    public static int x;
    public static int y;
    public static int xSeat;
    public static int ySeat;
    public static int price;
    public static String[][] cinemaHall;
    //Statistics variables
    public static int countSoldTicket = 0;
    public static double countSoldTicketPercent = 0.00;
    public static int currIncome = 0;
    public static int totalIncome;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                //Read sizes of cinema
                System.out.println("Enter the number of rows:");
                y = scanner.nextInt();
                System.out.println("Enter the number of seats in each row:");
                x = scanner.nextInt();

                cinemaHall = new String[y][x]; //initialize cinemaHall
                for (String[] i : cinemaHall) { //set start parameters in cinemaHall
                    for (int j = 0; j < x; j++) {
                        i[j] = "S";
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input!");
            }
        }

        if (x * y <= 60) {
            totalIncome = x * y * 10; //initialize totalIncome
        } else {
            totalIncome = y / 2 * x * 10 + (y - y / 2) * x * 8;
        }

        //start menu
        try {
            int choice = 1;
            while (choice != 0) {
                menu();
                choice = scanner.nextInt();
                //if (choice == 0) {
                //    scanner.close();
                //}
                if (choice >= 0 && choice <= 3) {
                    switch (choice) {
                        case 1 -> printCinemaHall();
                        case 2 -> buy();
                        case 3 -> statistics();
                    }
                } else {
                    System.out.println("Wrong input!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter a row number:");
                ySeat = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                xSeat = scanner.nextInt();
                if ("B".equals(cinemaHall[ySeat - 1][xSeat - 1])) {
                    System.out.println("That ticket has already been purchased!");
                    continue;
                }
                cinemaHall[ySeat - 1][xSeat - 1] = "B";
                
                //write ticket price
                if (x * y <= 60) {
                    price = 10;
                } else if (ySeat <= y / 2) {
                    price = 10;
                } else {
                    price = 8;
                }
                System.out.printf("\nTicket price: $%d", price);
                System.out.println();
                countSoldTicket += 1;
                countSoldTicketPercent = (double) countSoldTicket / x / y * 100;
                currIncome += price;
                break;
            } catch (Exception e) {
                System.out.println("Wrong input!");
            }
        }
    }


    //write picture of cinema
    public static void printCinemaHall() {
        System.out.println("\nCinema:\n");
        System.out.print("  ");
        for (int i = 1; i <= x; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < y; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < x; j++) {
                System.out.print(cinemaHall[i][j] + " ");
            }
            System.out.println();
        }
    }

    //print menu
    public static void menu() {
        System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");
    }

    public static void statistics() {
        System.out.printf("\nNumber of purchased tickets: %d\n", countSoldTicket);
        System.out.printf("Percentage: %.2f%%\n", countSoldTicketPercent);
        System.out.printf("Current income: $%d\n", currIncome);
        System.out.printf("Total income: $%d\n", totalIncome);

    }
}


