package ra.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.com.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
