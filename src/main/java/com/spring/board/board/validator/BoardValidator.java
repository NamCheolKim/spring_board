package com.spring.board.board.validator;

import com.spring.board.board.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Board board = (Board) object;
        if(StringUtils.isEmpty(board.getContent())){
            errors.rejectValue("content", "key", "내용을 입력하세요.");
        }
        if(StringUtils.isEmpty(board.getName())){
            errors.rejectValue("name", "key", "이름을 입력하세요.");
        }

    }
}
