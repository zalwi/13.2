package logic;

import data.Computer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComputerOperator {

    private ComputerOperator(){
        //Cannot create object of ComputerOperator
    }

    private final static String AUTO="auto";
    private final static String NAME="name";
    private final static String CPU="cpu";
    private final static String MEMORY="memory";
    private final static String QUIT="quit";

    public static void runSortMenu(List<Computer> computers) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("---------------------------------\n" +
                    "Podaj opcję opcję:\n" +
                    "Dostępne: auto, name, cpu, memory\n" +
                    "lub quit dla zakończenia programu");

            String sortOption = scanner.nextLine();

            switch (sortOption) {
                case AUTO -> {
                    System.out.println("Wybrano: " + AUTO);
                    Collections.sort(computers);
                    printComputerList(computers, "\nStandardowe sortowanie (auto)");
                }
                case NAME -> {
                    System.out.println("Wybrano: " + NAME);
                    Collections.sort(   computers,
                                        Comparator.comparing(   Computer::getName,
                                                                Comparator.nullsFirst(Comparator.naturalOrder())));
                    printComputerList(computers, "\nSortowanie po nazwie");
                }
                case CPU -> {
                    System.out.println("Wybrano: " + CPU);
                    Collections.sort(   computers,
                                        Comparator.comparing(   Computer::getCpu,
                                                                Comparator.nullsFirst(Comparator.naturalOrder())));
                    printComputerList(computers, "\nSortowanie po CPU");
                }
                case MEMORY -> {
                    System.out.println("Wybrano: " + MEMORY);
                    Collections.sort(   computers,
                                        Comparator.comparing(   Computer::getMemory,
                                                                Comparator.nullsFirst(Comparator.naturalOrder())));
                    printComputerList(computers, "\nSortowanie po ilości pamięci");
                }
                case QUIT -> {
                    loop = false;
                }
                default -> {
                    System.out.println("Podano zły parametr sortowania: " + sortOption);
                }
            }
        } while (loop);
    }

    public static void printComputerList(List<Computer> arr, String headerDescription) {
        System.out.println(headerDescription);
        for(Computer c: arr) {
            System.out.println(c);
        }
    }
}
