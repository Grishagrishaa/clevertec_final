package ru.clevertec.clevertec_final.repository.api;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.entity.News;

import java.util.List;
import java.util.UUID;


/**
 * Repository interface for managing Comment entities.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID>, JpaSpecificationExecutor<Comment> {

    /**
     * Retrieve a list of comments associated with a specific news UUID.
     *
     * @param newsUuid  The UUID of the news to retrieve comments for.
     * @param pageable  The pageable object specifying pagination information.
     * @return  A list of comments associated with the specified news UUID.
     */
    List<Comment> findAllByNewsUuid(UUID newsUuid, Pageable pageable);

}
