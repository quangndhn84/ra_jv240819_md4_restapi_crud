package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import ra.com.dto.request.CategoriesRequestPATCH;
import ra.com.dto.request.CategoriesRequestPOST;
import ra.com.dto.request.CategoriesRequestPUT;
import ra.com.dto.response.CategoriesResponseGET;
import ra.com.model.Categories;
import ra.com.repository.CategoriesRepository;

import java.util.List;

public interface CategoriesService {
    List<CategoriesResponseGET> findAll();

    CategoriesResponseGET findById(int id);

    Categories save(CategoriesRequestPOST categoriesRequestPOST);

    Categories update(CategoriesRequestPUT categoriesRequestPUT, int id);

    boolean delete(int id);

    Categories updatePartCategories(CategoriesRequestPATCH categoriesRequestPATCH, int id);
}
