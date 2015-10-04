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
	public static boolean isEmpty(String word)
	{
		if (word.length() == 0)
		{
			return false;
		}

		return true;
	}

	public static boolean isUniqueUsingHashMap(String word)
	{
		if (!isEmpty(word))
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

	public static boolean isUniqueUsingArrays(String word)
	{
		if (!isEmpty(word))
		{
			System.out.println("Empty String :(");
			return false;

		} else
		{
			char[] letters = word.toCharArray();
			for (int i = 0; i < letters.length; ++i)
			{
				for (int j = i + 1; j < letters.length; ++j)
				{
					if (letters[i] == letters[j])
					{
						return false;
					}
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
		System.out.println(isUniqueUsingHashMap(""));
		System.out.println(isUniqueUsingArrays(""));

		System.out.println();

		System.out.println("Normal Case");
		System.out.println(isUniqueUsingHashMap("Yes"));
		System.out.println(isUniqueUsingArrays("Yes"));

		System.out.println();

		System.out.println(isUniqueUsingHashMap("Noo"));
		System.out.println(isUniqueUsingArrays("Noo"));
	}

}
