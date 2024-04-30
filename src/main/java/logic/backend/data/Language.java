package logic.backend.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "language")
public class Language implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_language", unique = true)
    @Size(max = 8)
    @NotBlank
    private String tag;
    
    @Column(unique = true)
    @NotBlank
    private String language;
    
    @OneToMany(mappedBy = "language")
    @JsonBackReference
    private List<I18n> translations;
}
