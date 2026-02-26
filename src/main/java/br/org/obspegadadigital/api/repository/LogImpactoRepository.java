package br.org.obspegadadigital.api.repository;

import br.org.obspegadadigital.api.model.LogImpacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogImpactoRepository extends JpaRepository<LogImpacto, Long> {
}
