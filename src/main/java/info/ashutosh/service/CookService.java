package info.ashutosh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.entity.Cook;
import info.ashutosh.entity.CookRequest;
import info.ashutosh.entity.RequieredTime;
import info.ashutosh.entity.Ingredients;
import info.ashutosh.entity.MealType;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.json.CustomResponse;
import info.ashutosh.reposetory.CookRepository;
import info.ashutosh.reposetory.IngredientsRepository;
import info.ashutosh.reposetory.MealTypeRepository;
import info.ashutosh.util.DateTimeConverter;
import info.ashutosh.util.DateTimeToYMDHMS;
import info.ashutosh.util.ResponseUtil;

@Service
public class CookService {

	@Autowired
	CookRepository cookRepository;

	@Autowired
	MealTypeRepository mealTypeRepository;

	@Autowired
	IngredientsRepository ingredientsRepository;

	public CustomResponse getAllRecipes() {
		List<Cook> findAll = cookRepository.findAll();
		if (!findAll.isEmpty()) {
			for (Cook cook : findAll) {
				System.out.println(cook.getCreatedAt());
				RequieredTime localDateTimeToYMDHMS = DateTimeToYMDHMS.LocalDateTimeToYMDHMS(cook.getCreatedAt(),
						cook.getReqTime());
				cook.setLocalDateTimeToYMDHMS(localDateTimeToYMDHMS);
			}
			return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, cookRepository.findAll(), null);
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, null, "Record Found");
	}

	public CustomResponse getRecipeByName(String recipe) {
		List<Cook> findByName = cookRepository.findByName(recipe);
		if (findByName.isEmpty()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found");
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, findByName, null);
	}

	public CustomResponse saveRecipe(CookRequest cookRequest) {

		// Find MealType by name or create a new one
		MealType mealType = mealTypeRepository.findByName(cookRequest.getMealType());
		if (mealType == null) {
			mealType = new MealType();
			mealType.setName(cookRequest.getMealType());
			mealType = mealTypeRepository.save(mealType);
		}

		// Create a new Ingredients entities and save them
		List<Ingredients> ingredientsList = new ArrayList<>();
		for (String ingredientName : cookRequest.getIngredients()) {
			Ingredients ingredient = new Ingredients();
			ingredient.setName(ingredientName);
			ingredientsList.add(ingredientsRepository.save(ingredient));
		}

		// Create a new Cook entity and set its properties
		Cook cook = new Cook();
		cook.setName(cookRequest.getName());
		cook.setDescription(cookRequest.getDescription());
		cook.setMealType(mealType);
		cook.setIngredients(ingredientsList);

		LocalDateTime now = LocalDateTime.now();
		cook.setCreatedAt(now);
		System.out.println(now);

		LocalDateTime resultDateTime = DateTimeConverter.calculateDateTimeAfterDuration(
				cookRequest.getRequieredTime().getYears(), cookRequest.getRequieredTime().getMonths(),
				cookRequest.getRequieredTime().getDays(), cookRequest.getRequieredTime().getHours(),
				cookRequest.getRequieredTime().getMinutes(), cookRequest.getRequieredTime().getSeconds(), now);

		cook.setReqTime(resultDateTime);

		// Save the Cook entity
		try {
			cook = cookRepository.save(cook);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.prepareResponse(ResponseStatus.ERROR, null, null);
		}

		if (cook == null) {
			return ResponseUtil.prepareResponse(ResponseStatus.BAD_CREDENTIAL, null, null);
		}

		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, null, null);
	}

}
