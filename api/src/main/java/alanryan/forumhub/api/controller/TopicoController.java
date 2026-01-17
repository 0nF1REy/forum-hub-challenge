package alanryan.forumhub.api.controller;

import alanryan.forumhub.api.domain.curso.CursoRepository;
import alanryan.forumhub.api.domain.topico.*;
import alanryan.forumhub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {

        // 1. Validação de Regra de Negócio: Duplicidade
        if (topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Já existe um tópico com este título e mensagem.");
        }

        // 2. Busca das entidades relacionadas (Autor e Curso)
        var autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com o ID: " + dados.idAutor()));

        var curso = cursoRepository.findById(dados.idCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + dados.idCurso()));

        // 3. Criação da entidade Topico
        var topico = new Topico(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), StatusTopico.NAO_RESPONDIDO, autor, curso);

        topicoRepository.save(topico);

        // 4. Retorna 201 Created e o DTO de detalhamento
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(
            @RequestParam(required = false) String nomeCurso,
            @RequestParam(required = false) Integer ano,
            @PageableDefault(size = 10, sort = "dataCriacao", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable paginacao) {

        Page<Topico> pagina;

        if (nomeCurso != null && ano != null) {
            pagina = topicoRepository.findAllByCursoNomeAndAno(nomeCurso, ano, paginacao);
        } else if (nomeCurso != null) {
            pagina = topicoRepository.findAllByCursoNome(nomeCurso, paginacao);
        } else {
            pagina = topicoRepository.findAll(paginacao);
        }

        return ResponseEntity.ok(pagina.map(DadosListagemTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
