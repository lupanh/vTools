package edu.ktlab.nlp.pos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.model.ModelType;

public class vPosTaggerME {
	static int cutoff = 1;
	static int iteration = 1000;
	
	private static ObjectStream<POSSample> createSampleStream()
			throws IOException {
		InputStream in = new FileInputStream("data/POS/vi-pos.train");

		return new vPosSampleStream((new InputStreamReader(in)));
	}

	static POSModel trainPOSModel(ModelType type) throws Exception {
		return POSTaggerME.train("vi", createSampleStream(), type,
				null, null, cutoff, iteration);
	}

	public static void main(String[] args) throws Exception {
		POSModel posModel = trainPOSModel(ModelType.MAXENT);
		
		OutputStream out = new FileOutputStream("models/POS/vn.model");
		posModel.serialize(out);
		out.close();
		
		InputStream in = new FileInputStream("models/POS/vn.model");
		//POSModel posModel = new POSModel(in);
		posModel = new POSModel(in);

		POSTagger tagger = new POSTaggerME(posModel);
		
		String sentenceString = "1 . Bản_chất của Nhà_nước ta là nhà_nước của nhân_dân , do nhân_dân , vì nhân_dân , là sự thể_hiện quyền làm_chủ của nhân_dân dưới sự lãnh_đạo của Đảng .";
		String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(sentenceString);
		String[] tags = tagger.tag(tokens);
		
		for (int i = 0; i < tokens.length; i++)
			System.out.print(tokens[i] + "/" + tags[i] + " ");
		
		in.close();
	}

}
