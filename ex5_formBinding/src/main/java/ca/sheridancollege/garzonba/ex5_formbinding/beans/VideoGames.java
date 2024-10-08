package ca.sheridancollege.garzonba.ex5_formbinding.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoGames {
    private Long id;
    private String title;
    private String publisher;
    private String platform;
    private String[] platforms = {"Xbox Series S", "Xbox Series X", "PlayStation 5", "PC"};
    private BigDecimal price;
}
