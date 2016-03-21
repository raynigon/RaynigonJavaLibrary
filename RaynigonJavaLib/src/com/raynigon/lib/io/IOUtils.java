package com.raynigon.lib.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

/**Generated on 04.11.2015 by Simon Schneider in Project <b>RaynigonJavaLib</b><p>
 * @author Simon Schneider
 */
public class IOUtils {

	/** The Default Buffer Size for Copy Operations on Streams
	 */
	public static final int DEFAULT_BUFFER_SIZE = 4096;
	
	public static void copy(InputStream inIs, StringWriter inSw, Charset inCs) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		copy(inIs, bos);
		inSw.write(new String(bos.toByteArray(), inCs));
	}
	
	
	public static void copy(InputStream is, OutputStream os) throws IOException {
		copy(is, os, DEFAULT_BUFFER_SIZE);
	}
	
	public static void copy(InputStream is, OutputStream os, int bufferSize) throws IOException {
		if(bufferSize<=0)
			throw new IOException("Buffer Size is too small, 1 is minimum");
		
		int length;
		byte[] bytes = new byte[bufferSize];
	
		while ((length = is.read(bytes)) >= 0)
			os.write(bytes, 0, length);
		
		return;
	}
}
