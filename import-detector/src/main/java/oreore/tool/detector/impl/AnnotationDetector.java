package oreore.tool.detector.impl;

import javassist.CtClass;
import javassist.CtMethod;
import oreore.tool.detector.Detector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AnnotationDetector extends Detector {
    @Override
    protected DetectorResult analyze(CtClass ctClass, DetectorResult detectorResult) {
        final Stream<CtMethod> ctMethodStream = Arrays.stream(ctClass.getMethods());
        ctMethodStream.forEach(method -> {
            try {
                final List<Object> annotations = Arrays.asList(method.getAnnotations());
                detectorResult.addInformation(method.getName(),
                        annotations);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        return detectorResult;
    }

    public static void main(String[] args) {
        final Detector annotationDetector = new AnnotationDetector();
        final DetectorResult result = annotationDetector.invoke("oreore.tool.detector.target.Target");
        for (Map.Entry<String, Object> entry: result.getInformation().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
