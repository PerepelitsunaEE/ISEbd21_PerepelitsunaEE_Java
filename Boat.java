import java.awt.Color;
import java.awt.Graphics;

public class Boat extends Sail{

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
    
    public Boat (int maxSpeed, float weight, Color mainColor, Color dopColor, boolean rightSail, boolean leftSail)
    {	super(maxSpeed, weight, mainColor);    
        __MaxSpeed = maxSpeed;
        __Weight = weight;
        __MainColor = mainColor;
        DopColor = dopColor;
        RightSail = rightSail;
        LeftSail = leftSail;
    }
    public void DrawSail(Graphics g)
    {
        super.DrawSail(g);
        if (RightSail)
        {
        	g.setColor(DopColor);
        	g.drawLine((int)_startPosX + 45, (int)_startPosY + 40,(int) _startPosX + 45, (int)_startPosY);
            g.drawLine((int)_startPosX + 45, (int)_startPosY, (int)_startPosX + 70, (int)_startPosY + 40);
        }
        if (LeftSail)
        {
        	g.setColor(DopColor);
            g.drawLine((int)_startPosX + 45, (int)_startPosY + 40, (int)_startPosX + 45, (int)_startPosY);
            g.drawLine((int)_startPosX + 45, (int)_startPosY, (int)_startPosX + 20, (int)_startPosY + 40);
        }
    }

}
