package ra.com.mapper.imp;

import org.springframework.stereotype.Component;
import ra.com.dto.request.CategoriesRequestPUT;
import ra.com.mapper.GenericMapper;
import ra.com.model.Categories;

@Component
public class CategoriesPutMapper implements GenericMapper<CategoriesRequestPUT, Categories, Categories> {
    @Override
    public Categories mapperRequestToEntity(CategoriesRequestPUT request) {
        return Categories.builder().name(request.getName())
                .priority(request.getPriority())
                .created(request.getCreated())
                .description(request.getDescription())
                .status(request.isStatus()).build();
    }

    @Override
    public Categories mapperEntityToResponse(Categories entity) {
        return null;
    }
}
