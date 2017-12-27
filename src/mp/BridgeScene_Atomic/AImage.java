package mp.BridgeScene_Atomic;
import java.beans.PropertyChangeEvent;

import mp.BridgeScene_Atomic_Interfaces.Image;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
@Tags ({"BoundedShape"})
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class AImage extends ABoundedShape implements Image,PropertyListenerRegisterer {
	 String imageFileName;
     
     public AImage (String initImageFileName, int initX, int initY, int initWidth, int initHeight) {	
    	 	imageFileName = initImageFileName;
   
    	 	x = initX;
    	 	y = initY;    
    	 	height = initHeight;
    	 	width = initWidth;
     	}          
   
    public String getImageFileName() {return imageFileName;}  
    public void setImageFileName(String newVal) {
    		String oldname = getImageFileName();
    		imageFileName = newVal;
    		notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldname,
    				newVal));
    		
    		
    	}     

}
