package logic.backend.repository;

import java.util.List;
import java.util.Map;
import logic.backend.data.Study;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface IStudy extends JpaRepository<Study, Long> {

    @Query(
            value = "SELECT name, i.text "
                    + "FROM portfolio.study s "
                    + "INNER JOIN portfolio.i18n i ON s.status = i.id_i18n AND  i.language = 'es' ",
            nativeQuery = true)
    public List<Map<String, Object>> allSkills();
    
    @Query(
            value = "SELECT name, i.text "
                    + "FROM portfolio.study s "
                    + "INNER JOIN portfolio.i18n i ON s.status = i.id_i18n AND  i.language = :language ",
            nativeQuery = true)
    public List<Map<String, Object>> allLanguageSkills(@Param("language") String language);
    
        @Query(
            value = "SELECT name, i.text "
                    + "FROM portfolio.study s "
                    + "INNER JOIN portfolio.i18n i ON s.status = i.id_i18n AND  i.language = :language "
                    + "WHERE upper(name) LIKE upper(CONCAT('%', :name, '%'))",
            nativeQuery = true)
    public List<Map<String, Object>> bySkillsName(@Param("language") String language, @Param("name") String name);
}
