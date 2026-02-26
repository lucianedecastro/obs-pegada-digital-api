package br.org.obspegadadigital.api.controller;

import br.org.obspegadadigital.api.model.FatorCientifico;
import br.org.obspegadadigital.api.repository.FatorCientificoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fatores") // O endereço que usaremos no navegador
public class FatorCientificoController {

    @Autowired
    private FatorCientificoRepository repository;

    @GetMapping
    public List<FatorCientifico> listarTodos() {
        // O Spring Data JPA faz o "SELECT * FROM fatores_cientificos" por baixo dos panos
        return repository.findAll();
    }
}
