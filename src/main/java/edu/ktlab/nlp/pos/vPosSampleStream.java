package edu.ktlab.nlp.pos;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.postag.POSSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class vPosSampleStream extends FilterObjectStream<String, POSSample> {

	private static Logger logger = Logger.getLogger(vPosSampleStream.class
			.getName());

	public vPosSampleStream(Reader sentences) throws IOException {
		super(new PlainTextByLineStream(sentences));
	}

	public vPosSampleStream(ObjectStream<String> sentences) {
		super(sentences);
	}

	public POSSample read() throws IOException {

		String sentence = samples.read();

		if (sentence != null) {
			POSSample sample;
			try {
				sample = POSSampleExtend.parse(sentence, " ");
			} catch (InvalidFormatException e) {

				if (logger.isLoggable(Level.WARNING)) {
					logger.warning("Error during parsing, ignoring sentence: "
							+ sentence);
				}

				sample = new POSSampleExtend(new String[] {}, new String[] {});
			}

			return sample;
		} else {
			return null;
		}
	}
}
