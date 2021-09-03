package jhony.villani.springboot2.domain.controller;

import jhony.villani.springboot2.domain.Filme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filme")
public class FilmeController {
    //equivalente à localhost:8080/filme/list
    @GetMapping(path = "list")
    public List<Filme> list(){
        return List.of(new Filme("Tron"), new Filme("O Jogo da Imitação"), new Filme("Interestelar"));
    }
}
