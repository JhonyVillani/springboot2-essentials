package jhony.villani.springboot2essentials.mapper;

import jhony.villani.springboot2essentials.domain.Filme;
import jhony.villani.springboot2essentials.requests.FilmePostRequestBody;
import jhony.villani.springboot2essentials.requests.FilmePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FilmeMapper {
    public static final FilmeMapper INSTANCE = Mappers.getMapper(FilmeMapper.class);

    public abstract Filme toFilme(FilmePostRequestBody filmePostRequestBody);

    public abstract Filme toFilme(FilmePutRequestBody filmePutRequestBody);
}
