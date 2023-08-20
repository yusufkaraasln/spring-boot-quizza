package com.quizza.api.request;


import com.quizza.api.entity.Answer;
import com.quizza.api.entity.Categories;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRequest {

        private String questionContent;

        private List<Answer> answers;

        private List<Categories> categories;



}
