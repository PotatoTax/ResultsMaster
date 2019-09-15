import java.util.ArrayList;

public class School {
    private String name;
    private int score;
    private float averageTime;
    private float split;
    private ArrayList<Runner> runners;

    School(String name) {
        this.name = name;
        runners = new ArrayList<>();
    }

    void addRunner(Runner r) {
        runners.add(r);
    }

    void score() {
        if (runners.size() < 5) {
            score = -1;
            averageTime = -1;
            split = -1;
        } else {
            float totalTime = 0;
            for (int i = 0; i < 5; i++) {
                score += runners.get(i).getScore();
                totalTime += runners.get(i).getTime();
            }
            averageTime = totalTime / 5;
            split = runners.get(4).getTime() - runners.get(0).getTime();
        }
    }

    String getName() {
        return name;
    }

    ArrayList<Runner> getRunners() {
        return runners;
    }

    void setScore(int score) {
        this.score = score;
    }

    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("School{\nname=").append(name).append("\nscore=").append(score).append("\naverageTime=").append(averageTime).append("\nsplit=").append(split).append("\nrunners=");
        for (Runner r : runners)
        {
            stringBuilder.append(r);
        }
        return stringBuilder.toString();
    }
}
