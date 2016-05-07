package utils;

import java.util.Random;

public class NameGenerator {
	
	private static String namePart[] = {
			"a", "aa", "ab", "aber", "ac", "acc", "ack", "afon", "an", "and", "ant", "ar", "ard", "ash", "ast", "avon", "auch", "auchter", "axe", "ay",
			"ba", "bal", "ball", "balla", "bally", "be", "beann", "beck", "ben", "bein", "berg", "berry", "bex", "bi", "bio", "bost", "bourne", "burn",
			"can", "cap", "ce", "chrom", "chron", 
			"da", "di", "dict", "dis", "dom", "dor",
			"e", "ed", "en", "ent", "er", "ess", "eth", "ex", 
			"fa", "fer", 
			"gen", "geo", "gre", 
			"ho", "hut", 
			"i", "ian", "in", "ine", "io", "ist", "ize", 
			"ja", "jak", "ject", 
			"ka", "kaa", "kel", "kes", "ku",
			"la", "lia", "luc", "luk", 
			"mal", "mi", "mis", 
			"nal", "neo", 
			"o", "oo", "ol", "or", 
			"phi", "phil", "pos", 
			"que",
			"ra", "raa", "rab", "ran", "rol", "ry",
			"so", "spec", 
			"tat", "ti", 
			"u", "up", "ur", 
			"vac", "ve", "ven", "ver", 
			"wa", "wes", "whel", "wick", "win", "worth", 
			"xan", "xi", "xor",
			"ya", "yel", "yen", "yor",
			"za", "ze", 
	};
	
	public static String generateName(int permutations, long seed) {
		Random random = new Random(seed);
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < permutations; i++) {
			s.append(namePart[random.nextInt(namePart.length)]);
		}
		return s.toString();
	}

}
