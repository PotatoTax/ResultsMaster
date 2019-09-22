import java.io.*;
import java.util.ArrayList;

public class PullIndividuals {
    private ArrayList<String[]> racers;

    private PullIndividuals() {
        racers = new ArrayList<>();
        File[] files = new File("RaceResults").listFiles();

        assert files != null;
        String[] name;
        for (File f : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.startsWith("Race : ")) {
                        line = line.substring(line.indexOf("'")+1);
                        line = line.substring(0, line.indexOf("'"));
                        name = line.split(" ");
                        if (!racers.contains(name[0] + " " + name[1])) {
                            racers.add(name[] )
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PullIndividuals();
    }
}
