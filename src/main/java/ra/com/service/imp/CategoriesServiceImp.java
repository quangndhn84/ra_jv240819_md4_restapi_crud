package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.dto.request.CategoriesRequestPOST;
import ra.com.dto.response.CategoriesResponseGET;
import ra.com.mapper.imp.CategoriesGetMapper;
import ra.com.mapper.imp.CategoriesPostMapper;
import ra.com.model.Categories;
import ra.com.repository.CategoriesRepository;
import ra.com.service.CategoriesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesGetMapper categoriesGetMapper;
    @Autowired
    private CategoriesPostMapper categoriesPostMapper;

    @Override
    public List<CategoriesResponseGET> findAll() {
//        List<Categories> listCategories = categoriesRepository.findAll();
//        //mapper: List<Categories> --> List<CategoriesResponseGET>
//        List<CategoriesResponseGET> listCategoriesResponse = listCategories.stream()
//                .map(categories -> categoriesGetMapper.mapperEntityToResponse(categories)).toList();
        return categoriesRepository.findAll().stream()
                .map(categories -> categoriesGetMapper.mapperEntityToResponse(categories)).toList();
    }

    @Override
    public CategoriesResponseGET findById(int id) {
        Optional<Categories> optCategories = categoriesRepository.findById(id);
        return optCategories.map(categories -> categoriesGetMapper.mapperEntityToResponse(categories)).orElse(null);
    }

    @Override
    public Categories save(CategoriesRequestPOST categoriesRequestPOST) {
//        Categories categories = categoriesPostMapper.mapperRequestToEntity(categoriesRequestPOST);
//        Categories catalog = categoriesRepository.save(categories);
//        return catalog;
        return categoriesRepository.save(categoriesPostMapper.mapperRequestToEntity(categoriesRequestPOST));
    }
}
