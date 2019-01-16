
import java.util.ArrayList;

public class MultiLevelPort {

	ArrayList<Port<IBoat>> parkingStages;

	private final int countPlaces = 15;
	int currentLevel;

	public MultiLevelPort(int countStages, int pictureWidth, int pictureHeight) {
		parkingStages = new ArrayList<Port<IBoat>>();
		for (int i = 0; i < countStages; ++i) {
			parkingStages.add(new Port<IBoat>(countPlaces, pictureWidth, pictureHeight));
		}
	}

	public Port<IBoat> getAt(int index) {
		if (index > -1 && index < parkingStages.size()) {
			return parkingStages.get(index);
		}
		return null;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void levelUp() {
		if (currentLevel + 1 < parkingStages.size())
			currentLevel++;
	}

	public void levelDown() {
		if (currentLevel > 0)
			currentLevel--;
	}
}
