package jhony.villani.springboot2essentials.controller;

import jhony.villani.springboot2essentials.domain.Filme;
import jhony.villani.springboot2essentials.requests.FilmePostRequestBody;
import jhony.villani.springboot2essentials.requests.FilmePutRequestBody;
import jhony.villani.springboot2essentials.service.FilmeService;
import jhony.villani.springboot2essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return ResponseEntity.ok(filmeService.findByIdOrThrowRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Filme>> findByName(@RequestParam String name){
        return ResponseEntity.ok(filmeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody @Valid FilmePostRequestBody filmePostRequestBody){
        return new ResponseEntity<>(filmeService.save(filmePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        filmeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody FilmePutRequestBody filmePutRequestBody){
        filmeService.replace(filmePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
