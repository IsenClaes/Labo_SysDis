package hepl.isen.TvaService.tva;

import hepl.isen.TvaService.article.Article;
import hepl.isen.TvaService.article.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class TvaService {

    private final TvaRepository tvaRepository;
    private final ArticleRepository articleRepository;

    public TvaService(TvaRepository tvaRepository, ArticleRepository articleRepository) {
        this.tvaRepository = tvaRepository;
        this.articleRepository = articleRepository;
    }

    public double getTvaForArticle(Long articleId){
        Article article = articleRepository.findById(articleId).get();
        double tva = article.getTva().getTaux();
        return tva;
    }
}
