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

        //initialize
        cinemaHall = new String[y][x];
        for (String[] i: cinemaHall) {
            for (int j = 0; j < x; j++) {
                i[j] = "S";
            }
        }

        //start menu
        int choice = 1;
        while (choice != 0) {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> printCinemaHall();
                case 2 -> buy();

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
        System.out.println();
    }

    //print menu
    public static void menu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit\n");
    }
}