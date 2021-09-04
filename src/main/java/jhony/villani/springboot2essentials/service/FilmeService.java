package jhony.villani.springboot2essentials.service;

import jhony.villani.springboot2essentials.domain.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    //private final FilmeRepository filmeRepository
    public List<Filme> listAll(){
        return List.of(new Filme(1L,"Tron"), new Filme(2L,"O Jogo da Imitação"), new Filme(3L,"Interestelar"));
    }
}
