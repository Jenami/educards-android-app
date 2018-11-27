package educards.educards_model;

public class RankingModel {

    String playerName;
    Integer rank;

    public RankingModel(){}

    public RankingModel(String name, Integer rank){
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
