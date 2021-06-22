package by.company.library.repository;

import by.company.library.domain.dbo.BookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, String> {

    Optional<BookEntity> findByNameContaining(String name);

    List<BookEntity> findAllByNameAndPrice(String name, BigDecimal price);
}
