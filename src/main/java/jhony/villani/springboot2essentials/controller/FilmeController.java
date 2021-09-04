package jhony.villani.springboot2essentials.controller;

import jhony.villani.springboot2essentials.domain.Filme;
import jhony.villani.springboot2essentials.service.FilmeService;
import jhony.villani.springboot2essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("filmes")
@Log4j2
@RequiredArgsConstructor //inicia todos os componentes com final, nem necessitar de construtor
public class FilmeController {
    private final DateUtil dateUtil;
    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        //return new ResponseEntity<>(filmeService.listAll(), HttpStatus.OK); //outra maneira de apresentar o status
        return ResponseEntity.ok(filmeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable long id){
        return ResponseEntity.ok(filmeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody Filme filme){
        return new ResponseEntity<>(filmeService.save(filme), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        filmeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Filme filme){
        filmeService.replace(filme);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
