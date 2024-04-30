package logic.backend.services;

import java.util.List;
import java.util.Map;
import logic.backend.components.ShowcaseDTO;
import logic.backend.data.Showcase;

public interface ShowcaseService {
    
    public List<Map<String, Object>> showcases();
    
    public Showcase save(ShowcaseDTO showcase);
    public void update(ShowcaseDTO showcase);
    public void delete(Long id);

    public List<Map<String, Object>> findShowcaseLanguage(String tag);
    public List<Map<String, Object>> byShowcaseName(String tag, String name);
}
