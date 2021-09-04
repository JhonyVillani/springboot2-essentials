package jhony.villani.springboot2essentials.service;

import jhony.villani.springboot2essentials.domain.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FilmeService {
    private static List<Filme> filmes;

    static {
        filmes = new ArrayList<>(List.of(new Filme(1L,"Tron"), new Filme(2L,"O Jogo da Imitação"), new Filme(3L,"Interestelar")));
    }

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

    public Filme save(Filme filme) {
        filme.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        filmes.add(filme);
        return filme;
    }

    public void delete(long id) {
        filmes.remove(findById(id));
    }

    public void replace(Filme filme) {
        delete(filme.getId());
        filmes.add(filme);
    }
}
