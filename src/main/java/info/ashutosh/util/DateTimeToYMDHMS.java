package info.ashutosh.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import info.ashutosh.entity.DurationValidation;

public class DateTimeToYMDHMS {
	public static DurationValidation LocalDateTimeToYMDHMS(LocalDateTime createdAt, LocalDateTime requieredTime) {

		// Calculate the duration between the two LocalDateTime objects
		Duration duration = Duration.between(createdAt, requieredTime);
		Period period = Period.between(createdAt.toLocalDate(), requieredTime.toLocalDate());

		DurationValidation durationValidation = new DurationValidation(duration, period);

		return durationValidation;

	}
}
