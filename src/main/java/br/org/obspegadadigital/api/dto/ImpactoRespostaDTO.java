package br.org.obspegadadigital.api.dto;

import java.math.BigDecimal;

/**
 * Record para transporte de dados de impacto.
 * Imutável e ideal para auditoria.
 */
public record ImpactoRespostaDTO(
        String material,
        BigDecimal pesoFisicoKg,
        BigDecimal co2EvitadoKg,
        String statusAuditoria,
        String versaoMetodologia
) {}
