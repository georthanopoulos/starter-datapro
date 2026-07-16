package gr.aueb.cf.starter_data.repository;

import gr.aueb.cf.starter_data.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Repository -- Not needed when we extend the JPA Repository! Otherwise, we DO need to add it! SOS!
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUuid(UUID uuid);                                       //"equals" is implied.

    List<Teacher> findByLastname(String lastname);                                 //"equals" is implied. Therefore, it's not a good choice when we have string-type variable.

    List<Teacher> findByActiveTrue();

    List<Teacher> findByLastnameStartingWith(String keyword);                      //LIKE keyword%  --preferred case, quicker!
    List<Teacher> findByLastnameContainingIgnoreCase(String keyword);              //LIKE %keyword%

    boolean existsByLastname(String lastname);

    long countByActiveTrue();

    @Query("SELECT t FROM Teacher t WHERE t.lastname LIKE :prefix% AND t.active = true")
    List<Teacher> findActiveByPrefix(@Param("prefix") String prefix);
}
