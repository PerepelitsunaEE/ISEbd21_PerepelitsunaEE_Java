import java.awt.Color;
import java.awt.Graphics;

public class Sail extends SimpleSail{
	
    protected final int boatWidth = 100;
    protected final int boatHeight = 60;
    
    public Sail(int maxSpeed, float weight, Color mainColor)
    {
        __MaxSpeed = maxSpeed;
        __Weight = weight;
        __MainColor = mainColor;
    }
    
    public Color DopColor;
    public Color getDopColor() {
		return DopColor;
	}

	public void setDopColor(Color value) {
		DopColor = value;
	}
	
    public boolean RightSail;
    public boolean getRightSail (){
    	return RightSail;
    }
    public boolean LeftSail;
    public boolean getLeftSail (){
    	return LeftSail;
    }
    
    @Override
    public void MoveTransport(Direction direction)
    {
        float step = __MaxSpeed * 100 / __Weight;
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
                if (_startPosY - step > 25)
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
    @Override
    public void DrawSail(Graphics g)
    {
    	g.setColor(getMainColor());
        g.drawLine((int)_startPosX + 20,(int) _startPosY + 60, (int)_startPosX + 70, (int)_startPosY + 60);
        g.drawLine((int)_startPosX, (int)_startPosY +  40, (int)_startPosX + 90, (int)_startPosY + 40);
        g.drawLine((int)_startPosX + 20, (int)_startPosY + 60, (int)_startPosX, (int)_startPosY + 40);
        g.drawLine((int)_startPosX + 70, (int)_startPosY + 60, (int)_startPosX + 90, (int)_startPosY + 40);
    }

}
