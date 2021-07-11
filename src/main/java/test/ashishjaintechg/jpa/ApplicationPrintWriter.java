package test.ashishjaintechg.jpa;

import java.io.PrintWriter;

/**
 * This class provides output stream for filter.
 */
public class ApplicationPrintWriter extends PrintWriter {

	/** The branch. */
	PrintWriter writer;

	/**
	 * Instantiates a new tee print writer.
	 *
	 * @param main   the main
	 * @param branch the branch
	 */
public ApplicationPrintWriter(PrintWriter main, PrintWriter branch) {
 super(main, true);
this.writer = branch;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.io.PrintWriter#write(char[], int, int)
	 */
	@Override
public void write(char[] buf, int off, int len) {
super.write(buf, off, len);
super.flush();
writer.write(buf, off, len);
writer.flush();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.io.PrintWriter#write(java.lang.String, int, int)
	 */
	@Override
public void write(String s, int off, int len) {
super.write(s, off, len);
super.flush();
writer.write(s, off, len);
writer.flush();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.io.PrintWriter#write(int)
	 */
	@Override
public void write(int c) {
super.write(c);
super.flush();
writer.write(c);
writer.flush();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.io.PrintWriter#flush()
	 */
	@Override
public void flush() {
super.flush();
writer.flush();
	}
}