package com.quizza.api.repository;

import com.quizza.api.entity.Question;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>, JpaSpecificationExecutor<Question>, PagingAndSortingRepository<Question, Integer> {


}
