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

    Optional<Teacher> findByUuid(UUID uuid);                                       //"Equals" is implied prior to the brackets.

    List<Teacher> findByLastname(String lastname);                                 //"Equals" is implied prior to the brackets. Therefore, it's not a good choice when we have string-type variable.

    List<Teacher> findByActiveTrue();

    List<Teacher> findByLastnameStartingWith(String keyword);                      //LIKE keyword% equivalent --preferred case, quicker!
    List<Teacher> findByLastnameContainingIgnoreCase(String keyword);              //LIKE %keyword% equivalent

    boolean existsByLastname(String lastname);

    long countByActiveTrue();                                                     // All the above until here, are the so called Derived queries. And are very efficient and worth using. Spring boot does the SQL equivalent command. Here is only verb-field-keyword.
                                                                                  // For simple-to-middle complex queries only.  When complicated queries are needed including 3-4 JOIN then the best way is the below one with @query in JPQL!!!

    @Query("SELECT t FROM Teacher t WHERE t.lastname LIKE :prefix% AND t.active = true")
    List<Teacher> findActiveByPrefix(@Param("prefix") String prefix);
}
