package info.ashutosh.util;

import java.time.LocalDateTime;

public class DateTimeConverter {
	public static LocalDateTime calculateDateTimeAfterDuration(int years, int months, int days, int hours, int minutes,
			int seconds, LocalDateTime currentDateTime) {
		System.out.println(currentDateTime);

		currentDateTime = currentDateTime.plusYears(years).plusMonths(months).plusDays(days).plusHours(hours)
				.plusMinutes(minutes).plusSeconds(seconds+1);

		return currentDateTime;
	}
}
