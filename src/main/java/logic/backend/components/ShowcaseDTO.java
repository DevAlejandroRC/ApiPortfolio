package logic.backend.components;

import lombok.Data;

@Data
public class ShowcaseDTO {
    
    private Long idShowcase;
    private String name;
    private Long overview;
    private String url;
    private Long progress;    
    private Long category;
    
}
