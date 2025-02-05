package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.com.dto.request.CategoriesRequestPOST;
import ra.com.dto.response.CategoriesResponseGET;
import ra.com.model.Categories;
import ra.com.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories
     * Method: GET
     * Input:
     * Output:
     *   List<{id,name,created,status}>
     * */
    @GetMapping
    public ResponseEntity<List<CategoriesResponseGET>> findAllCategories() {
        List<CategoriesResponseGET> listCategories = categoriesService.findAll();
//        return new ResponseEntity<>(listCategories, HttpStatus.OK);
        return ResponseEntity.ok().body(listCategories);
    }

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories/{id}
     * Method: GET
     * Input: PathVariable - Id
     * Output:
     *   {id,name,created,status}
     * */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriesResponseGET> findById(@PathVariable int id) {
        CategoriesResponseGET catalog = categoriesService.findById(id);
        if (catalog != null) {
            return new ResponseEntity<>(catalog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories
     * Method: POST
     * Input: {name, priority, description, status}
     * Output: {id, name, priority, created, description, status}
     * * */
    @PostMapping
    public ResponseEntity<Categories> saveCategories(@RequestBody CategoriesRequestPOST categoriesRequestPOST) {
        Categories catalog = categoriesService.save(categoriesRequestPOST);
        return new ResponseEntity<>(catalog, HttpStatus.CREATED);
    }
}
