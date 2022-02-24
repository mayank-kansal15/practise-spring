package com.mayank.poc.test;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComplexJsonToObjectMappingExample {

  public static void convert() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      final String json = "{\"eventtype\":\"payment-closing\",\"payment\":{\"user\":{\"id\":71835},\"payment\":1101889,\"loandata\":{\"loans\":[{\"paidamount\":956365,\"request\":{\"id\":2127018,\"requestid\":\"RPK1644913601464\"},\"loan\":{\"id\":310535,\"coreid\":2136841}}]}}}";
      PaymentClosingDto paymentClosingDto = objectMapper.readValue(json, PaymentClosingDto.class);
      log.info("######### loans, {}", objectMapper.writeValueAsString(paymentClosingDto));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class PaymentClosingDto {
  private String eventtype;
  private Payment payment;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Payment {
  private long payment;
  private LoanData loandata;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class LoanData {
  private List<Loan> loans;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Loan {
  private PaymentRequest request;
  private IndividualLoan loan;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class PaymentRequest {
  private long id;
  private String requestid;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class IndividualLoan {
  private long id;
  private long coreid;
  private String loanid;
}