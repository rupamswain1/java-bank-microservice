package com.rupam.loanApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotAvailableException extends RuntimeException{
 public ResourceNotAvailableException(String resourceName, String fieldName, String mobileNumber){
     super(String.format("%s not found with fieldName %s having customerMobileNumber %s",resourceName, fieldName,mobileNumber));
 }
public ResourceNotAvailableException(String resourceName, String fieldName, Long loanId){
    super(String.format("%s not found with fieldName %s as %s",resourceName, fieldName,loanId));
}
}
