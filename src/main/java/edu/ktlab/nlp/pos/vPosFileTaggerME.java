package edu.ktlab.nlp.pos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

public class vPosFileTaggerME {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
				"data/Testset-POS-raw/800001.seg"), "UTF-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
				"data/Testset-POS-raw/800001.pos"), "UTF-8"));
		InputStream in = new FileInputStream("models/POS/vn.model");
		POSModel posModel = new POSModel(in);
		// posModel = new POSModel(in);

		POSTagger tagger = new POSTaggerME(posModel);

		String line = "";
		while ((line = reader.readLine()) != null) {
			if (line.trim().length() == 0)
				continue;
			String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(line);
			String[] tags = tagger.tag(tokens);

			for (int i = 0; i < tokens.length - 1; i++)
				writer.write(tokens[i] + "/" + tags[i] + " ");
			writer.write(tokens[tokens.length - 1] + "/" + tags[tokens.length - 1] + "\n");
		}
		reader.close();
		writer.close();
		in.close();
	}

}
