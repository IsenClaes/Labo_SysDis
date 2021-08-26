package hepl.isen.TvaService.tva;

import javax.persistence.*;

@Entity
@Table
public class Tva {
    @Id
    @SequenceGenerator(
            name = "tva_sequence",
            sequenceName = "tva_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tva_sequence"
    )
    private Long id;
    private double taux;

    public Tva() {
    }

    public Tva(Long id, double taux) {
        this.id = id;
        this.taux = taux;
    }

    public Tva(double taux) {
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Tva{" +
                "id=" + id +
                ", taux=" + taux +
                '}';
    }
}
