package ru.smartsarov.jsonschema2pojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.GsonAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class JsonSchema2Pojo {
	String json2Java(String className, String packageName, boolean toDir) throws IOException {
		JCodeModel codeModel = new JCodeModel();

		//URL source = new URL("file:///path/to/my/schema.json");
		URL source = this.getClass().getResource("/schema.json");

		GenerationConfig config = new VikGenerationConfig();
		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new GsonAnnotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, className, packageName, source);

		File file;
		if (toDir) {
			file = new File("output");
			if (!file.exists()) {
				file.mkdirs();
			}
			codeModel.build(file);
		} else {
			file = new File(packageName.concat(".zip"));
			if (file.exists()) {
	            if (!file.delete())
	                throw new IOException(file + ": Can't delete previous version");
	        }
			codeModel.build(new ZipCodeWriter(new FileOutputStream(file)));
		}
		
		return "Package generated in ".concat(file.getAbsolutePath());
	}
}