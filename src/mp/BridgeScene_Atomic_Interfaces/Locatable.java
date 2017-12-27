package mp.BridgeScene_Atomic_Interfaces;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
@PropertyNames({"x", "y"}) 
@EditablePropertyNames({"x","y"})
@Tags ({"Locatable"})
public interface Locatable {
	public int getX();
	public void setX(int newX);
	public int getY();
	public void setY(int newY);
	public void notifyAllListeners(PropertyChangeEvent event);
	public void addPropertyChangeListener(PropertyChangeListener l);
	public void add(PropertyChangeListener l);
}
