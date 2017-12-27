package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.RotateRightArmI;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"RotateRightArm"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class RotateRightArm extends Word implements  RotateRightArmI{

	public RotateRightArm(String s) {
		super(s);
	}
	
}

