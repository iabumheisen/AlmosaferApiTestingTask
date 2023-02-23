package apiTestsHelperPackage;

import static io.restassured.RestAssured.given;

import org.testng.internal.collections.Pair;

import helpersPackage.ApiPostBodyLoader;
import helpersPackage.PropertyReader;
import io.restassured.response.Response;

public class RequestsGenerator {

	Response response;
	RandomDateHelp randomDateHelp = new RandomDateHelp();
	Pair<String, String> randomDate = randomDateHelp.getTwoRandomDates();
	Pair<String, String> randomSequentDate = randomDateHelp.getTwoRandomSequentDates();
	ApiPostBodyLoader apiPostBodyLoader = new ApiPostBodyLoader();

	// GET Flights API request builder method
	public Response getFlightRequest() {

		return response = given().when().log().all()
				.queryParam("query",
						PropertyReader.propertyReader("originID") + "-" + PropertyReader.propertyReader("destinationID")
								+ "/" + randomDate.first() + "/" + randomDate.second() + "/"
								+ PropertyReader.propertyReader("cabinType") + "/"
								+ PropertyReader.propertyReader("numberOfPassengers"))
				.get(PropertyReader.propertyReader("flightApiPath"));
	}

	// POST Hotels API request builder method
	public Response postHotelsApi(String token) {

		return response = given().log().all().header("content-type", PropertyReader.propertyReader("contentType"))
				.header("token", token).header("accept", PropertyReader.propertyReader("accept")).body(apiPostBodyLoader
						.postApiRequestBodyForHotels(randomSequentDate.first(), randomSequentDate.second()))
				.when().post(PropertyReader.propertyReader("hotelApiPath"));
	}
}
