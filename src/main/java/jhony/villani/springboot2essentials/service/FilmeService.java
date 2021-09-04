package jhony.villani.springboot2essentials.service;

import jhony.villani.springboot2essentials.domain.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmeService {
    private List<Filme> filmes = List.of(new Filme(1L,"Tron"), new Filme(2L,"O Jogo da Imitação"), new Filme(3L,"Interestelar"));
    //private final FilmeRepository filmeRepository
    public List<Filme> listAll(){
        return filmes;
    }
    public Filme findById(long id){
        return filmes.stream()
                .filter(filme -> filme.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filme not Found"));
    }
}
