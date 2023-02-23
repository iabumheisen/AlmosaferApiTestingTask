package apiTestsHelperPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.internal.collections.Pair;

public class RandomDateHelp {

	LocalDateTime fromDate;
	LocalDateTime toDate;
	LocalDateTime randomDate1;
	LocalDateTime randomDate2;
	Random randomDay = ThreadLocalRandom.current();
	String formatedFromDate;
	String formatedToDate;

	// This method return two random generated dates as a string
	public Pair<String, String> getTwoRandomDates() {

		randomDate1 = LocalDateTime.now().plusDays(randomDay.nextInt(365) + 1);
		randomDate2 = LocalDateTime.now().plusDays(randomDay.nextInt(365) + 1);

		if (randomDate1.isBefore(randomDate2)) {

			fromDate = randomDate1;
			toDate = randomDate2;

		} else {

			toDate = randomDate1;
			fromDate = randomDate2;
		}

		formatedFromDate = dateFormatter(fromDate, "yyyy-MM-dd");
		formatedToDate = dateFormatter(toDate, "yyyy-MM-dd");

		return new Pair<String, String>(formatedFromDate, formatedToDate);
	}

	// This method returns two randomly generated dates as a String, and the second
	// date are next to the first date
	public Pair<String, String> getTwoRandomSequentDates() {

		randomDate1 = LocalDateTime.now().plusDays(randomDay.nextInt(365) + 1);
		randomDate2 = randomDate1.plusDays(1);

		formatedFromDate = dateFormatter(randomDate1, "yyyy-MM-dd");
		formatedToDate = dateFormatter(randomDate2, "yyyy-MM-dd");

		return new Pair<String, String>(formatedFromDate, formatedToDate);
	}

	// This method to format the date in shape that accepted for API requests
	public static String dateFormatter(LocalDateTime date, String format) {

		String formattedDate = date.format(DateTimeFormatter.ofPattern(format)).toString();
		return formattedDate;
	}
}
