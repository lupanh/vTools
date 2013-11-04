package edu.ktlab.nlp.pos.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;

public class NewChunkTrainingGenerating {
	public static void main(String[] args) throws Exception {
		InputStream inPos = new FileInputStream("models/POS/vi-pos.model");
		POSModel posModel = new POSModel(inPos);

		POSTagger tagger = new POSTaggerME(posModel);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
				"data/Chunk/vi-chunker_new.train"), "UTF-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
				"data/Chunk/vi-chunker_new2.train"), "UTF-8"));
		List<String> sentenceTokens = new ArrayList<String>();
		List<String> sentenceChunktags = new ArrayList<String>();
		String line = "";
		while ((line = reader.readLine()) != null) {
			if (line.contains("T*") || line.contains("*T") || line.contains("*E") || line.contains("E*") || line.contains("LBKT") || line.contains("RBKT")) continue;
			System.out.println(line);
			if (line.trim().equals("")) {
				List<String> tags = tagger.tag(sentenceTokens);
				for (int i = 0; i < tags.size(); i++) {
					if (sentenceChunktags.get(i).equals("O") && i < tags.size() - 1)
						sentenceChunktags.set(i + 1, sentenceChunktags.get(i + 1).replace("I-", "B-"));
					writer.write(sentenceTokens.get(i) + " " + tags.get(i) + " " + sentenceChunktags.get(i) + "\n");
				}
					
				writer.write("\n");
				sentenceTokens = new ArrayList<String>();
				sentenceChunktags = new ArrayList<String>();
			} else {
				String[] segs = line.split(" ");
				sentenceTokens.add(segs[0]);
				sentenceChunktags.add(segs[2]);	
			}
			
		}
		reader.close();
		writer.close();
		
	}

}
