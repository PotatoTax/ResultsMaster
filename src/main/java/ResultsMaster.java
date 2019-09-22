import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ResultsMaster {
    private ArrayList<Race> races;

    private ResultsMaster() {
        races = new ArrayList<>();
        for (int i = 1373; i < 2777; i++) {
            try {
                races.add(gopherStateEvents(i));
                raceToFile(i, races.get(races.size()-1));
                System.out.println("Race : " + i + " successful.");
            } catch (IOException e) {
                System.out.println("NO RACE WITH ID : " + i);
            } catch (org.json.JSONException e) {
                System.out.println("JSON MACHINE BROKE");
            } catch (java.lang.NumberFormatException e) {
                System.out.println("CONFUSING NUMBERS");
            }
        }
    }

    private Race gopherStateEvents(int raceID) throws IOException {
        Race race = new Race(raceID);
        String url = "https://www.gopherstateevents.com/results/cc_rslts/results_source.asp?race_id=";

        URL obj = new URL(url + raceID);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));) {
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }


        JSONObject jsonObject = new JSONObject(response.toString());
        JSONArray arr = jsonObject.getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) {
            race.addRunner((JSONArray) arr.get(i));
        }
        return race;
    }

    private void raceToFile(int raceID, Race race) throws IOException {
        String content = race.toString();
        BufferedWriter writer = new BufferedWriter(new FileWriter("RaceResults/" + raceID + ".txt"));
        writer.write(content);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new ResultsMaster();
    }
}
