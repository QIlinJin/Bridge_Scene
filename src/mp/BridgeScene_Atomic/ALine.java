package mp.BridgeScene_Atomic;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
import mp.BridgeScene_Atomic_Interfaces.Line;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
@StructurePattern(StructurePatternNames.LINE_PATTERN) 
@Tags ({"BoundedShape"})
public class ALine extends ABoundedShape implements Line,PropertyListenerRegisterer {
	
    //Location location;
	
    public ALine (int initX, int initY, int initWidth, int initHeight) {
    	x=initX;
    	y=initY;
    	width=initWidth;
    	height=initHeight;    
    }
    
	
    @Tags({"rotate"})
	public void rotate (int units) {
		double Angle;
    		if(height/width<0) {
			Angle = Math.atan((double) height/width)+Math.PI/(2*units);
		}
		else {
			Angle = Math.atan((double) height/width)-Math.PI/(2*units)-Math.PI;
		}
		//double Angle = Math.atan((double) height/width)+Math.PI/(2*units);
		double Radius = Math.sqrt(width*width+height*height);
		//this.Width = radius*Math.cos(angle);
		//this.Height = radius*Math.sin(angle);
		
		this.setWidth(((int)((int)Radius*Math.cos(Angle))));
		this.setHeight(((int)((int)Radius*Math.sin(Angle))));
		
		
	}

}