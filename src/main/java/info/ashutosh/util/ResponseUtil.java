package info.ashutosh.util;

import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.json.CustomResponse;

public class ResponseUtil {

	public static CustomResponse prepareResponse(ResponseStatus status, Object payload, String message) {
		return new CustomResponse(status.getCode(), payload, status.getMessage() + " : " + message);
	}
}