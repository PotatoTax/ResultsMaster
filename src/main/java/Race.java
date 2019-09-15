import org.json.JSONArray;

import java.util.ArrayList;

public class Race {
    private ArrayList<Runner> runners;
    private ArrayList<School> schools;
    private ArrayList data;

    public ArrayList<Runner> getRunners() {
        return runners;
    }

    Race() {
        runners = new ArrayList<>();
        schools = new ArrayList<>();
    }

    public void score() {
        boolean foundSchool;
        for (Runner r : runners) {
            foundSchool = false;
            for (School s : schools) {
                if (r.getSchool().equals(s.getName())) {
                    s.addRunner(r);
                    foundSchool = true;
                    break;
                }
            }
            if (!foundSchool) {
                School s = new School(r.getSchool());
                s.addRunner(r);
                System.out.println(s.getName());
                schools.add(s);
            }
        }

        for (School s : schools) {
            s.score();
        }
    }

    void addRunner(JSONArray data) {
        runners.add(new Runner(data));
    }

    ArrayList<School> getSchools() {
        return schools;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Runner r : runners)
        {
            stringBuilder.append(r.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
