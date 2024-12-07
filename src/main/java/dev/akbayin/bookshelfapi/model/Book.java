package dev.akbayin.bookshelfapi.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.akbayin.bookshelfapi.converter.PublisherReferenceConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String title;

    @ManyToMany
    @JoinTable(
        name = "book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Getter
    @Setter
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id", nullable = false)
    @Getter
    private Publisher publisher;

    @Getter
    @Setter
    @Column(name = "publishing_year")
    private int publishingYear;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Status status;

    @JsonDeserialize(converter = PublisherReferenceConverter.class)
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
