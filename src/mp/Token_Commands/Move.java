package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.MoveInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Move"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})

public class Move extends Word implements MoveInterface{
	
	public Move(String s) {
		super(s);
	}
	
}
