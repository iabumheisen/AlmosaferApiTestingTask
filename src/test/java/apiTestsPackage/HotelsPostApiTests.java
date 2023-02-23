package apiTestsPackage;

import org.junit.Test;

import apiTestsHelperPackage.RequestsGenerator;
import apiTestsHelperPackage.FrequentUsedMethods;
import apiTestsHelperPackage.AssertionMethodsClass;
import helpersPackage.PropertyReader;
import io.restassured.response.Response;

public class HotelsPostApiTests {

	AssertionMethodsClass assertionMethodsClass = new AssertionMethodsClass();
	RequestsGenerator requestsGenerator = new RequestsGenerator();
	Response response;

	// POST Hotels API tests with happy case scenario
	@Test
	public void postHotelsApiTests() {

		FrequentUsedMethods.setBaseURL();
		response = requestsGenerator.postHotelsApi(PropertyReader.propertyReader("validTokenKey"));
		assertionMethodsClass.statusCodeAssertion(response, 200);
		assertionMethodsClass.postHotelsApiResponseBodyAssertion(response);
	}

	// POST Hotels API tests with invalid token case scenario
	@Test
	public void postHotelsApiWithInvalidTokenTest() {

		FrequentUsedMethods.setBaseURL();
		response = requestsGenerator.postHotelsApi(PropertyReader.propertyReader("invalidTokenKey"));
		assertionMethodsClass.statusCodeAssertion(response, 401);
	}
}
