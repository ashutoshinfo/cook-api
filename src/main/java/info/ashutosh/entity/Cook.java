package info.ashutosh.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;

	@ManyToMany
	@JoinTable(name = "cook_ingredients", joinColumns = { @JoinColumn(name = "fk_cook") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_ingredients") })
	private List<Ingredients> ingredients;

	@ManyToOne
	@JoinColumn(name = "mealtype_id")
	private MealType mealType;

	private LocalDateTime reqTime;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Transient
	private DurationValidation localDateTimeToYMDHMS;
	

	// Getters and setters
}
