package ra.com.mapper;

public interface GenericMapper<R, E, P> {
    E mapperRequestToEntity(R request);

    P mapperEntityToResponse(E entity);
}
