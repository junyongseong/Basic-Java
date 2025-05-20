package am;

public class Ex2_Impl implements Ex2_Inter {

	int su=20;
	
	@Override
	public int getValue() {
		
		return MAX_value*su;
	}
}
