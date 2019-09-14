import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Race {
    public ArrayList<Runner> getRunners() {
        return runners;
    }

    private ArrayList<Runner> runners;
    private ArrayList data;

    public Race()
    {
        runners = new ArrayList<Runner>();

        Gson gson = new GsonBuilder().create();
        System.out.println(data);
        runners.add(gson.fromJson(String.valueOf(data), Runner.class));
    }

    @Override
    public String toString() {
        return "Race{" +
                "runners=" + runners +
                '}';
    }
}
