package com.sinacolada.tiki.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Builder(buildMethodName = "builder", toBuilder = true)
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

}