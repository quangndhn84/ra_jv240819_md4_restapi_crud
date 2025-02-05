package ra.com.mapper.imp;

import org.springframework.stereotype.Component;
import ra.com.dto.request.CategoriesRequestPOST;
import ra.com.mapper.GenericMapper;
import ra.com.model.Categories;
@Component
public class CategoriesPostMapper implements GenericMapper<CategoriesRequestPOST, Categories, Categories> {
    @Override
    public Categories mapperRequestToEntity(CategoriesRequestPOST request) {
        return Categories.builder().name(request.getName())
                .priority(request.getPriority())
                .description(request.getDescription())
                .status(request.isStatus()).build();
    }

    @Override
    public Categories mapperEntityToResponse(Categories entity) {
        return null;
    }
}
