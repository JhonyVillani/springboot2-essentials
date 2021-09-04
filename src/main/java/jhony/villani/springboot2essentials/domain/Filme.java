package jhony.villani.springboot2essentials.domain;

public class Filme {
    private String name;

    public Filme(String name) {
        this.name = name;
    }

    public Filme() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
