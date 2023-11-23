package org.pitest.plugin.export;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;
import org.pitest.bytecode.analysis.ClassTree;
import org.pitest.classinfo.ClassByteArraySource;
import org.pitest.classinfo.ClassName;
import org.pitest.functional.FCollection;
import org.pitest.functional.prelude.Prelude;
import org.pitest.mutationtest.build.InterceptorType;
import org.pitest.mutationtest.build.MutationInterceptor;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.Mutater;
import org.pitest.mutationtest.engine.MutationDetails;
import org.pitest.mutationtest.filter.MutationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.pitest.functional.F;

public class MutantExportInterceptor implements MutationInterceptor {
	

	 @Override
	  public void begin(ClassTree clazz) {
	
	  }

	@Override
	  public Collection<MutationDetails> intercept(
	      Collection<MutationDetails> mutations, Mutater m) {
	    return FCollection.filter(mutations, isMethodToFilter());
	  }
	  
	  @Override
	  public InterceptorType type() {
	    return InterceptorType.FILTER;
	  }

	 

	  @Override
	  public void end() {
	   
	  }

	  private F<MutationDetails, Boolean> isMethodToFilter() {
	    return new F<MutationDetails, Boolean>() {
	      @Override
	      public Boolean apply(MutationDetails mutation) {
	        // Modify this condition based on your method name filtering criteria
	        return mutation.getMethod().name().equals("getMetaData");
	      }
	    };
	  }


}


