package apiTestsHelperPackage;

import helpersPackage.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FrequentUsedMethods {

	// Set the API Base URI method
	public static void setBaseURL() {

		RestAssured.baseURI = PropertyReader.propertyReader("baseURL");
	}

	// Extract value from response body by passing the response and key
	public String extractValueFromResponseBodyByKey(String response, String key) {

		JsonPath jsonPath = new JsonPath(response);
		return jsonPath.getString(key);
	}
}
