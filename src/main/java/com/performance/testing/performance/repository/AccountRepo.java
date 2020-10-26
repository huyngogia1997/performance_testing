package com.performance.testing.performance.repository;


import com.performance.testing.performance.model.Accounts;
import com.performance.testing.performance.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.annotations.QueryHints.READ_ONLY;
import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository("accountRepo")
public interface AccountRepo extends JpaRepository<Accounts,Long> {
    @QueryHints(value = {
            @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE),
            @QueryHint(name = HINT_CACHEABLE, value = "false"),
            @QueryHint(name = READ_ONLY, value = "true")
    })
    @Query("select new com.performance.testing.performance.model.Accounts(ac.id,ac.fullName,ac.name,ac.email) from Accounts ac")
    Stream<Accounts> getAll();

    @Query("select new com.performance.testing.performance.model.Accounts(ac.id,ac.fullName,ac.name,ac.email) from Accounts ac")
    List<Accounts> getAll2();
}
