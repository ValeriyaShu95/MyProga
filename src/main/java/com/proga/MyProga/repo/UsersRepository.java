package com.proga.MyProga.repo;

import com.proga.MyProga.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query(nativeQuery = true,  value = "SELECT d.id, d.name, d.age FROM Users d WHERE d.age = (SELECT MAX(d2.age) FROM Users d2)")
    Users findUserWithMaxAge();


    @Query(nativeQuery = true,  value = "SELECT d.id, d.name, d.age FROM Users d WHERE d.age = (SELECT MIN(d2.age) FROM Users d2)")
    Users findUserWithMinAge();

    @Query(nativeQuery = true,  value = "SELECT AVG(age) AS average_age FROM Users")
    float findUserAverageAge();

    @Query(nativeQuery = true,  value = "SELECT id, age, name FROM Users WHERE age > (SELECT AVG(age) FROM Users)")
    List<Users> findUserWithAgeMoreThenAvr();
}