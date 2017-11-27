import java.util.Arrays;
import java.util.Scanner;

public class PhoneWordLauncher {

	private static final String QUIT = "quit";

	public static void main(String[] args) {
		new PhoneWordLauncher().start(args);
	}

	private void start(String[] args) {
		PhoneWordProcessor phoneWordProcessor = new PhoneWordProcessor(
				new Dictionary(new DictionaryReader().loadDictionary()));
		if (args == null || args.length == 0) {
			Scanner scanner = new Scanner(System.in);
			boolean readInput = true;
			while (readInput) {
				System.out.println("ENTER PHONE NUMBER TO FIND MNEMONICS || **TYPE quit TO EXIT**");
				String number = scanner.nextLine();
				if (QUIT.equals(number)) {
					readInput = false;
				} else {
					phoneWordProcessor.process(number);
				}
			}
			scanner.close();
		} else {
			InputFileProcessor inputFileReader = new InputFileProcessor(phoneWordProcessor);
			System.out.println("Files to process: " + Arrays.toString(args));
			for (String file : args) {
				inputFileReader.processFile(file);
			}
		}
	}
}
