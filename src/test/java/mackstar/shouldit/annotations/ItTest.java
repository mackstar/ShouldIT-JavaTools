package mackstar.shouldit.annotations;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import mackstar.shouldit.annotations.mocks.ItClass;
import org.junit.*;

public class ItTest {
	
	private Method[] method;
	
	@Before
	public void setUp() {
		Class<ItClass> itClass = ItClass.class;
		method = itClass.getDeclaredMethods();
	}

	@Test
	public void testItAnnotationCanAssignAStringValue() {
		
		Annotation annotation = method[0].getAnnotation(It.class);
		It it = (It) annotation;
		String expected = "should have a should";
		assertEquals("A value can be assigned to an IT", expected, it.value());
	}
	
	@Test
	public void testItCanRetrieveASecondValue() {
		Annotation annotation = method[1].getAnnotation(It.class);
		It it = (It) annotation;
		String expected = "should have a second should";
		assertEquals("A value can be assigned to a second IT", expected, it.value());
	}

}