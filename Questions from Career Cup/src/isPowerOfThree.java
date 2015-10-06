/**
 *
 */

/**
 * @author espunkid
 *
 */
public abstract class isPowerOfThree
{
	public static int isPowerOfThree(long number)
	{
		double answer = Math.log10(number) / Math.log10(3);
		if ((answer - (int) (answer)) == 0.0) // checks to make sure a whole number was attained
		{
			return 1;
		} else
		{
			return 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(42));
		System.out.println(isPowerOfThree(0));

	}

}
