package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.com.dto.request.CategoriesRequestPATCH;
import ra.com.dto.request.CategoriesRequestPOST;
import ra.com.dto.request.CategoriesRequestPUT;
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

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories/{id}
     * Method: PUT
     * Input: {name, priority, created, description, status}
     * Output:
     *  - id khong ton tai --> 404
     *  - id ton tai --> cap nhat --> 200
     * * */
    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategories(@PathVariable int id, @RequestBody CategoriesRequestPUT catalogRequestPut) {
        Categories catalog = categoriesService.update(catalogRequestPut, id);
        if (catalog != null) {
            return new ResponseEntity<>(catalog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories/{id}
     * Method: DELETE
     * Input:
     * Output:
     *  - id khong ton tai --> 404
     *  - id ton tai --> xoa --> 204
     * * */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable int id) {
        boolean result = categoriesService.delete(id);
        if (result) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * Service Endpoint: http://localshot:8080/api/v1/categories/{id}
     * Method: PATCH
     * Input: {name,priority}
     * Output:
     *  - id khong ton tai --> 404
     *  - id ton tai --> cap nhat --> {Categories} - 200
     * * */
    @PatchMapping("/{id}")
    public ResponseEntity<Categories> updatePartCategories(@PathVariable int id, @RequestBody CategoriesRequestPATCH categoriesRequestPATCH) {
        Categories catalog = categoriesService.updatePartCategories(categoriesRequestPATCH, id);
        if (catalog != null) {
            return new ResponseEntity<>(catalog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
