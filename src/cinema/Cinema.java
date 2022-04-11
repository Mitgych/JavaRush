package cinema;

import java.util.Scanner;

public class Cinema {

    public static int x;
    public static int y;
    public static int xSeat;
    public static int ySeat;
    public static int price;
    public static String[][] cinemaHall;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Read sizes of cinema
        System.out.println("Enter the number of rows:");
        y = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        x = scanner.nextInt();

        //initialize cinemaHall
        cinemaHall = new String[y+ 1][x + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (i == 0) {
                    if (j == 0) {
                        cinemaHall[0][0] = " ";
                    } else {
                        cinemaHall[i][j] = Integer.toString(j);
                    }
                } else {
                    if (j == 0) {
                        cinemaHall[i][j] = Integer.toString(i);
                    } else {
                        cinemaHall[i][j] = "S";
                    }
                }
                
            }
        }

        //start menu
        int choise = 1;
        while (choise != 0) {
            menu();
            choise = scanner.nextInt();
            switch (choise) {
                case 1 -> {
                    printCinemaHall();
                    break;
                }
                case 2 -> {
                    buy();
                    break;
                }

            }
        }
        scanner.close();
    }


    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        ySeat = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        xSeat = scanner.nextInt();
        cinemaHall[ySeat][xSeat] = "B";

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
    }


    //write picture of cinema
    public static void printCinemaHall() {
        System.out.println("\nCinema:");
        for (String[] i: cinemaHall) {
            for (String j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //print menu
    public static void menu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit\n");
    }
}