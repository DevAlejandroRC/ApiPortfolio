package logic.backend.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "i18n")
public class I18n implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_i18n")
    private Long idI18n;
    
    @NotBlank
    private String text;
    
    @NotBlank
    @JsonManagedReference
    @JoinColumn(name = "language", referencedColumnName = "id_language")
    @ManyToOne
    private Language language;
    
    @OneToMany(mappedBy = "name")
    @JsonBackReference
    private List<Progress> progresses;
    
    @OneToMany(mappedBy = "name")
    @JsonBackReference
    private List<Category> categories;
    
    @OneToMany(mappedBy = "name")
    @JsonBackReference
    private List<StudyStatus> statuses;
    
    @OneToMany(mappedBy = "overview")
    @JsonBackReference
    private List<Showcase> showcases;
    
}
