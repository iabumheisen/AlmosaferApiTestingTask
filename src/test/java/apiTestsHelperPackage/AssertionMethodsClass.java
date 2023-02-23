package apiTestsHelperPackage;

import org.junit.Assert;

import helpersPackage.PropertyReader;
import io.restassured.response.Response;

public class AssertionMethodsClass {

	FrequentUsedMethods frequentUsedMethods = new FrequentUsedMethods();
	String responseValue;

	// This method to assert searchType and preferredCabin values from the response
	// body of flight GET API
	public void getFlightApiResponseBodyAssertion(Response response) {

		responseValue = response.then().extract().asString();

		String searchType = frequentUsedMethods.extractValueFromResponseBodyByKey(responseValue, "request.searchType");
		String preferredCabin = frequentUsedMethods.extractValueFromResponseBodyByKey(responseValue,
				"request.leg[0].preferredCabin");

		Assert.assertEquals(PropertyReader.propertyReader("searchType"), searchType);
		Assert.assertEquals(PropertyReader.propertyReader("cabinType"), preferredCabin);
	}

	// This method to assert sId value is not null in the response body of Hotels
	// POST API
	public void postHotelsApiResponseBodyAssertion(Response response) {

		responseValue = response.then().extract().asString();

		String sId = frequentUsedMethods.extractValueFromResponseBodyByKey(responseValue, "sId");
		Assert.assertNotNull(sId);
	}

	// This method to assert the response status code
	public void statusCodeAssertion(Response response, int statusCode) {
		response.then().log().all().assertThat().statusCode(statusCode);
	}
}
