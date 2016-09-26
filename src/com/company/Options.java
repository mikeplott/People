package com.company;

import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static com.company.MapWrapper.hashWrap;


/**
 * Created by michaelplott on 9/26/16.
 */
public class Options {

    public static void jsonWriter() throws IOException {
        File nameFile = new File("people.json");
        hashWrap = Main.peopleByCountry;
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(hashWrap);
        FileWriter fw = new FileWriter(nameFile);
        fw.write(json);
        fw.close();
    }

    public static void listSorter() {
        for (String key : Main.peopleByCountry.keySet()) {
            ArrayList<Person> peopleByLastname = Main.peopleByCountry.get(key);
            Collections.sort(peopleByLastname);
            Main.peopleByCountry.put(key, peopleByLastname);
        }
    }

    public static void listPrinter() {
        System.out.println("Please enter a country");
        String choice = Main.scanner.nextLine();
        ArrayList<Person> userChoice = Main.peopleByCountry.get(choice);
        for (Person p : userChoice) {
            System.out.println(p.personID + " " + p.lastName + " " + "from" + " " + p.country);
        }
        listPrinter();
    }



    public static void fileImporter() throws FileNotFoundException {
        File f = new File("People.csv");
        Scanner fileReader = new Scanner(f);
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            String[] columns = line.split(",");
            String personID = columns[0];
            String fName = columns[1];
            String lName = columns[2];
            String em = columns[3];
            String fileCountry = columns[4];
            String fileIP = columns[5];
            Person person = new Person(personID, fName, lName, em, fileCountry, fileIP);
            ArrayList<Person> people = new ArrayList<>();
            people.add(person);
            for (Person person1 : people) {
                ArrayList<Person> peepsByCountry = Main.peopleByCountry.get(fileCountry);
                if (peepsByCountry == null) {
                    peepsByCountry = new ArrayList<>();
                    Main.peopleByCountry.put(fileCountry, peepsByCountry);
                }
                peepsByCountry.add(person1);
            }
        }
    }
}
