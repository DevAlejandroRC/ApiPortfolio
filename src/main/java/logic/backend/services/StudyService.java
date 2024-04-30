package logic.backend.services;

import java.util.List;
import java.util.Map;

public interface StudyService {
    
    public List<Map<String, Object>> skills();
    public List<Map<String, Object>> languageSkills(String language);
    public List<Map<String, Object>> skillsName(String language, String name);
    
}
