package edu.ktlab.nlp.pos.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeFiles {
	static List<String> content = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		walk("data/Testset-POS");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
				"data/test.pos"), "UTF-8"));
		for (int i = 0; i < content.size(); i++) {
			if (content.get(i).trim().length() <= 1) continue;
			writer.write(content.get(i) + "\n");
		}
		writer.close();
	}

	public static void walk(String path) throws Exception {
		File root = new File(path);
		File[] list = root.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
			} else {
				readFile(f);
			}
		}
	}

	public static void readFile(File file) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "UTF-8"));

		String line = new String();
		while ((line = in.readLine()) != null) {
			content.add(line);
		}

		in.close();
	}
}
