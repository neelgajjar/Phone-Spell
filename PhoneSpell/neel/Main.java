
public class Main {
	
	public static void main(String[] args) {		
		
		PhoneWordProcessor phoneWordProcessor = new PhoneWordProcessor(new Dictionary(new DictionaryReader().loadDictionary()));
		
		phoneWordProcessor.process("1-800-2255.63");
		phoneWordProcessor.process("2255.63");
		phoneWordProcessor.process("27753");
		phoneWordProcessor.process("52696");
		phoneWordProcessor.process("8378");
		phoneWordProcessor.process("8278");
		

		
	}

}
