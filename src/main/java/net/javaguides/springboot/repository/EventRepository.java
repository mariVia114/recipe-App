package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByPublished(boolean published);

    List<Event> findByTitleContaining(String title);

    List<Event> findByUserid(Long userid);

}
