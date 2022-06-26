package com.example.entrenate.model.curso;

import com.example.entrenate.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CalificacionKey implements Serializable{
        private Long usuario_id;
        private Long curso_id;
    }

    @EmbeddedId
    private CalificacionKey id;

    @ManyToOne
    @MapsId("usuario_id")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("curso_id")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(nullable = false)
    @Length(min = 50)
    private String opinion;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private float rate;

    public Calificacion(final Usuario usuario, final Curso curso, final String opinion, final float rate) {
        this.usuario = usuario;
        this.curso = curso;
        this.opinion = opinion;
        this.rate = rate;
    }
}
