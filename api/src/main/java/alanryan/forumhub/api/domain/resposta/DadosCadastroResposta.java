package alanryan.forumhub.api.domain.resposta;

public record DadosCadastroResposta(
        @jakarta.validation.constraints.NotBlank String mensagem,
        @jakarta.validation.constraints.NotNull Long idTopico,
        @jakarta.validation.constraints.NotNull Long idAutor
) {}
