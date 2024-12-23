package com.splitprice.project.Repository;

import com.splitprice.project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {


   Optional<Person> findByEmail(String email);

   void deleteByEmail(String email);
}
