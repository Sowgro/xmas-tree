package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    static Random RNG = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_ORANGE = "\033[38:5:208m";
    public static final String ANSI_BROWN = "\033[38:5:52m";

    public static void main(String[] args) {
        tree(25);
    }

    public static Map.Entry<Character, String> ornament() {
        var l = new ArrayList<>(List.of(
                Map.entry('O', ANSI_RED),
                Map.entry('^', ANSI_YELLOW),
                Map.entry('&', ANSI_ORANGE),
                Map.entry('@', ANSI_BLUE),
                Map.entry('!', ANSI_WHITE),
                Map.entry('~', ANSI_PURPLE),
                Map.entry('$', ANSI_CYAN)
        ));
        for (int i = 0; i < 21; i++) {
            l.add(Map.entry('*', ANSI_GREEN));
        }
        return l.get(RNG.nextInt(0, l.size()));
    }

    public static void tree(int size) {
        for (int i = 0; i < size; i++) {
            printSpace(size - i);
            printOrnament(i * 2 + 1);
            System.out.println();
        }
        for (int i = 0; i < (size/3); i++) {
            printSpace(size - size/6);
            printStump(size/3);
            System.out.println();
        }
    }

    public static void printOrnament(int count) {
        for (int i = 0; i < count; i++) {
            var o = ornament();
            System.out.print(o.getValue() + o.getKey() + ANSI_RESET);
        }
    }

    public static void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void printStump(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ANSI_BROWN + '#' + ANSI_RESET);
        }
    }
}