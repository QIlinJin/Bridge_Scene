package mp.BridgeScene_Atomic;
import java.beans.PropertyChangeEvent;

import mp.BridgeScene_Atomic_Interfaces.StringShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@Tags ({"Locatable"})
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
public class AStringShape extends ALocatable implements StringShape,PropertyListenerRegisterer{
	String text;
	

	public AStringShape(String initText, int initX, int initY) {
		text = initText;
		x = initX;
		y = initY;
	}
	
	public String getText() {return text;}
	public void setText(String newVal) {
		String oldname = getText();
		text = newVal;
		notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldname,
				newVal));}

	

}
