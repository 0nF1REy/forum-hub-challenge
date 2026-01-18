package alanryan.forumhub.api.controller;

import alanryan.forumhub.api.domain.resposta.*;
import alanryan.forumhub.api.domain.topico.TopicoRepository;
import alanryan.forumhub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder) {
        var topico = topicoRepository.findById(dados.idTopico())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        var autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var resposta = new Resposta(dados, topico, autor);
        repository.save(resposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoResposta(resposta));
    }

    @PutMapping("/{id}/solucao")
    @Transactional
    public ResponseEntity marcarSolucao(@PathVariable Long id) {

        // 1. Busca a resposta ou lança 404 (EntityNotFoundException será capturada pelo TratadorDeErros)
        var resposta = repository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Resposta não encontrada"));

        var topico = resposta.getTopico();

        // 2. Regra de Negócio: Apenas o autor do tópico pode marcar a solução
        // Pegamos o usuário logado do contexto do Spring Security
        var usuarioLogado = (alanryan.forumhub.api.domain.usuario.Usuario)
                org.springframework.security.core.context.SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal();

        if (!topico.getAutor().getId().equals(usuarioLogado.getId())) {
            return ResponseEntity.status(org.springframework.http.HttpStatus.FORBIDDEN)
                    .body("Apenas o autor do tópico pode marcar uma resposta como solução.");
        }

        // 3. Regra de Negócio: Verificar se a resposta já é a solução
        if (resposta.getSolucao()) {
            return ResponseEntity.badRequest().body("Esta resposta já foi marcada como a solução.");
        }

        // 4. Regra de Negócio: Verificar se o tópico já está resolvido por outra resposta
        if (topico.getStatus() == alanryan.forumhub.api.domain.topico.StatusTopico.SOLUCIONADO) {
            return ResponseEntity.badRequest().body("Este tópico já possui uma solução marcada.");
        }

        resposta.marcarComoSolucao();

        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }
}
