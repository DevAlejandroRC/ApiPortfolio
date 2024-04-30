package logic.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "gallery")
public class Gallery implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @JoinColumn(name = "showcase", referencedColumnName = "id_showcase")
    @ManyToOne
    @JsonIgnoreProperties("galleries")
    private Showcase showcase;
    
    @JoinColumn(name = "study", referencedColumnName = "id_study")
    @ManyToOne
    @JsonIgnoreProperties({"idStudy","galleries", "status"})
    private Study study;
    
}
