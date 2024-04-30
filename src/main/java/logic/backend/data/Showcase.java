package logic.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "showcase")
public class Showcase implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_showcase")
    private Long idShowcase;
    
    @Column(unique = true)
    @NotBlank(message = "{validate.notEmpty}")
    private String name;
    
    @NotNull
    @JsonIgnoreProperties({"showcase","idI18n"})
    @JoinColumn(name = "overview", referencedColumnName = "id_i18n")
    @ManyToOne
    private I18n overview;
    
    private String url;

    @NotNull
    @JsonIgnoreProperties({"showcase","idProgress"}) 
    @JoinColumn(name = "progress", referencedColumnName = "id_progress")
    @ManyToOne
    private Progress progress;
    
    @NotNull
    @JsonIgnoreProperties({"showcase","idCategory"})
    @JoinColumn(name = "category", referencedColumnName = "id_category")
    @ManyToOne
    private Category category;
    
    @OneToMany(mappedBy = "showcase")
    @JsonIgnoreProperties("showcase")
    private List<Gallery> galleries;
    
}
