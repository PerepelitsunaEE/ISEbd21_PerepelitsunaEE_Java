import java.awt.Color;
import java.awt.Graphics;

public interface IBoat {

	void SetPosition(int x, int y, int width, int height);
	void MoveTransport(Direction direction);
	void DrawSail(Graphics g);
	void setMainColor(Color color);
}
