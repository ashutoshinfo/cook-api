package info.ashutosh.entity;

import java.time.Duration;
import java.time.Period;

public class DurationValidation {
	private int years;
	private int months;
	private int days;
	private int hours;
	private int minutes;
	private int seconds;
	
	public DurationValidation() {
		// TODO Auto-generated constructor stub
	}

	public DurationValidation(Duration duration, Period period) {
		this.years = period.getYears();
		this.months = period.getMonths();
		this.days = period.getDays();
		this.hours = (int) (duration.toHours() % 24);
		this.minutes = (int) (duration.toMinutes() % 60);
		this.seconds = (int) (duration.getSeconds() % 60);
	}

	// Constructors, other methods, and getter methods (if needed)...

	public void setYears(Integer years) {
		this.years = (years != null) ? years : 0;
	}

	public int getYears() {
		return years;
	}

	public int getMonths() {
		return months;
	}

	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setMonths(Integer months) {
		this.months = (months != null) ? months : 0;
	}

	public void setDays(Integer days) {
		this.days = (days != null) ? days : 0;
	}

	public void setHours(Integer hours) {
		this.hours = (hours != null) ? hours : 0;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = (minutes != null) ? minutes : 0;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = (seconds != null) ? seconds : 0;
	}

	// Getters and setters (if needed)

	@Override
	public String toString() {
		return "DurationValidation{" + "years=" + years + ", months=" + months + ", days=" + days + ", hours=" + hours
				+ ", minutes=" + minutes + ", seconds=" + seconds + '}';

	}
}
