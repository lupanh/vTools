package edu.ktlab.nlp.sd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.PlainTextByLineStream;

public class vSdTrainUtil {
	public static void trainSentenceDetectorModel() throws IOException {
		InputStream in = new FileInputStream("data/SD/vi-sd.train");
		OutputStream out = new FileOutputStream("models/SD/vi-sd.model");

		SentenceModel sentdetectModel = SentenceDetectorME.train("vi", new SentenceSampleStream(
				new PlainTextByLineStream(new InputStreamReader(in))), true, null, 1, 1000);
		sentdetectModel.serialize(out);

		out.close();
	}

	public static void main(String[] args) throws IOException {
		trainSentenceDetectorModel();
	}

}
