package ru.clevertec.clevertec_final.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.clevertec.clevertec_final.repository.entity.News;

import java.util.UUID;

/**
 * Repository interface for managing News entities.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, UUID>, JpaSpecificationExecutor<News> {

}
