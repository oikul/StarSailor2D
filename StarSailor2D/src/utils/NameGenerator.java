package utils;

import java.util.Random;

public class NameGenerator {
	
	private static String namePart[] = {
			"a", "aa", "ab", "aber", "ac", "acc", "ack", "afon", "an", "and", "ant", "ar", "ard", "ash", "ast", "avon", "auch", "auchter", "axe", "ay",
			"ba", "bal", "ball", "balla", "bally", "be", "beann", "beck", "ben", "bein", "berg", "berry", "bex", "bi", "bio", "bost", "bourne", "burn",
			"can", "cap", "ce", "chrom", "chron", 
			"da", "di", "dict", "dis", "dom", "dor",
			"e", "ed", "en", "ent", "er", "ess", "eth", "ex", 
			"fa", "fer", "fid", "flect", "flor", "fleur", "for", "fract", 
			"gastro", "gen", "geo", "giga", "gre", "gyn",
			"hect", "helic", "helio", "hemi", "hex", "ho", "hut", "hydr", "hyp", 
			"i", "ian", "in", "ine", "io", "ist", "ize", 
			"ja", "jak", "ject", "jud", "juven", 
			"ka", "kaa", "kel", "kes", "kilo", "kine", "ku",
			"la", "lab", "leuk", "lex", "lia", "lib", "lite", "loc", "loqu", "luc", "luk", "lumin", "lun", 
			"macro", "magn", "mal", "mar", "max", "mi", "mis", 
			"nal", "narr", "nat", "nav", "necro", "neg", "neo", "nephr", "neur", 
			"o", "oct", "ocu", "omni", "oo", "ol", "or", "oxi", 
			"pale", "pan", "para", "per", "phag", "phi", "phil", "plas", "poli", "pos", "pyr", 
			"quad", "quart", "quin", "que",
			"ra", "raa", "rab", "ran", "rol", "ry",
			"san", "so", "spec", 
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
