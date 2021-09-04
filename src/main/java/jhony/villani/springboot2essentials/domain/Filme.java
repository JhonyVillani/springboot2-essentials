package jhony.villani.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //gera automaticamente getters/setters/toString
@AllArgsConstructor //inicia construtor com todas as variáveis
public class Filme {
    private Long id;
    private String name;
}
