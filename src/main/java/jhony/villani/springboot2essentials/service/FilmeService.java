package jhony.villani.springboot2essentials.service;

import jhony.villani.springboot2essentials.domain.Filme;
import jhony.villani.springboot2essentials.exception.BadRequestException;
import jhony.villani.springboot2essentials.mapper.FilmeMapper;
import jhony.villani.springboot2essentials.repository.FilmeRepository;
import jhony.villani.springboot2essentials.requests.FilmePostRequestBody;
import jhony.villani.springboot2essentials.requests.FilmePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listAll(){
        return filmeRepository.findAll();
    }

    public List<Filme> findByName(String name){
        return filmeRepository.findByName(name);
    }

    public Filme findByIdOrThrowRequestException(long id){
        return  filmeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Filme not Found"));
    }

    @Transactional //não gera rollback para Exceções do tipo checked
    //@Transactional(rollbackFor = Exception.class) //se for o caso, necessário esta tag
    public Filme save(FilmePostRequestBody filmePostRequestBody) {
        Filme save =  filmeRepository.save(FilmeMapper.INSTANCE.toFilme(filmePostRequestBody));
        if(true)
            throw new RuntimeException("bad code");
            return save;
    }

    public void delete(long id) {
        filmeRepository.delete(findByIdOrThrowRequestException(id));
    }

    public void replace(FilmePutRequestBody filmePutRequestBody) {
        Filme savedFilme = findByIdOrThrowRequestException(filmePutRequestBody.getId());
        Filme filme = FilmeMapper.INSTANCE.toFilme(filmePutRequestBody);
        filme.setId(savedFilme.getId());
        filmeRepository.save(filme);
    }
}
