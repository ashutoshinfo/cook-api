# cook-aging-api

A brief introduction to your project and its purpose.

## Description

This project aims to provide a solution for storing and managing food items, like wine or cheese, with their respective "ready dates" based on the current time when the entry is stored. The application allows users to input the food item's name, quantity, and the aging duration required for the item to be ready, whether in days, months, or even years. The system will then calculate and store the actual "ready date" based on the current time and aging duration.

## Technologies Used

- Spring Framework
- AspectJ
- Hibernate
- MySQL
- REST API
- LocalDateTime
- LocalDate
- LocalTime
- Duration
- Period

## API Payload to save Recipe

```
{
    "name": "Recipe Name",
    "description": "Recipe Description",
    "mealType": "Meal Type",
    "ingredients": [
        "Ingredient 1",
        "Ingredient 2",
        "Ingredient 3"
    ],
    "requieredTime": {
        "years": 23,
        "months": 340,
        "days": 153,
        "hours": 50, 
        "minutes": 320,
        "seconds": 45
    }
}
