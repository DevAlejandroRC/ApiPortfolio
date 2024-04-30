package logic.backend.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;
    
    @NotNull
    @JsonIgnoreProperties({"idI18n","categories"})
    @JoinColumn(name = "name", referencedColumnName = "id_i18n")
    @ManyToOne
    private I18n name;
    
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Showcase> showcases;
}
