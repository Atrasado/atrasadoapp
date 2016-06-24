package br.com.atrasado.domain.entities;

public class Team {

    private Integer id;
    private String name, slug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Team{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
