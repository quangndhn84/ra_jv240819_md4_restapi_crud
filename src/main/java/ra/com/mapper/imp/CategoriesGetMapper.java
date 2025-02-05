package ra.com.mapper.imp;

import org.springframework.stereotype.Component;
import ra.com.dto.response.CategoriesResponseGET;
import ra.com.mapper.GenericMapper;
import ra.com.model.Categories;
@Component
public class CategoriesGetMapper implements GenericMapper<Categories, Categories, CategoriesResponseGET> {
    @Override
    public Categories mapperRequestToEntity(Categories request) {
        return null;
    }

    @Override
    public CategoriesResponseGET mapperEntityToResponse(Categories entity) {
        return new CategoriesResponseGET(entity.getId(), entity.getName(), entity.getCreated(), entity.isStatus());
    }
}
