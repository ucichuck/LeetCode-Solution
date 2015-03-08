package leetcode.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TextFileReader implements Iterable<String> {
    private BufferedReader reader;

    public TextFileReader(String fileName) throws IOException {
	reader = new BufferedReader(new FileReader(fileName));
    }

    protected void finalize() throws Throwable {
	reader.close();
    }

    public Iterator<String> iterator() {
	return new Iterator<String>() {
	    private String line = null;

	    public boolean hasNext() {
		try {
		    line = reader.readLine();
		    if (line != null) {
			return true;
		    }
		    else {
			reader.close();
			return false;
		    }
		}
		catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public String next() {
		return line;
	    }

	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	};
    }

    public static void main(String[] args) throws IOException {
	for (String line: new TextFileReader("test.txt")) {
	    System.out.println(line);
	}
    }
}