package mp.Token_Commands;

import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.RedoInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Redo"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})
public class Redo extends Word implements RedoInterface{

	
	public Redo(String s) {
		super(s);
	}
	
}
