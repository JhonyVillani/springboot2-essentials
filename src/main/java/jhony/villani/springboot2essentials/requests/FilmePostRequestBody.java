package jhony.villani.springboot2essentials.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FilmePostRequestBody {
    @NotEmpty(message = "The name of movie cannot be empty") //resolve o null
    //@NotNull(message = "The name of movie cannot be empty")
    private String name;
}
