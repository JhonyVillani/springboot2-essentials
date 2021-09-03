package jhony.villani.springboot2.controller;

import jhony.villani.springboot2.domain.Filme;
import jhony.villani.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("filme")
@Log4j2
//@AllArgsConstructor //inicia todos os componentes da classe
@RequiredArgsConstructor //inicia todos os componentes com final, nem necessitar de construtor
public class FilmeController {
    private final DateUtil dateUtil;

//    public FilmeController(DateUtil dateUtil) {
//        this.dateUtil = dateUtil;
//    }

    //equivalente à localhost:8080/filme/list
    @GetMapping(path = "list")
    public List<Filme> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Filme("Tron"), new Filme("O Jogo da Imitação"), new Filme("Interestelar"));
    }
}
