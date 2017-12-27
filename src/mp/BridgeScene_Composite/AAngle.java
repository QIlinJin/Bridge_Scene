package mp.BridgeScene_Composite;
import java.beans.PropertyChangeListener;

import mp.BridgeScene_Atomic.ALine;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Composite_Interfaces.Angle;
import util.annotations.Tags;
@Tags ({"Angle"})
public class AAngle implements Angle {
	Line LeftLine;
	Line RightLine;
	
	int defalut_X = 30;
	int default_Y = 20;
	int default_Width = 10;
	int default_Height = 10;
	
	public AAngle() {
		LeftLine = new ALine(defalut_X,default_Y,default_Width,default_Height);
		RightLine = new ALine(defalut_X,default_Y,-default_Width,default_Height);
	}
	
	public AAngle(int x, int y) {
		LeftLine = new ALine(x, y, default_Width, default_Height);
		RightLine = new ALine(x, y, -default_Width, default_Height);
	}
	
	public AAngle(Line l1, Line l2) {
		LeftLine =l1;
		RightLine = l2;
	}
	
	@Override
	public Line getLeftLine() {
		// TODO Auto-generated method stub
		return LeftLine;
	}

	@Override
	public Line getRightLine() {
		// TODO Auto-generated method stub
		return RightLine;
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		LeftLine.setX(LeftLine.getX()+x);
		LeftLine.setY(LeftLine.getY()+y);
		RightLine.setX(RightLine.getX()+x);
		RightLine.setY(RightLine.getY()+y);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub
		this.LeftLine.addPropertyChangeListener(l);;;
		this.RightLine.addPropertyChangeListener(l);
	}
}
