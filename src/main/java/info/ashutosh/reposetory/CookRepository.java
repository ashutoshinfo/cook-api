package info.ashutosh.reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.ashutosh.entity.Cook;

@Repository
public interface CookRepository extends JpaRepository<Cook, Long> {

	List<Cook> findByName(String name);

}
