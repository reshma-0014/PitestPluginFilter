package org.pitest.plugin.export;

import java.nio.file.FileSystems;
import java.util.Properties;

import org.pitest.classpath.CodeSource;
import org.pitest.mutationtest.build.InterceptorParameters;
import org.pitest.mutationtest.build.MutationInterceptor;
import org.pitest.mutationtest.build.MutationInterceptorFactory;
import org.pitest.plugin.Feature;

public class MutantExportFactory implements MutationInterceptorFactory {

	@Override
	  public String description() {
	    return "Mutant export plugin";
	  }

	  @Override
	  public MutationInterceptor createInterceptor(InterceptorParameters params) {
	    return new MutantExportInterceptor();
	  }

	  @Override
	  public Feature provides() {
	    return Feature.named("EXPORT")
	        .withDescription("Exports mutants bytecode and other details to disk")
	        .withOnByDefault(true);
	  }

}
