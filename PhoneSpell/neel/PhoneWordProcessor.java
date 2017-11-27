import java.util.Set;

public class PhoneWordProcessor {
	
	private PhoneWordMatcher phoneWordMatcher;
	public PhoneWordProcessor(final Dictionary dictionary) {
		this.phoneWordMatcher = new PhoneWordMatcher(dictionary);
	}
	
	public void process(final String strNumber) {
		Set<String> encodedNumbers = phoneWordMatcher.match(StringUtils.cleanInput(strNumber));
		if(CollectionUtils.isNotEmpty(encodedNumbers)) {
			printEncodedPhoneNumbers(strNumber, encodedNumbers);
		}else {
			System.out.println("No Match Found for Number : " + strNumber );
		}
		
	}
	
	private void printEncodedPhoneNumbers(String number, final Set<String> encodedNumbers) {
		System.out.println("Match Found for Number : " + number);
		encodedNumbers.forEach(System.out::println);
	}
}