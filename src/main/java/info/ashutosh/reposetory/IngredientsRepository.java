package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.ashutosh.entity.Ingredients;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

}