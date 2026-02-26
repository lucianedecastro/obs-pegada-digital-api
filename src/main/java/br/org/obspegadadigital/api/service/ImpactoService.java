package br.org.obspegadadigital.api.service;

import br.org.obspegadadigital.api.model.FatorCientifico;
import br.org.obspegadadigital.api.model.LogImpacto;
import br.org.obspegadadigital.api.repository.FatorCientificoRepository;
import br.org.obspegadadigital.api.repository.LogImpactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ImpactoService {

    @Autowired
    private FatorCientificoRepository repository;

    @Autowired
    private LogImpactoRepository logRepository;

    /**
     * Calcula o impacto evitado e registra o log de auditoria no banco de dados.
     * @Transactional garante que o cálculo só seja válido se a gravação do log funcionar.
     */
    @Transactional
    public BigDecimal calcularImpactoEvitado(String slug, BigDecimal pesoKg) {
        // 1. Busca os fatores científicos (PVC, LDPE, PMMA) no "Cofre de Dados"
        FatorCientifico fator = repository.findByCodigoSlug(slug)
                .orElseThrow(() -> new RuntimeException("Material não encontrado no banco: " + slug));

        // 2. Executa a lógica de cálculo baseada na sua metodologia
        BigDecimal impactoProducao = pesoKg.multiply(fator.getFatorProducao());
        BigDecimal impactoIncineracao = pesoKg.multiply(fator.getFatorIncineracao());
        BigDecimal resultadoFinal = impactoProducao.add(impactoIncineracao);

        // 3. Persistência do Log de Auditoria (Rastreabilidade)
        LogImpacto log = new LogImpacto();
        log.setNomeEvento("Cálculo Desmaterialização: " + slug);
        log.setPesoEvitadoKg(pesoKg);
        log.setImpactoLiquido(resultadoFinal);
        log.setDataCalculo(LocalDateTime.now());

        logRepository.save(log);

        return resultadoFinal;
    }
}