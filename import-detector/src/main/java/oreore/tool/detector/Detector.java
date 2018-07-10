package oreore.tool.detector;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Detector {
    CtClass loadClass(final String fqcn) {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = null;
        try {
            ctClass = classPool.get(fqcn);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return ctClass;
    }

    protected abstract DetectorResult analyze(final CtClass ctClass, final DetectorResult detectorResult);

    public DetectorResult invoke(final String fqcn) {
        final CtClass ctClass = loadClass(fqcn);
        final DetectorResult detectorResult = new DetectorResult();
        analyze(ctClass, detectorResult);
        return detectorResult;
    }

    public static class DetectorResult {
        private Map<String, Object> information = new HashMap<>();

        public Map<String, Object> getInformation() {
            return information;
        }

        public void addInformation(final String key, final List list) {
            this.information.put(key, list);
        }
    }
}
