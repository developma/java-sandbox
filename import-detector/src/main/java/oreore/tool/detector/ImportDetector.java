package oreore.tool.detector;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ImportDetector  {
    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        try {
            final CtClass ctClass = classPool.get("Target");
            System.out.println(ctClass);
            final ClassPool classPool1 = ctClass.getClassPool();
            final Iterator<String> importedPackages = classPool1.getImportedPackages();
            final Stream<String> stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(importedPackages, Spliterator.ORDERED), false);

            stream.forEach(s -> System.out.println(s));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
