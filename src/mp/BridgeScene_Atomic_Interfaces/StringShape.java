package mp.BridgeScene_Atomic_Interfaces;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"x", "y"}) 
@EditablePropertyNames({"x","y",})
public interface StringShape extends Locatable{

	public String getText();
	public void setText(String newText);
}
