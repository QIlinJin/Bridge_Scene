package mp.BridgeScene_Atomic_Interfaces;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"BoundedShape"})
@StructurePattern(StructurePatternNames.LINE_PATTERN) 
@PropertyNames({"x", "y","width","height"}) 
@EditablePropertyNames({"x","y","width","height"})
public interface Line extends BoundedShape {
	
    public void rotate(int unit);
}
