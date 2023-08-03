package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.ashutosh.entity.MealType;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {
	MealType findByName(String name);
}