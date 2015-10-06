import java.util.ArrayList;
import java.util.List;

/**
 *
 */

/**
 * @author espunkid
 *
 */
public final class NumberCreation
{
	public static int createNumberFrom(int first, int second)
	{
		int result = 0;

		if ((first == 0) && (second == 0))
		{
			System.out.println("Impossible to create a new larger number from zeros");
			return -1;
		}
		List<Integer> firstList = new ArrayList<Integer>();
		List<Integer> secondList = new ArrayList<Integer>();
		while ((first != 0) && (second != 0))
		{
			firstList.add(first % 10);
			secondList.add(second % 10);

			first /= 10;
			second /= 10;
		}
		int j = secondList.size() - 1;
		for (int i = 0; i < firstList.size(); ++i)
		{
			if (firstList.get(i) > secondList.get(j))
			{
				// the larger digit was found at the end of the ArrayList
				if (i == (firstList.size() - 1))
				{
					// TODO:iterate to the front and creating a new integer consisting of this number
				}
				// the larger digit was found at the start of the ArrayList
				else if (i == 0)
				{
					// TODO:iterate to the back
				}
				// the larger digit was found at some random spot in the ArrayList
				else
				{
					// TODO:pick some random way of creating this number
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		createNumberFrom(98900, 73252);

	}

}
