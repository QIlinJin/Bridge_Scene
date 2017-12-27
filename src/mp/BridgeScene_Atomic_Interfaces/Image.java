package mp.BridgeScene_Atomic_Interfaces;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"BoundedShape"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
public interface Image extends BoundedShape{
	
    public String getImageFileName() ;  
    public void setImageFileName(String newVal);
   
}
