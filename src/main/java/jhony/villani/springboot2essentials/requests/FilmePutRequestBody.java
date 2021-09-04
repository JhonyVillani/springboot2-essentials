package jhony.villani.springboot2essentials.requests;

import lombok.Data;

@Data
public class FilmePutRequestBody {
    private Long id;
    private String name;
}
