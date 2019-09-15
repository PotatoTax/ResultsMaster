import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ResultsMaster {
    private Race race;
    private Scanner scanner;

    ResultsMaster() {
        race = new Race();
        scanner = new Scanner(System.in);
    }

    void gopherStateEvents() throws IOException {
        String url = "https://www.gopherstateevents.com/results/cc_rslts/results_source.asp?race_id=";

        System.out.println("Race ID : ");
        int raceID = scanner.nextInt();

        URL obj = new URL(url + raceID);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        JSONArray arr = jsonObject.getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) {
            race.addRunner((JSONArray) arr.get(i));
        }
    }

    @Override
    public String toString() {
        return "ResultsMaster{\n" +
                race.toString();
    }

    public static void main(String[] args) {
        new ResultsMaster();
    }
}
