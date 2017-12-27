package mp.BridgeScene_Atomic;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mp.BridgeScene_Atomic_Interfaces.Locatable;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
@PropertyNames({"x", "y"}) 
@EditablePropertyNames({"x","y"})
@Tags ({"Locatable"})
public abstract class ALocatable implements Locatable, PropertyListenerRegisterer{
	
	
	
	List<PropertyChangeListener> contents = new ArrayList<>();

	public void notifyAllListeners(PropertyChangeEvent event) {
		Iterator<PropertyChangeListener> it = contents.iterator();
		while(it.hasNext()) {
			it.next().propertyChange(event);
		}
		
		
	}
	int x,y;
	public int getX() {return x;}
	
	public int getY() {return y;}
	@Override
	public void setX(int newVal) {
		int oldVal = getX(); // save old value of X
		x=newVal; // change x
		
		// put breakpoint here and step into notifyAllListeners
		notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal,
				newVal));
	}
    @Override
	public void setY(int newVal) {
		int oldVal = getY();
		y=newVal;
		notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal,
				newVal));
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub
		contents.add(l);
	}
	public void add(PropertyChangeListener l) {
		contents.add(l);
	}
}
