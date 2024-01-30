
public class SpellChecker
{


	public static void main(String[] args) 
	{		
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) 
	{
		if (str.length()==0)
		{
			return " ";
		}
		else return str.substring(1, str.length());
	}

	public static int levenshtein(String word1, String word2) 
	{
		int lev = 0;
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word1.isEmpty())
		{
			lev = word2.length();
		}
		else if (word2.isEmpty())
		{
			lev =  word1.length();
		}
		else if (word1.charAt(0)==word2.charAt(0))
		{
			lev = levenshtein(tail(word1), tail(word2));
		}
		else 
		{
			lev = 1 + Math.min(levenshtein(tail(word1), tail(word2)), Math.min(levenshtein(tail(word1), word2), levenshtein(word1, tail(word2))));
		}
		return lev;
	}

	public static String[] readDictionary(String fileName) 
	{
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i=0; i<3000; i++)
		{
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) 
	{
		int lev;
		int min = 0;
		int minlev = threshold  + 1;
		boolean found = false;
		for (int i=0; i < dictionary.length ; i++)
		{
			if (dictionary[i].equals(word))
			{
				return word;
			}
			lev = levenshtein(word, dictionary[i]);
			if (lev <= threshold)
			{
				found = true;
				if (lev < minlev)
				{
					min = i;
					minlev = lev;
				}
			}
			
		}
		if (found)
		{
			return dictionary[min];
		}	
		return word;
	}

}
