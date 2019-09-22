import org.json.JSONArray;

public class Runner {
    private int place;
    private String name;
    private String school;
    private int grade;
    private String gender;
    private float time;

    Runner(JSONArray data) {
        place = Integer.parseInt((String) data.get(0));
        name = (String) data.get(3);
        String ln = (String) data.get(4);
        name = name + " " + ln.substring(ln.indexOf(">") + 1, ln.indexOf("<", ln.indexOf(">") + 1));
        school = (String) data.get(5);
        grade = Integer.parseInt((String) data.get(6));
        gender = (String) data.get(7);
        time = parseTime((String) data.get(8));
    }

    private float parseTime(String time) {
        String[] arr = time.split(":");
        float t = 0;
        for (String s : arr) {
            t *= 60;
            t += Float.parseFloat(s);
        }
        return t;
    }

    @Override
    public String toString() {
        return "{place=" + place +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", gender='" + gender + '\'' +
                ", time=" + time +
                '}';
    }
}
