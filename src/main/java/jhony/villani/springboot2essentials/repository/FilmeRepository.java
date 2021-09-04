package jhony.villani.springboot2essentials.repository;

import jhony.villani.springboot2essentials.domain.Filme;

import java.util.List;

public interface FilmeRepository {
    List<Filme> listAll();
}
