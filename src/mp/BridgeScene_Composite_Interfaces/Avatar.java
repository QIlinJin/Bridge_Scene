package mp.BridgeScene_Composite_Interfaces;
import java.beans.PropertyChangeListener;

import mp.BridgeScene_Atomic_Interfaces.Image;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Atomic_Interfaces.StringShape;
import util.annotations.Tags;
@Tags ({"Avatar"})
public interface Avatar {
	public Line getBody();
	public StringShape getStringShape();	
	public Image getHead();
	public Angle getArms();
	public Angle getLegs();
	public void move(int x, int y);
	public void rotatingArms(int unit);
	public void scale(double x);
	public void addPropertyChangeListener(PropertyChangeListener l);
}
