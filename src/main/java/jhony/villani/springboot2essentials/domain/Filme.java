package jhony.villani.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //gera automaticamente getters/setters/toString
@AllArgsConstructor //inicia construtor com todas as variáveis
@NoArgsConstructor
@Entity
@Builder
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
