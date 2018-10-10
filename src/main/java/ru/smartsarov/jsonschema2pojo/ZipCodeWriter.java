package ru.smartsarov.jsonschema2pojo;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JPackage;

/**
 * Writes all the files into a zip file.
 * @see {@link https://github.com/UnquietCode/JCodeModel/blob/master/codemodel/src/main/java/com/sun/codemodel/writer/ZipCodeWriter.java}
 */
public class ZipCodeWriter extends CodeWriter {
	private final ZipOutputStream zip;
	private final OutputStream filter;
	
	/**
	 * @param target Zip file will be written to this stream.
	 */
	public ZipCodeWriter(OutputStream target) {
		zip = new ZipOutputStream(target);
		// nullify the close method.
		filter = new FilterOutputStream(zip) {
			public void close() {
			}
		};
	}

	public OutputStream openBinary(JPackage pkg, String fileName) throws IOException {
		String name = fileName;
		if (!pkg.isUnnamed())
			name = toDirName(pkg) + name;

		zip.putNextEntry(new ZipEntry(name));
		return filter;
	}

	/** Converts a package name to the directory name. */
	private static String toDirName(JPackage pkg) {
		return pkg.name().replace('.', '/') + '/';
	}

	public void close() throws IOException {
		zip.close();
	}
}