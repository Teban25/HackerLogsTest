package testlogs.model;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final Map<String, SignType> SIGN_TYPES = new HashMap<String, SignType>(){
		private static final long serialVersionUID = 1L;
	{
		put("sign-in", SignType.SIGN_IN);
		put("sign-out", SignType.SIGN_OUT);
	}};
}
