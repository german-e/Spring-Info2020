package com.informatorio.miblog.repository;

import com.informatorio.miblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    

//    @Override
//    Optional<T> findById(Long pLong);
//
//    @Override
//    <S extends T> S save(S pPost);
//
//    @Override
//    void delete(T t);
//
}
