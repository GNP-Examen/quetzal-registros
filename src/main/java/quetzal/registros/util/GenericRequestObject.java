package quetzal.registros.util;

import java.util.Map;

public class GenericRequestObject extends RequestObject{
	
	private Map<String, Object> payload;

	/**
	 * @return the payload
	 */
	public Map<String, Object> getPayload() {
		return payload;
	}

	/**
	 * @param payload the payload to set
	 */
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}


}
