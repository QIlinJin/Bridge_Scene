package mp.BridgeScene_Atomic;

import java.beans.PropertyChangeEvent;

import mp.BridgeScene_Atomic_Interfaces.BoundedShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
@Tags ({"BoundedShape"})
public abstract class ABoundedShape extends ALocatable implements BoundedShape,PropertyListenerRegisterer{
	int width, height;
	public int getWidth() {return width;}
    
    public int getHeight() {return height;}
    
    @Override
	public void setWidth(int newVal) {
		int oldVal = getWidth();
		width=newVal;
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal,
				newVal));
	}
	
	@Override
	public void setHeight(int newVal) {
		int oldVal = getHeight();
		height=newVal;
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal,
				newVal));
	}
}
