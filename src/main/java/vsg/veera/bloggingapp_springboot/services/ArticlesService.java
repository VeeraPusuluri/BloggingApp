package vsg.veera.bloggingapp_springboot.services;

import org.springframework.stereotype.Service;
import vsg.veera.bloggingapp_springboot.dtos.CreateArticleRequestDto;
import vsg.veera.bloggingapp_springboot.dtos.UpdateArticleEntityDto;
import vsg.veera.bloggingapp_springboot.entities.ArticleEntity;
import vsg.veera.bloggingapp_springboot.repositories.ArticleRepository;
import vsg.veera.bloggingapp_springboot.repositories.UserRepository;

@Service
public class ArticlesService {

    private final UserRepository userRepository;
    private ArticleRepository articleRepository;

    public ArticlesService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }


    public ArticleEntity createArticle(CreateArticleRequestDto articleDto, Long authorId) {
        var author = userRepository.findById(authorId).orElseThrow(() -> new UserService.UserNotFoundException("Author Not Found"));
        var article = ArticleEntity.builder().id(authorId)
                .title(articleDto.getTitle())
                .subTitle(articleDto.getSubtitle())
                //ToDo: slug function
                .slug(articleDto.getTitle().toLowerCase().replaceAll("//s", "-"))
                .body(articleDto.getBody())
                .author(author).build();
        return articleRepository.save(article);
    }

    public ArticleEntity updateArticle(Long id, UpdateArticleEntityDto updateDto) {
        var article = articleRepository.findById(id).orElseThrow(() ->
                new ArticleNotFoundException(id));
        article.setId(id);
        assert updateDto.getTitle() != null;
        article.setTitle(updateDto.getTitle());
        article.setSubTitle(updateDto.getSubtitle());
        assert updateDto.getBody() != null;
        article.setBody(updateDto.getBody());
        return articleRepository.save(article);
    }


    public Iterable<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    public ArticleEntity getArticleById(long id) {
        return articleRepository.getReferenceById(id);
    }

    public ArticleEntity getArticleBySlug(String slug) {
        var article = articleRepository.findArticleBySlug(slug);
        if (article == null) {
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }


    static class ArticleNotFoundException extends IllegalArgumentException {
        public ArticleNotFoundException(String message) {
            super("Article with Slug " + message + " not found");
        }

        public ArticleNotFoundException(Long id) {
            super("Article with id " + id + " not found");
        }
    }
}
