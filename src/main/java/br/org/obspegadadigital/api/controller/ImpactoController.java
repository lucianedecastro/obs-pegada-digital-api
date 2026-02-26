package br.org.obspegadadigital.api.controller;

import br.org.obspegadadigital.api.dto.ImpactoRespostaDTO;
import br.org.obspegadadigital.api.model.LogImpacto;
import br.org.obspegadadigital.api.repository.LogImpactoRepository;
import br.org.obspegadadigital.api.service.ImpactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/calculo")
@CrossOrigin(origins = "*") // Permite a conexão vinda do seu Frontend (VS Code/Live Server)
public class ImpactoController {

    @Autowired
    private ImpactoService impactoService;

    @Autowired
    private LogImpactoRepository logRepository;

    @GetMapping("/evitado")
    public ImpactoRespostaDTO calcular(@RequestParam String slug, @RequestParam BigDecimal peso) {
        // Realiza o cálculo científico através do Service e grava o log no TiDB
        BigDecimal resultado = impactoService.calcularImpactoEvitado(slug, peso);

        // Retorna o Record (DTO) estruturado para o "Trust Widget" do Frontend
        return new ImpactoRespostaDTO(
                slug,
                peso,
                resultado,
                "VERIFICADO - PROTOCOLO V2024",
                "v2024.05.002"
        );
    }

    /**
     * Endpoint para extrair o histórico de auditoria gravado no TiDB.
     * Útil para prestação de contas e transparência ambiental.
     */
    @GetMapping("/historico")
    public List<LogImpacto> verHistorico() {
        // Busca todos os registros de impacto salvos no banco de dados para o dashboard
        return logRepository.findAll();
    }
}