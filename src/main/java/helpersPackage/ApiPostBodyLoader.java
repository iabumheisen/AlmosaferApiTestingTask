package helpersPackage;

public class ApiPostBodyLoader {

	// This method will return the request body for post request as string when pass checkIn and checkOut values
	public String postApiRequestBodyForHotels(String checkIn, String checkOut) {

		return "{\"checkIn\":\"" + checkIn + "\",\"checkOut\":\"" + checkOut
				+ "\",\"roomsInfo\":[{\"adultsCount\":2,\"kidsAges\":[]}],"
				+ "\"searchInfo\":null,\"crossSellDetail\":null,\"hotelsId\":[\"1555218\"]}";
	}

}
