package by.company.library.controller;

import by.company.library.domain.dto.BookDto;
import by.company.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BookDto add(@RequestBody BookDto bookDto) {
        return service.add(bookDto);
    }

    @GetMapping("/get")
    public BookDto getById(String isbn) {
        return service.getById(isbn);
    }
}
