import java.util.HashSet;
import java.util.Set;

public class PhoneWordFormatterUtils {

	public static boolean hasValues(final Set<String> words) {
		return words != null && !words.isEmpty();
	}

	public static boolean hasValues(final Set<String> leftWordParts, final Set<String> rightWordParts) {
		return hasValues(leftWordParts) && hasValues(rightWordParts);
	}

	public static Set<String> getPhoneWords(final Set<String> leftWordParts, final char midChar,
			final Set<String> rightWordParts) {
		final Set<String> phoneWords = new HashSet<>();
		if (hasValues(leftWordParts, rightWordParts)) {
			for (final String leftWord : leftWordParts) {
				for (final String rightWord : rightWordParts) {
					phoneWords.add(StringUtils.appendTollFreePrifix(leftWord, String.valueOf(midChar), rightWord));
				}
			}
		}
		return phoneWords;
	}

	public static Set<String> getPhoneWords(final char number, final Set<String> words) {
		final Set<String> phoneWords = new HashSet<>();
		if (hasValues(words)) {
			for (final String word : words) {
				phoneWords.add(StringUtils.appendTollFreePrifix(String.valueOf(number), word));
			}
		}
		return phoneWords;
	}

	public static Set<String> getPhoneWords(final Set<String> words) {
		final Set<String> phoneWords = new HashSet<>();
		if (hasValues(words)) {
			words.stream().map(StringUtils::appendTollFreePrifix).forEach(phoneWords::add);
		}
		return phoneWords;
	}

	public static Set<String> getPhoneWords(final Set<String> leftWordParts, final Set<String> rightWordParts) {
		final Set<String> phoneWords = new HashSet<>();
		if (hasValues(leftWordParts, rightWordParts)) {
			for (final String leftWord : leftWordParts) {
				for (final String rightWord : rightWordParts) {
					phoneWords.add(StringUtils.appendTollFreePrifix(leftWord, rightWord));
				}
			}
		}
		return phoneWords;
	}

	public static Set<String> getPhoneWords(final Set<String> words, final char number) {
		final Set<String> phoneWords = new HashSet<>();
		if (hasValues(words)) {
			for (final String word : words) {
				phoneWords.add(StringUtils.appendTollFreePrifix(word, String.valueOf(number)));
			}
		}
		return phoneWords;
	}

}
