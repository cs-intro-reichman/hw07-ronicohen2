
public class SpellChecker
{


	public static void main(String[] args) 
	{
		String word1 = "hello";
		String word2 = "hell";
		System.out.println(levenshtein(word1, word2));
		//String word = args[0];
		//int threshold = Integer.parseInt(args[1]);
		//String[] dictionary = readDictionary("dictionary.txt");
		//String correction = spellChecker(word, threshold, dictionary);
		//System.out.println(correction);//
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

		// Your code here

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) 
	{
		// Your code goes here
		return word;
	}

}
