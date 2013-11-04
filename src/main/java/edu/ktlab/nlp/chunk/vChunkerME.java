package edu.ktlab.nlp.chunk;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.chunker.ChunkSampleStream;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.chunker.DefaultChunkerContextGenerator;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class vChunkerME {
	static int cutoff = 1;
	static int iteration = 200;

	private static ObjectStream<ChunkSample> createSampleStream() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		ObjectStream<String> lineStream = new PlainTextByLineStream(new FileInputStream(
				"data/Chunk/vi-chunk.train"), charset);
		return new ChunkSampleStream(lineStream);
	}

	static ChunkerModel trainChunkModel() throws Exception {
		return ChunkerME.train("vi", createSampleStream(), cutoff, iteration,
				new DefaultChunkerContextGenerator());
	}

	public static void main(String[] args) throws Exception {
		/*ChunkerModel chunkModel = trainChunkModel();
		OutputStream modelOut = new BufferedOutputStream(new FileOutputStream(
				"models/Chunk/vi-chunker.model"));
		chunkModel.serialize(modelOut);
		modelOut.close();*/

		InputStream inChunk = new FileInputStream("models/Chunk/vi-chunk.model");
		InputStream inPos = new FileInputStream("models/POS/vi-pos.model");
		ChunkerModel chunkModel = new ChunkerModel(inChunk);
		//chunkModel = new ChunkerModel(inChunk);
		POSModel posModel = new POSModel(inPos);

		ChunkerME chunker = new ChunkerME(chunkModel);
		POSTagger tagger = new POSTaggerME(posModel);

		String sentenceString = "Bản_chất của Nhà_nước ta là nhà_nước của nhân_dân , do nhân_dân , vì nhân_dân , là sự thể_hiện quyền làm_chủ của nhân_dân dưới sự lãnh_đạo của Đảng .";
		String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(sentenceString);
		String[] postags = tagger.tag(tokens);
		String[] chunktags = chunker.chunk(tokens, postags);

		for (int i = 0; i < tokens.length; i++)
			System.out.print(tokens[i] + "/" + postags[i] + "/" + chunktags[i] + " ");

		inChunk.close();
		inPos.close();
	}

}
