package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, ArrayList<Person>> peopleByCountry = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Options.fileImporter();
        Options.listSorter();
        Options.listPrinter();
        Options.jsonWriter();
    }
}
