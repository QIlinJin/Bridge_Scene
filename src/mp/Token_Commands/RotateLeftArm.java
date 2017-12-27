package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.RotateLeftArmI;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"RotateLeftArm"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class RotateLeftArm extends Word implements RotateLeftArmI {

	
	public RotateLeftArm(String s) {
		super(s);
	}
	
}
