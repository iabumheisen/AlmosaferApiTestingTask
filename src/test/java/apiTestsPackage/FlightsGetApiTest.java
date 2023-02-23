package apiTestsPackage;

import org.junit.Test;

import apiTestsHelperPackage.RequestsGenerator;
import apiTestsHelperPackage.FrequentUsedMethods;
import apiTestsHelperPackage.AssertionMethodsClass;
import io.restassured.response.Response;

public class FlightsGetApiTest {

	AssertionMethodsClass assertionMethodsClass = new AssertionMethodsClass();
	RequestsGenerator requestsGenerator = new RequestsGenerator();
	Response response;

	// Test for GET flight API, the test will call getFlightRequest from requests
	// hub class and assert the response and status code
	@Test
	public void getFlightApiTest() {

		FrequentUsedMethods.setBaseURL();
		response = requestsGenerator.getFlightRequest();
		assertionMethodsClass.statusCodeAssertion(response, 200);
		assertionMethodsClass.getFlightApiResponseBodyAssertion(response);
	}
}
