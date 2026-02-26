package br.org.obspegadadigital.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_impacto_final")
@Data
public class LogImpacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_evento", nullable = false)
    private String nomeEvento;

    @Column(name = "peso_evitado_kg", nullable = false)
    private BigDecimal pesoEvitadoKg;

    @Column(name = "impacto_liquido")
    private BigDecimal impactoLiquido;

    @Column(name = "data_calculo")
    private LocalDateTime dataCalculo = LocalDateTime.now();
}