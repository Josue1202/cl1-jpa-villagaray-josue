package pe.edu.i202220880.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Language", nullable = false)
    private String language;

    @Column(name = "IsOfficial", nullable = false)
    private Boolean isOfficial;

    @Column(name = "Percentage", nullable = false)
    private Double percentage;

    // Relaciones
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    //construtor sin parametros
    public CountryLanguage() {
    }

    //constructor con parametros
    public CountryLanguage(Integer id, String language, Boolean isOfficial, Double percentage, Country country) {
        this.id = id;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    //toString


    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                ", country=" + country +
                '}';
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
