package com.proga.MyProga.repo;

import com.proga.MyProga.models.Database;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseRepository extends CrudRepository<Database, Long> {
    @Query(nativeQuery = true,  value = "SELECT d.id, d.name, d.age FROM Database d WHERE d.age = (SELECT MAX(d2.age) FROM Database d2)")
    Database findUserWithMaxAge();


    @Query(nativeQuery = true,  value = "SELECT d.id, d.name, d.age FROM Database d WHERE d.age = (SELECT MIN(d2.age) FROM Database d2)")
    Database findUserWithMinAge();

    @Query(nativeQuery = true,  value = "SELECT AVG(age) AS average_age FROM Database")
    float findUserAverageAge();

    @Query(nativeQuery = true,  value = "SELECT id, age, name FROM Database WHERE age > (SELECT AVG(age) FROM Database)")
    List<Database> findUserWithAgeMoreThenAvr();
}