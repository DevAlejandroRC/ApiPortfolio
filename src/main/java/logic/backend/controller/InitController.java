package logic.backend.controller;

import logic.backend.components.ShowcaseDTO;
import jakarta.validation.Valid;
import java.util.*;
import logic.backend.data.*;
import logic.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class InitController {

    @Autowired
    private ShowcaseService showcaseService;

    @Autowired
    private StudyService studyService;
    
    /**
     **
     * Showcases
     ** 
     * @return 
     */
    @GetMapping("/showcases")
    public List<Map<String, Object>> showcases() {
        return showcaseService.showcases();
    }

    @GetMapping("/showcases/{tag}")
    public List<Map<String, Object>> findShowcaseLanguage(@PathVariable String tag) {
        return showcaseService.findShowcaseLanguage(tag);
    }

    @GetMapping("/showcases/{tag}/{name}")
    public List<Map<String, Object>> byShowcaseName(@PathVariable String tag, @PathVariable String name) {
        return showcaseService.byShowcaseName(tag, name);
    }

    @PostMapping("/showcases")
    public Showcase create(@Valid @RequestBody ShowcaseDTO project) {
        return showcaseService.save(project);
    }

    @PutMapping("/showcases/{tag}/{id}")
    public void update(@PathVariable String tag, @Valid @PathVariable Long id, @RequestBody ShowcaseDTO data) {
        data.setIdShowcase(id);
        showcaseService.update(data);
    }

    @DeleteMapping("/showcases/{tag}/{id}")
    public void delete(@PathVariable String tag, @Valid @PathVariable Long id) {
        showcaseService.delete(id);
    }
    
    /**
     **
     * Skills
     ** 
     * @return 
     */
    @GetMapping("/programmingLanguage")
    public List<Map<String, Object>> skills() {
        return studyService.skills();
    }
    
    @GetMapping("/programmingLanguage/{language}")
    public List<Map<String, Object>> findLanguage(@PathVariable String language) {
        return studyService.languageSkills(language);
    }

    @GetMapping("/programmingLanguage/{language}/{name}")
    public List<Map<String, Object>> bySkillsName(@PathVariable String language, @PathVariable String name) {
        return studyService.skillsName(language, name);
    }
}
