package edu.ktlab.nlp.pos;

import java.util.List;

import opennlp.tools.postag.POSSample;
import opennlp.tools.util.InvalidFormatException;

public class POSSampleExtend extends POSSample{
	public POSSampleExtend(String sentence[], String tags[]) {
		super(sentence, tags);
	}

	public POSSampleExtend(List<String> sentence, List<String> tags) {
		super(sentence, tags);
	}
	
	public static POSSample parse(String sentenceString, String regex)
			throws InvalidFormatException {

		String tokenTags[] = sentenceString.split(regex);

		String sentence[] = new String[tokenTags.length];
		String tags[] = new String[tokenTags.length];

		for (int i = 0; i < tokenTags.length; i++) {
			int split = tokenTags[i].lastIndexOf("/");

			if (split == -1) {
				throw new InvalidFormatException(
						"Cannot find \"_\" inside token!");
			}

			sentence[i] = tokenTags[i].substring(0, split);
			tags[i] = tokenTags[i].substring(split + 1);
		}

		return new POSSample(sentence, tags);
	}
	
	public static POSSample parse(String sentenceString, String regex, String character)
			throws InvalidFormatException {

		String tokenTags[] = sentenceString.split(regex);

		String sentence[] = new String[tokenTags.length];
		String tags[] = new String[tokenTags.length];

		for (int i = 0; i < tokenTags.length; i++) {
			int split = tokenTags[i].lastIndexOf(character);

			if (split == -1) {
				throw new InvalidFormatException(
						"Cannot find \"_\" inside token!");
			}

			sentence[i] = tokenTags[i].substring(0, split);
			tags[i] = tokenTags[i].substring(split + 1);
		}

		return new POSSample(sentence, tags);
	}	
}
