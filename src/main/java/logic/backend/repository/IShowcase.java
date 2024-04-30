package logic.backend.repository;

import java.util.*;
import logic.backend.data.Showcase;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface IShowcase extends JpaRepository<Showcase, Long> {

    @Query(value = "SELECT sh.id_showcase, sh.name, o.text AS overview, "
                    + "sh.url, t.text as progress, "
                    + "i.text as category, GROUP_CONCAT(DISTINCT s.name) AS technology, o.language AS language "
                    + "FROM portfolio.showcase sh "
                    + "INNER JOIN portfolio.i18n o ON o.id_i18n = sh.overview AND o.language = 'es' "
                    + "LEFT JOIN portfolio.progress p ON sh.progress = p.id_progress "
                    + "INNER JOIN portfolio.i18n t ON t.id_i18n = p.name AND t.language = 'es' "
                    + "LEFT JOIN portfolio.category c ON sh.category = c.id_category "
                    + "INNER JOIN portfolio.i18n i ON i.id_i18n = c.name AND i.language = 'es' "
                    + "LEFT JOIN portfolio.gallery g ON g.showcase = sh.id_showcase "
                    + "LEFT JOIN portfolio.study s ON g.study = s.id_study "
                    + "GROUP BY sh.id_showcase, t.text, i.text;"
            , nativeQuery = true)
    public List<Map<String, Object>> allShowcases();
    
    @Query(
            value ="SELECT sh.id_showcase, sh.name, o.text AS overview, "
                    + "sh.url, t.text as progress, "
                    + "i.text as category, GROUP_CONCAT(DISTINCT s.name) AS technology, o.language AS language "
                    + "FROM portfolio.showcase sh "
                    + "INNER JOIN portfolio.i18n o ON o.id_i18n = sh.overview AND o.language = :tag "
                    + "LEFT JOIN portfolio.progress p ON sh.progress = p.id_progress "
                    + "INNER JOIN portfolio.i18n t ON t.id_i18n = p.name AND t.language = :tag "
                    + "LEFT JOIN portfolio.category c ON sh.category = c.id_category "
                    + "INNER JOIN portfolio.i18n i ON i.id_i18n = c.name AND i.language = :tag "
                    + "LEFT JOIN portfolio.gallery g ON g.showcase = sh.id_showcase "
                    + "LEFT JOIN portfolio.study s ON g.study = s.id_study "
                    + "GROUP BY sh.id_showcase, t.text, i.text;",
            nativeQuery = true)
    public List<Map<String, Object>> findShowcaseLanguage(@Param("tag") String tag);

    @Query(
            value = "SELECT sh.id_showcase, sh.name, o.text AS overview, "
                    + "sh.url, t.text as progress, "
                    + "i.text as category, GROUP_CONCAT(DISTINCT s.name) AS technology, o.language AS language "
                    + "FROM portfolio.showcase sh "
                    + "INNER JOIN portfolio.i18n o ON o.id_i18n = sh.overview AND o.language = :tag "
                    + "LEFT JOIN portfolio.progress p ON sh.progress = p.id_progress "
                    + "INNER JOIN portfolio.i18n t ON t.id_i18n = p.name AND t.language = :tag "
                    + "LEFT JOIN portfolio.category c ON sh.category = c.id_category "
                    + "INNER JOIN portfolio.i18n i ON i.id_i18n = c.name AND i.language = :tag "
                    + "LEFT JOIN portfolio.gallery g ON g.showcase = sh.id_showcase "
                    + "LEFT JOIN portfolio.study s ON g.study = s.id_study "
                    + "WHERE upper(sh.name) LIKE upper(CONCAT('%', :name, '%')) "
                    + "GROUP BY sh.id_showcase, t.text, i.text;",
            nativeQuery = true)
    public List<Map<String, Object>> searchByShowcase(@Param("tag") String tag, @Param("name") String name);
}
