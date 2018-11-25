package educards.educards_model;

public class Ranking {

    String playerName;
    Integer rank;

    public Ranking(){}

    public Ranking(String name, Integer rank){
        this.playerName = name;
        this.rank = rank;
    }

    public String getName() {
        return playerName;
    }

    public Integer getRank() {
        return rank;
    }
}
