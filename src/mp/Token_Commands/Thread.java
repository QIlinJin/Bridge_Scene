package mp.Token_Commands;
import mp.Token_Basic.Word;
import mp.Token_Commands_Interfaces.ThreadInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Thread"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input", "Value"}) 
@EditablePropertyNames({"Input"})

public class Thread extends Word implements ThreadInterface {

		public String Input;
		
		public Thread(String s) {
			super(s);
		}
		public void setInput(String inputt) {
			this.Input = inputt;
		}
		public String getInput() {
			return Input;
		}
		
		
	}


