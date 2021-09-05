package jhony.villani.springboot2essentials.repository;

import jhony.villani.springboot2essentials.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByName(String name);
}
