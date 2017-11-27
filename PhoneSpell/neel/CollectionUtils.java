import java.util.Collection;

public class CollectionUtils {

	public static boolean isNotEmpty(Collection obj) {
		return obj != null && obj.size() != 0;
	}
}
