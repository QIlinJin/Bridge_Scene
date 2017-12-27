package mp.BridgeScene_Composite_Interfaces;

import java.beans.PropertyChangeListener;

import mp.BridgeScene_Atomic_Interfaces.Line;
import util.annotations.Tags;
@Tags ({"Angle"})
public interface Angle {
	
	public Line getLeftLine();
	public Line getRightLine();
	public void move(int x, int y);
	public void addPropertyChangeListener(PropertyChangeListener l);
}
