package educards.educards_model;

import java.util.ArrayList;
import java.util.List;

public class PointsPlayer {
	
	List<Integer> points = new ArrayList<>();
	
	public PointsPlayer(List<Integer> list) {
	    points = list;
    }

	public List<Integer> getPoints() {
		return points;
	}
}