package dev.akbayin.bookshelfapi.repository;

import dev.akbayin.bookshelfapi.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long>, CrudRepository<Publisher, Long> {
}
