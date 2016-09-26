import com.company.Main;
import com.company.Options;
import com.company.Person;
import jodd.json.JsonSerializer;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.MapWrapper.hashWrap;
import static org.junit.Assert.assertTrue;

/**
 * Created by michaelplott on 9/26/16.
 */
public class MainTest {

    @Test
    // Trying to assert true if the hashmap is loaded correctly using my fileImporter method.
    public void testImport() throws FileNotFoundException {
        Options.fileImporter();
        assertTrue(Main.peopleByCountry != null);
    }

    @Test
    //testing to make sure my json method is writing a json file.
    public void testJson() throws IOException {
        File f = new File("people.txt");
        Options.fileImporter();
        hashWrap = Main.peopleByCountry;
        File nameFile = new File("people.json");
        hashWrap = Main.peopleByCountry;
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(hashWrap);
        FileWriter fw = new FileWriter(nameFile);
        fw.write(json);
        fw.close();
        f.exists();
    }

    @Test
    // testing to see if my arraylists that exist in my hashmap are populated correctly.
    public void testListPrinter() {
        String choice = "France";
        ArrayList<Person> userChoice = Main.peopleByCountry.get(choice);
        for (Person p : userChoice) {
            System.out.println(p.personID + " " + p.lastName + " " + "from" + " " + p.country);
        }
    }

    @Test
    // testing to see if my arraylists print out correctly once sorted.
    public void testListSorter() {
        for (String key : Main.peopleByCountry.keySet()) {
            ArrayList<Person> peopleByLastname = Main.peopleByCountry.get(key);
            Collections.sort(peopleByLastname);
            Main.peopleByCountry.put(key, peopleByLastname);
            ArrayList<Person> testPeople = Main.peopleByCountry.get("France");
            for (int i = 0; i < testPeople.size(); i++) {
                String lname = testPeople.get(i).lastName;
                String testCountry = testPeople.get(i).country;
                System.out.printf("%s from %s\n", lname, testCountry);
            }
        }
    }
}
