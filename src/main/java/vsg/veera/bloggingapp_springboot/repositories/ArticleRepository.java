package vsg.veera.bloggingapp_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vsg.veera.bloggingapp_springboot.entities.ArticleEntity;
import vsg.veera.bloggingapp_springboot.entities.CommentEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    ArticleEntity findArticleBySlug(String slug);
}
