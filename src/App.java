/*
 * Author: Adam Michael Wood
 * 
 */

import java.util.LinkedList;
import java.util.Scanner;


/**
 * A Java program that reads a list of Integer numbers from the scanned input 
 * and saves them into a Linked List sorted from the smallest to the largest. 
 * The program asks for integers one at a time from the console and
 * stops when the user presses enter without typing a number.
 * Each number is saved into the linked list when it is received. 
 * If the user types something other than an integer, 
 * a short error/correction message is displayed.
 * When the user is done, the linked list is printed to the console.
 */
public class App {
    /**
     * Main method to execute the program.
     */
    public static void main(String[] args) {
        LinkedList<Integer> sortedList = new LinkedList<>();

        System.out.println("Enter integers (press Enter without typing a number to finish):");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    break; // If user presses Enter without typing a number, exit loop
                }

                try {
                    int num = Integer.parseInt(input);
                    insertSorted(sortedList, num); // Insert the number into the sorted list
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please try again."); // Error message for invalid input
                }
            }
        }

        System.out.println("Sorted Linked List: " + sortedList);
    }

    /**
     * Helper method to insert a number into the sorted linked list.
     * @param list The sorted linked list.
     * @param num The number to insert into the list.
     */
    private static void insertSorted(LinkedList<Integer> list, int num) {
        int index = 0;
        for (int i : list) {
            if (num < i) {
                break;
            }
            index++;
        }
        list.add(index, num);
    }
}