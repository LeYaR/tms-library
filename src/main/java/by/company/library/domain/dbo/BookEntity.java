package by.company.library.domain.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    private String isbn;

    private String name;

    private Date publishingDate;

    private BigDecimal price;

    private boolean inStock;

    @OneToMany(mappedBy = "book")
    private Set<BookMovementEntity> booksMovement;

    @ManyToMany(mappedBy = "books")
    Set<AuthorEntity> authors;
}
