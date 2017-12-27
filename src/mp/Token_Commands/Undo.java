package mp.Token_Commands;

import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.UndoInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Undo"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 

public class Undo extends Word implements UndoInterface{

	
	public Undo(String s) {
		super(s);
	}
	
}
