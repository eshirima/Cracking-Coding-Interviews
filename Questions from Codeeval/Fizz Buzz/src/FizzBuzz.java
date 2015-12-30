import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 */

/**
 * @author Bonaparte
 *
 */
public class FizzBuzz
{
	public static void fizzBuzz(int firstDivider, int secondDivider, int count)
	{
		for (int i = 1; i <= count; i++)
		{
			// From congruence theorems, if x=0(Mod m) and x=0(Mod n) then
			// x=0(Mod mn)
			if ((i % Math.multiplyExact(firstDivider, secondDivider)) == 0)
			{
				System.out.print("FB ");
			} else if ((i % firstDivider) == 0)
			{
				System.out.print("F ");
			} else if ((i % secondDivider) == 0)
			{
				System.out.print("B ");
			} else
			{
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		try
		{
			File file = new File("Test Cases");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				System.out.println(line);
				String[] lineParts = line.split(" ");
				fizzBuzz(Integer.parseInt(lineParts[0]),
						Integer.parseInt(lineParts[1]),
						Integer.parseInt(lineParts[2]));
			}
			fileReader.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
