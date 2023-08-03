package info.ashutosh.entity;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookRequest {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Description is required")
	private String description;

	@NotBlank(message = "Meal Type is required")
	private String mealType;

	@NotEmpty(message = "Ingredients list must not be empty")
	private List<String> ingredients;

	@NotNull(message = "DurationValidation is required")
	private RequieredTime requieredTime;

}
