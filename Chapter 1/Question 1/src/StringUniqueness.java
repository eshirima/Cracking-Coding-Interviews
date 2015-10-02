import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/**
 * @author espunkid
 *
 */
public final class StringUniqueness
{

	public static boolean isUnique(String word)
	{
		if (word.length() == 0)
		{
			System.out.println("Empty String :(");
			return false;
		} else
		{
			char[] stringCharacters = word.toCharArray();
			Set<Character> set = new HashSet<Character>();

			for (char letters : stringCharacters)
			{
				if (set.contains(letters))
				{
					return false;
				} else
				{
					set.add(letters);
				}
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Extreme Case");
		System.out.println(isUnique(""));

		System.out.println();

		System.out.println("Normal Case");
		System.out.println(isUnique("Yes"));

	}

}
