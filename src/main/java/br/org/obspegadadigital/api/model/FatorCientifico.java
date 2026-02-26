package br.org.obspegadadigital.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "fatores_cientificos")
@Data // O Lombok gera getters e setters automaticamente
public class FatorCientifico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "material_nome", nullable = false)
    private String materialNome;

    @Column(name = "codigo_slug", nullable = false)
    private String codigoSlug;

    @Column(name = "fator_producao", nullable = false)
    private BigDecimal fatorProducao;

    @Column(name = "fator_incineracao", nullable = false)
    private BigDecimal fatorIncineracao;

    @Column(name = "patch_versao")
    private String patchVersao;
}
