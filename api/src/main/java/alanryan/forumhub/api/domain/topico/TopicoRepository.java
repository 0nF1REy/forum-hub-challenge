package alanryan.forumhub.api.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Verificação se já existe um tópico com o mesmo título e mesma mensagem
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
