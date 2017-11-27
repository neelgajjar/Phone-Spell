import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {

	private Map<Integer, Set<String>> wordMap;

	public Dictionary(Map<Integer, Set<String>> wordMap) {
		this.wordMap = wordMap;
	}
	
	private Set<String> findWord(String number) {
		Set<String> phoneWords = new HashSet<String>();
		try {
			phoneWords = findWord(Integer.parseInt(number));
		} catch (NumberFormatException nfe) {
		}
		return phoneWords;
	}
	
	public Set<String> findMatch(Integer number) {
		final Set<String> matches = new HashSet<>();
		if (number == null) {
			return matches;
		}
		if(wordMap.containsKey(number)) {
			return PhoneWordFormatterUtils.getPhoneWords(wordMap.get(number));
		}
		return matches;
	}
	
	
	public Set<String> findWord(Integer number) {
		final Set<String> matches = new HashSet<>();
		if (number == null) {
			return matches;
		}
		if(wordMap.containsKey(number)) {
			return wordMap.get(number);
		}
		return matches;
	}

	public Set<String> findFuzzyMatch(Integer number) {
		final Set<String> matches = new HashSet<>();
		if (number == null) {
			return matches;
		}
		final String stringNumber = String.valueOf(number);
		for (int i = 1; i < stringNumber.length(); i++) {
			final Set<String> leftPartWords = encodeLeftPart(i, stringNumber);
			if (!PhoneWordFormatterUtils.hasValues(leftPartWords)) {
				continue;
			}
			matches.addAll(encodeWordWord(leftPartWords, i, stringNumber));
			matches.addAll(encodeWordDigitWord(leftPartWords, i, stringNumber));
		}
		matches.addAll(encodeDigitWord(stringNumber));
		return matches;
	}

	private Set<String> encodeLeftPart(int rightIndex, final String number) {
		return findWord(number.substring(0, rightIndex));
		
	}
	private Set<String> encodeWordWord(Set<String> leftPartWords, int rightIndex, final String number) {
		return PhoneWordFormatterUtils.getPhoneWords(leftPartWords, findWord(number.substring(rightIndex)));
	}
	
	private Set<String> encodeDigitWord(final String number) {
		return PhoneWordFormatterUtils.getPhoneWords(number.charAt(0), findWord(number.substring(1)));
	}
	
	private Set<String> encodeWordDigitWord(final Set<String> leftPartWords, int rightIndex, final String number){
		final char digit = number.charAt(rightIndex);
		if (rightIndex == (number.length() - 1)) {
			return PhoneWordFormatterUtils.getPhoneWords(leftPartWords, digit);
		} else {
			return PhoneWordFormatterUtils.getPhoneWords(leftPartWords, digit,
					findWord(number.substring(rightIndex + 1)));
		}
	}

}
