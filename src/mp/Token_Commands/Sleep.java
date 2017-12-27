package mp.Token_Commands;

import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.SleepInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Sleep"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class Sleep extends Word implements SleepInterface{

	public Sleep(String s) {
		super(s);
	}
	
}
