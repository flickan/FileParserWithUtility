package de.lsb.fileparserwithutility.main;

import java.io.IOException;
import java.util.StringTokenizer;

import de.lsb.util.file.FileInputIterator;

/**
 * Class parses text file with a given name and counts number of lines, words
 * and characters in the text file.
 */
public class ContentAnalyzer {

	/**
	 * Name of a file containing the path to that file.
	 */
	final private String _fileName;

	/**
	 * Counts number of characters in a file.
	 */
	private int _numberOfCharacters;

	/**
	 * Counts number of lines in a file.
	 */
	private int _numberOfLines;

	/**
	 * Counts number of words in a file.
	 */
	private int _numberOfWords;

	/**
	 * Constructor.
	 * 
	 * @param fileName
	 *            codes file name (with path if necessary).
	 */
	public ContentAnalyzer(String fileName) {
		_fileName = fileName;
	}

	/**
	 * Reads file with a given name and count number of lines, words and
	 * characters in that file.
	 * 
	 * @throws IOException
	 *             in case when given file can not be found.
	 */
	public void analyzeFileContent() throws IOException {

		final FileInputIterator fileIterator = new FileInputIterator(_fileName);

		try {
			while (fileIterator.isOpen() && fileIterator.hasNext()) {
				_numberOfLines++;
				final String line = fileIterator.next();
				final StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					_numberOfWords++;
					_numberOfCharacters += st.nextToken().length();
				}
			}
		} finally {
			fileIterator.close();
		}

	}

	/**
	 * @return {@link _numberOfCharacters}
	 */
	public int getNumberOfCharacters() {
		return _numberOfCharacters;
	}

	/**
	 * @return {@link _numberOfLines}
	 */
	public int getNumberOfLines() {
		return _numberOfLines;
	}

	/**
	 * @return {@link _numberOfWords}
	 */
	public int getNumberOfWords() {
		return _numberOfWords;
	}
}
