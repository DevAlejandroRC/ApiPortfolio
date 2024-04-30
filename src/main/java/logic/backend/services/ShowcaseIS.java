package logic.backend.services;

import java.util.*;
import logic.backend.components.ShowcaseDTO;
import logic.backend.data.Category;
import logic.backend.data.I18n;
import logic.backend.data.Progress;
import logic.backend.data.Showcase;
import logic.backend.repository.IShowcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShowcaseIS implements ShowcaseService{

    @Autowired
    private IShowcase repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showcases() {
        return repository.allShowcases();
    }

    @Override
    @Transactional
    public Showcase save(ShowcaseDTO data) {
        
        var category = new Category();
        category.setIdCategory(data.getCategory());
        
        var progress = new Progress();
        progress.setIdProgress(data.getProgress());
        
        var overview = new I18n();
        overview.setIdI18n(data.getOverview());
        
        Showcase showcase = new Showcase();
        
        showcase.setName(data.getName());
        showcase.setOverview(overview);
        showcase.setUrl(data.getUrl());
        showcase.setCategory(category);
        showcase.setProgress(progress);
        
        return repository.save(showcase);
    }
    
    @Override
    @Transactional
    public void update(ShowcaseDTO data) {
        
        var category = new Category();
        category.setIdCategory(data.getCategory());
        
        var progress = new Progress();
        progress.setIdProgress(data.getProgress());
        
        var overview = new I18n();
        overview.setIdI18n(data.getOverview());
        
        Showcase showcase = new Showcase();
        
        showcase.setName(data.getName());
        showcase.setOverview(overview);
        showcase.setUrl(data.getUrl());
        showcase.setCategory(category);
        showcase.setProgress(progress);
        
        repository.save(showcase);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Showcase showcase = new Showcase();
        showcase.setIdShowcase(id);
        repository.delete(showcase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findShowcaseLanguage(String tag) {
        return repository.findShowcaseLanguage(tag);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> byShowcaseName(String tag, String name) {
        return repository.searchByShowcase(tag, name);
    }
    
}
