import org.json.JSONArray;

import java.util.ArrayList;

public class Race {
    private int raceID;
    private ArrayList<Runner> runners;

    Race(int raceID) {
        this.raceID = raceID;
        runners = new ArrayList<>();
    }

    void addRunner(JSONArray data) {
        if (data.get(2).equals("")) {
            return;
        }
        runners.add(new Runner(data));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Race : ").append(raceID).append("\n");

        for (Runner r : runners)
        {
            stringBuilder.append(r.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
