package com.proga.MyProga.repo;

import com.proga.MyProga.models.Bill;
import com.proga.MyProga.models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
//@Query(nativeQuery = true,  value = "SELECT d.id, d.name, d.age FROM Users d WHERE d.age = (SELECT MAX(d2.age) FROM Users d2)")
//    Bill findUserWithMaxAge();{
}
