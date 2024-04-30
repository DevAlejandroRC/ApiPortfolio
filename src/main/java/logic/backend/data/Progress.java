package logic.backend.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "progress")
public class Progress implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progress")
    private Long idProgress;
    
    @NotNull
    @JsonIgnoreProperties({"idI18n","progresses"})
    @JoinColumn(name = "name", referencedColumnName = "id_i18n")
    @ManyToOne
    private I18n name;
    
    @OneToMany(mappedBy = "progress")
    @JsonBackReference
    private List<Showcase> showcases;
    
}
