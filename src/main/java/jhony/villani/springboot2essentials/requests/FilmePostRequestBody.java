package jhony.villani.springboot2essentials.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FilmePostRequestBody {
    @NotEmpty(message = "The name of movie cannot be empty") //resolve o null
    private String name;
}
