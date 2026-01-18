package alanryan.forumhub.api.domain.usuario;

public record DadosCadastroUsuario(
        @jakarta.validation.constraints.NotBlank String nome,
        @jakarta.validation.constraints.NotBlank @jakarta.validation.constraints.Email String email,
        @jakarta.validation.constraints.NotBlank String senha
) {}
