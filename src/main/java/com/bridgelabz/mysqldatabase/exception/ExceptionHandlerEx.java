package com.bridgelabz.mysqldatabase.exception;

import com.bridgelabz.mysqldatabase.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice //Handle exception for MessageController.
public class ExceptionHandlerEx {
    @ExceptionHandler(MethodArgumentNotValidException.class) //
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        //getBindingResult() is a function that checks for errors in web form data and Exception bind them results.
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while performing RESt API", errMsg);
        return  new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);

    }

    //This exception handler for service layer and remove optional<Message> that give us null.
    @ExceptionHandler(com.bridgelabz.mysqldatabase.exception.CustomException.class)
    public ResponseEntity<ResponseDTO> handleCustomException(com.bridgelabz.mysqldatabase.exception.CustomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while performing RESt API", exception.getMessage());
        return  new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);

    }
}
