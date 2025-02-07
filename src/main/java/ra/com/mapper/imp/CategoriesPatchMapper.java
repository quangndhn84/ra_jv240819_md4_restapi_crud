package ra.com.mapper.imp;

import org.springframework.stereotype.Component;
import ra.com.dto.request.CategoriesRequestPATCH;
import ra.com.mapper.GenericMapper;
import ra.com.model.Categories;

@Component
public class CategoriesPatchMapper implements GenericMapper<CategoriesRequestPATCH, Categories, Categories> {
    @Override
    public Categories mapperRequestToEntity(CategoriesRequestPATCH request) {
        return Categories.builder().name(request.getName())
                .priority(request.getPriority()).build();
    }

    @Override
    public Categories mapperEntityToResponse(Categories entity) {
        return null;
    }
}
