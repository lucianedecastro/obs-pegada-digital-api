package br.org.obspegadadigital.api.repository;

import br.org.obspegadadigital.api.model.FatorCientifico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FatorCientificoRepository extends JpaRepository<FatorCientifico, Long> {
    // Busca um material específico pelo slug (ex: 'PVC')
    Optional<FatorCientifico> findByCodigoSlug(String codigoSlug);
}
