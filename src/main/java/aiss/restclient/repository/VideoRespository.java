package aiss.restclient.repository;

import aiss.restclient.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRespository extends JpaRepository<Video, String> {

    Page<Video> findByName(String name, Pageable pageable);
}
