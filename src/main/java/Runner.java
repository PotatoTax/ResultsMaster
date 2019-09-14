public class Runner {
    private int place;
    private int score;
    private int bibNumber;
    private String name;
    private String link;
    private String school;
    private int grade;
    private String gender;
    private int time;

    public Runner(int place, int score, int bibNumber, String name, String link, String school, int grade, String gender, int time) {
        this.place = place;
        this.score = score;
        this.bibNumber = bibNumber;
        this.name = name;
        this.link = link;
        this.school = school;
        this.grade = grade;
        this.gender = gender;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "place=" + place +
                ", score=" + score +
                ", bibNumber=" + bibNumber +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", gender='" + gender + '\'' +
                ", time=" + time +
                '}';
    }
}
