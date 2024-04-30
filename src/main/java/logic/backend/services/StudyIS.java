package logic.backend.services;

import java.util.*;
import logic.backend.repository.IStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudyIS implements StudyService{

    @Autowired
    private IStudy repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> skills() {
        return repository.allSkills();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> languageSkills(String language) {
        return repository.allLanguageSkills(language);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> skillsName(String language, String name) {
        return repository.bySkillsName(language, name);
    }
    
}
