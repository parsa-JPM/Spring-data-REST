package ir.codefather.rest.repositories;

import ir.codefather.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
