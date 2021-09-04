package jhony.villani.springboot2essentials.service;

import jhony.villani.springboot2essentials.domain.Filme;
import jhony.villani.springboot2essentials.repository.FilmeRepository;
import jhony.villani.springboot2essentials.requests.FilmePostRequestBody;
import jhony.villani.springboot2essentials.requests.FilmePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listAll(){
        return filmeRepository.findAll();
    }

    public Filme findByIdOrThrowRequestException(long id){
        return  filmeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filme not Found"));
    }

    public Filme save(FilmePostRequestBody filmePostRequestBody) {
        return filmeRepository.save(Filme.builder().name(filmePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        filmeRepository.delete(findByIdOrThrowRequestException(id));
    }

    public void replace(FilmePutRequestBody filmePutRequestBody) {
        Filme savedFilme = findByIdOrThrowRequestException(filmePutRequestBody.getId());
        Filme filme = Filme.builder()
                .id(savedFilme.getId())
                .name(filmePutRequestBody.getName())
                .build();

        filmeRepository.save(filme);
    }
}
