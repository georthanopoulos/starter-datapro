package gr.aueb.cf.starter_data.runner;

import gr.aueb.cf.starter_data.model.Teacher;
import gr.aueb.cf.starter_data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component                                                                 // @Component -> Spring finds this class, creates it as Bean and calls run() at the startup.
@RequiredArgsConstructor                                                   // @RequestArgsConstructor -> Creates a constructor automatically. (As shown in the "muted" part below). Only in case is set as: private final!!!
public class TeacherRunner implements CommandLineRunner {                  // CLI -> is a functional interface of springBoot with one run(String... args) method, that is executed only once, right after the full-boot of the application context (=> Beans-created AND Injections-performed).
                                                                           // CLI -> when there is the need of something running from the beginning. A process let's say.

    private final TeacherRepository teacherRepository;                     // Best to be final - due to the private instance type - set as private for safety purposes....immutable..can't become "new".


//    @Autowired
//    public TeacherRunner(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }

    @Override
    public void run(String... args) throws Exception {                     // ... -> it means that we can pass arguments into the command on the terminal (for creating the .jar)!

//        Teacher teacher1 = new Teacher();
//        teacher1.setFirstname("John");
//        teacher1.setLastname("Papadopoulos");
//        teacher1.setActive(true);
//        teacherRepository.save(teacher1);                     // Upsert
//
//        Teacher teacher2 = new Teacher();
//        teacher2.setFirstname("Alice");
//        teacher2.setLastname("Ioannou");
//        teacher2.setActive(true);
//        teacherRepository.save(teacher2);                     // Upsert
//
//        Teacher teacher3 = new Teacher();
//        teacher3.setFirstname("Bob");
//        teacher3.setLastname("Giannoutsos");
//        teacher3.setActive(false);
//        teacherRepository.save(teacher3);                     // Upsert
//
//        List<Teacher> teachers = teacherRepository.findAll();
//        teachers.forEach(System.out::println);
//
//        teacherRepository.findByUuid(UUID.fromString("ba7cd0cd-d716-46f2-8967-e7eb1a2d6c46"))
//                .ifPresent(System.out::println);
//
//        Teacher teacher = teacherRepository.findById(2L)
//                .orElseThrow(() -> new RuntimeException("Teacher not found"));
//        teacher.setActive(false);
//        teacherRepository.save(teacher);
//        teacherRepository.delete(teacher);

        List<Teacher> teachers = teacherRepository.findActiveByPrefix("Io");
        teachers.forEach(System.out::println);


    }
}
