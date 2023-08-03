package info.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.aop.CheckValidation;
import info.ashutosh.entity.CookRequest;
import info.ashutosh.json.CustomResponse;
import info.ashutosh.service.CookService;
import jakarta.validation.Valid;

@RestController
public class CookController {

	@Autowired
	CookService cookService;

//	{
//	    "name": "",
//	    "description": "Recipe Description",
//	    "mealType": "Meal Type",
//	    "ingredients": [
//	        "Ingredient 1",
//	        "Ingredient 2",
//	        "Ingredient 3"
//	    ],
//	    "reqTime": [1,59]// [Houre,minuts] minuts Must be less then 60 only
//	}
	@CheckValidation
	@PostMapping(value = "/add/recipe")
	public CustomResponse saveRecipe(@RequestBody @Valid CookRequest cookRequest, BindingResult bindingResult) {
		return cookService.saveRecipe(cookRequest);
	}

	@GetMapping(value = "/get/recipe/all")
	public CustomResponse getAllRecipes() {
		return cookService.getAllRecipes();
	}

	@GetMapping(value = "/get/recipe-by-name/{name}")
	public CustomResponse getRecipeByName(@PathVariable(value = "name") String name) {
		return cookService.getRecipeByName(name);
	}

}
