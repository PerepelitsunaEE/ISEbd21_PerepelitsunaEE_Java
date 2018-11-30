import java.awt.Color;
import java.awt.Graphics;


public class Boat {
    private int _startPosX;
    private int _startPosY;
    
    private int _pictureWidth;
    private int _pictureHeight;
    
    private final static int boatWidth = 100;
    private final static int boatHeight = 60;
    
    public int MaxSpeed;
    public int getMaxSpeed() {
		return MaxSpeed;
	}
    public void setMaxSpeed(int value) {
		MaxSpeed = value;
	}
    
    public float Weight;
    public float getWeight() {
		return Weight;
	}

	public void setWeight(float value) {
		Weight = value;
	}
	
    public Color MainColor;
    public Color getMainColor() {
		return MainColor;
	}

	public void setMainColor(Color value) {
		MainColor = value;
	}
	
    public Color DopColor;
    public Color getDopColor() {
		return DopColor;
	}

	public void setDopColor(Color value) {
		DopColor = value;
	}
	
    public boolean RightSail;
    public boolean LeftSail;
    
    public Boat (int maxSpeed, float weight, Color mainColor, Color dopColor, boolean rightSail, boolean leftSail)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        RightSail = rightSail;
        LeftSail = leftSail;
    }
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
        
    }
    public void MoveBoat(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Right:
                if (_startPosX + step < _pictureWidth - boatWidth)
                {
                    _startPosX += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - boatHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    public void DrawBoat(Graphics g)
    {
    	g.setColor(MainColor);
        g.drawLine(_startPosX + 20, _startPosY + 60, _startPosX + 70, _startPosY + 60);
        g.drawLine(_startPosX, _startPosY +  40, _startPosX + 90, _startPosY + 40);
        g.drawLine(_startPosX + 20, _startPosY + 60, _startPosX, _startPosY + 40);
        g.drawLine(_startPosX + 70, _startPosY + 60, _startPosX + 90, _startPosY + 40);
        
        if (RightSail)
        {
        	g.setColor(DopColor);
        	g.drawLine(_startPosX + 45, _startPosY + 40, _startPosX + 45, _startPosY);
            g.drawLine(_startPosX + 45, _startPosY, _startPosX + 70, _startPosY + 40);
        }
        if (LeftSail)
        {
        	g.setColor(DopColor);
            g.drawLine(_startPosX + 45, _startPosY + 40, _startPosX + 45, _startPosY);
            g.drawLine(_startPosX + 45, _startPosY, _startPosX + 20, _startPosY + 40);
        }
    }

}
