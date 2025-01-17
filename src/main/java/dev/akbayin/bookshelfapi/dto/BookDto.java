package dev.akbayin.bookshelfapi.dto;

import dev.akbayin.bookshelfapi.model.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(force = true)
@Getter
public class BookDto {

    @NotNull
    @Size(min = 1, max = 255)
    private final String title;

    @Valid
    @NotEmpty
    private final Set<AuthorDto> authors;

    @Valid
    @NotNull
    private final PublisherDto publisher;

    @Positive
    private final int publishingYear;

    @NotNull
    private final Status status;

    public BookDto(String title, Set<AuthorDto> authors, PublisherDto publisher, int publishingYear, Status status) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.status = status != null ? status : Status.NOT_READ; // Ensure default
    }
}