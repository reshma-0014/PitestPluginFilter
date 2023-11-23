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

public class MutantExportInterceptor implements MutationFilter {
//	@Override
//  public Collection<MutationDetails> filter(Collection<MutationDetails> mutations) {
//
//    List<MutationDetails> indexable = new ArrayList<>(mutations);
//    Collection<MutationDetails> filteredMutants = new ArrayList<>();
//      for (int i = 0; i != indexable.size(); i++) {
//    	  MutationDetails md = indexable.get(i);
//    	  if (false) { // Filter by method name
//              filteredMutants.add(md);
//            }
//      }
//
//    return filteredMutants;
//  }



	  @Override
	  public Collection<MutationDetails> filter(
	      Collection<MutationDetails> mutations) {
	    return FCollection.filter(mutations, isMethodToFilter());
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

//  private final String     outDir;
//  private final FileSystem fileSystem;
//  private final ClassByteArraySource source;
//
//  private Path             mutantsDir;
//  private ClassName        currentClass;
//  private final Logger logger; 

//  public MutantExportInterceptor(FileSystem fileSystem,
//      ClassByteArraySource source, String outDir) {
//    this.fileSystem = fileSystem;
//    this.outDir = outDir;
//    this.source = source;
//    this.logger = LoggerFactory.getLogger(MutantExportInterceptor.class);
//  }
//
//  @Override
//  public InterceptorType type() {
//    return InterceptorType.FILTER;
//  }
//
//  @Override
//  public void begin(ClassTree clazz) {
//    currentClass = clazz.name();
//    String[] classLocation = (clazz.name().asJavaName())
//        .split("\\.");
//    Path classDir = fileSystem.getPath(outDir, classLocation);
//    mutantsDir = classDir.resolve("mutants");
//    try {
//      Files.createDirectories(mutantsDir);
//      writeBytecodeToDisk(source.getBytes(clazz.name().asJavaName()).value(), classDir);
//    } catch (IOException e) {
//      throw new RuntimeException("Couldn't create direectory for " + clazz, e);
//    }
//  }
//
//  @Override
//  public Collection<MutationDetails> intercept(
//      Collection<MutationDetails> mutations, Mutater m) {
//
//    List<MutationDetails> indexable = new ArrayList<>(mutations);
//    Collection<MutationDetails> filteredMutants = new ArrayList<>();
//
//    try {
//      for (int i = 0; i != indexable.size(); i++) {
//    	  MutationDetails md = indexable.get(i);
//    	  if (md.getMethod().name().equals("getMetaData")) { // Filter by method name
//              filteredMutants.add(md);
//              exportMutantDetails(m, indexable, i);
//            }
//      }
//    } catch (IOException ex) {
//      throw new RuntimeException("Error exporting mutants for report", ex);
//    }
//
//    return filteredMutants;
//  }
//
//  private void exportMutantDetails(Mutater m, List<MutationDetails> indexable,
//      int i) throws IOException {
//	  MutationDetails md = indexable.get(i);
////	  if (!isMutationInMethod(md, "getMetaData")) {
//	        Path mutantFolder = mutantsDir.resolve("" + i);
//	        Files.createDirectories(mutantFolder);
//	        
//	        Mutant mutant = m.getMutation(md.getId());
//	        
//	        writeMutantToDisk(mutant, mutantFolder);
//	        writeBytecodeToDisk(mutant.getBytes(), mutantFolder);
//	        writeDetailsToDisk(md, mutantFolder);
////	    }
//  }
//
//  private boolean isMutationInMethod(MutationDetails md, String methodName) {
//	    // Assuming getMethodName() returns the name of the method where the mutation occurs
//	    String mutationMethod = md.getMethod().toString();
//	    logger.info(mutationMethod); // Use logger.debug for debugging information
//	    logger.info("+++++++====================================================");
//	   
////	    System.out.println(mutationMethod);
////	    System.out.println("												+++++++====================================================");
//	    return mutationMethod.equals(methodName);
//	}
//  
//  private void writeMutantToDisk(Mutant mutant, Path mutantFolder) throws IOException {
//    Path outFile = mutantFolder.resolve(currentClass.asJavaName() + ".class");
//    Files.write(outFile, mutant.getBytes(), StandardOpenOption.CREATE);
//  }
//  
//  
//  private void writeBytecodeToDisk(final byte[] clazz, Path folder) throws IOException { 
//      final ClassReader reader = new ClassReader(clazz);
//      CharArrayWriter buffer = new CharArrayWriter();
//      reader.accept(new TraceClassVisitor(null, new Textifier(), new PrintWriter(
//          buffer)), ClassReader.EXPAND_FRAMES);
//      Path outFile = folder.resolve(currentClass.asJavaName() + ".txt");
//      Files.write(outFile, Collections.singleton(buffer.toString()), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
//  }
//  
//  private void writeDetailsToDisk(MutationDetails md,
//      Path mutantFolder) throws IOException  {
//    Path outFile = mutantFolder.resolve("details.txt");
//    Files.write(outFile, Collections.singleton(md.toString()), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
//  }
//
//  @Override
//  public void end() {
//
//  }

}


