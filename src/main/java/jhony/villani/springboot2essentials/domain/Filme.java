package jhony.villani.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //gera automaticamente getters/setters/toString
@AllArgsConstructor //inicia construtor com todas as variáveis
@NoArgsConstructor
@Entity
@Builder
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false)
    private String name;
}
