import org.json.JSONArray;

public class Runner {
    private int place;
    private int score;
    private int bibNumber;
    private String firstName;
    private String lastName;
    private String school;
    private int grade;
    private String gender;
    private float time;

    Runner(JSONArray data) {
        place = Integer.parseInt((String) data.get(0));
        try
        { score = Integer.parseInt((String) data.get(1)); }
        catch (NumberFormatException e)
        { score = -1; }
        bibNumber = Integer.parseInt((String) data.get(2));
        firstName = (String) data.get(3);
        String ln = (String) data.get(4);
        lastName = ln.substring(ln.indexOf(">") + 1, ln.indexOf("<", ln.indexOf(">") + 1));
        school = (String) data.get(5);
        grade = Integer.parseInt((String) data.get(6));
        gender = (String) data.get(7);
        String t = (String) data.get(8);
        time = Integer.parseInt(t.substring(0, 2)) * 60;
        time += Float.parseFloat(t.substring(3));
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBibNumber() {
        return bibNumber;
    }

    public void setBibNumber(int bibNumber) {
        this.bibNumber = bibNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "place=" + place +
                ", score=" + score +
                ", bibNumber=" + bibNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", gender='" + gender + '\'' +
                ", time=" + time +
                '}';
    }
}
