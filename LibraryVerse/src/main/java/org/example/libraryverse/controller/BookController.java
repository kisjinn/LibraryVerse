package org.example.libraryverse.controller;


import org.example.libraryverse.models.Book;
import org.example.libraryverse.services.AuthorService;
import org.example.libraryverse.services.BookService;
import org.example.libraryverse.services.CategoryService;
import org.example.libraryverse.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBookk();
        model.addAttribute("books", books);
        return "books";

    }
    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model){
      Book book= bookService.findBook(id);
      model.addAttribute("book", book);
      return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.removeBook(id);
        model.addAttribute("books", bookService.findAllBookk());
        return  "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    //binding result will mcheck for any validation error in UI
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book"; //returning same page i.e stay on same page
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findAllBookk());
        return "redirect:/books";
    }


    @GetMapping("/add-book")
    public String addBook(Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("publishers", publisherService.findAllPublisher());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.adddBook(book);
        model.addAttribute("books", bookService.findAllBookk());
        return "redirect:/books";
    }



}
