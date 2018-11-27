package educards.educards_model;

public class RankingAPI {

    Integer id;
    Integer rank;

    public RankingAPI(){}

    public RankingAPI(Integer id, Integer rank){
        this.id = id;
        this.rank = rank;
    }

    public Integer getIdPlayer() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }
}
