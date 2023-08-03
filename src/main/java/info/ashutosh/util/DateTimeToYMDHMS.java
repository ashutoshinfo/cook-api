package info.ashutosh.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import info.ashutosh.entity.RequieredTime;

public class DateTimeToYMDHMS {
	public static RequieredTime LocalDateTimeToYMDHMS(LocalDateTime createdAt, LocalDateTime requieredTime) {

		// Calculate the duration between the two LocalDateTime objects
		Duration duration = Duration.between(createdAt, requieredTime);
		Period period = Period.between(createdAt.toLocalDate(), requieredTime.toLocalDate());

		RequieredTime durationValidation = new RequieredTime(duration, period);

		return durationValidation;

	}
}
