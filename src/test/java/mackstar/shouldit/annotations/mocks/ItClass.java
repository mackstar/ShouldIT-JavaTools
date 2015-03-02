package mackstar.shouldit.annotations.mocks;

import mackstar.shouldit.annotations.*;

@ShouldITContext("My Context")
public class ItClass {
	
	@It("should have a should")
	public void aMethod() {
		
	}
	
	@It("should have a second should")
	public void aSecondMethod() {
		
	}
}