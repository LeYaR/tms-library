package by.company.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private String isbn;
    private String name;
    private LocalDate publishingDate;
    private BigDecimal price;
    private boolean inStock;
}
