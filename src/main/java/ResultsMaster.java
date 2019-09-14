import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ResultsMaster {
    private Race race;
    private Scanner scanner;

    public ResultsMaster() throws IOException
    {
        System.out.println("Select website with results :\n   (1) Gopher State Events");
        scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        switch (selection)
        {
            case 1:
                gopherStateEvents();
                break;
            case 2:
                //mileSplit();
        }
    }

    private void gopherStateEvents() throws IOException
    {
        String url = "https://www.gopherstateevents.com/results/cc_rslts/results_source.asp?race_id=";
        System.out.println("Race ID : ");
        int raceID = scanner.nextInt();

        URL obj = new URL(url + raceID);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }
        in.close();
        Gson gson = new GsonBuilder().create();
        race = gson.fromJson(response.toString(), Race.class);
        System.out.println(race);
    }

    public static void main(String[] args) throws IOException
    {
        new ResultsMaster();
    }
}
