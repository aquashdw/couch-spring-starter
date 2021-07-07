package dev.aquashdw.demo.springtutorial.login;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {
    MemberEntity findByUsername(String username);
    MemberEntity findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
