package mackstar.shouldit.annotations;

import java.lang.annotation.Annotation;
import static org.junit.Assert.assertEquals;
import mackstar.shouldit.annotations.mocks.ItClass;
import org.junit.Test;

public class ContextTest {

	@Test
	public void test() {
		Class<ItClass> itClass = ItClass.class;
		Annotation annotation = itClass.getAnnotation(ShouldiTContext.class);
		ShouldiTContext context = (ShouldiTContext) annotation;
		String expected = "My Context";
		assertEquals("Can contain a context", expected, context.value());
	}

}