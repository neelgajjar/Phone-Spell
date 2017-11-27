import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class InputFileProcessor {
	
	private PhoneWordProcessor phoneWordProcessor;

	public InputFileProcessor(PhoneWordProcessor phoneWordProcessor) {
		this.phoneWordProcessor = phoneWordProcessor;
	}

	public void processFile(final String filePath) {
		System.out.println("READING FILE : " + filePath);
		try {
			try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
				while (scanner.hasNext()) {
					phoneWordProcessor.process(scanner.nextLine());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found  " + filePath );
		}
	}
}
