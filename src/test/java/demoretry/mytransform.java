package demoretry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class mytransform implements IAnnotationTransformer{
  @Test
  public void transform(ITestAnnotation annotation, Class testcalss, Constructor  testconstructor  ,Method tesrtmethod) {
  
	  annotation.setRetryAnalyzer(demoretry.demoListener.class);
  }
}
