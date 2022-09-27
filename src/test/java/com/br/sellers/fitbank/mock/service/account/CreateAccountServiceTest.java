package com.br.sellers.fitbank.mock.service.account;

import com.br.sellers.fitbank.mock.gateway.model.request.account.CreateAccountRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.response.BasicResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.account.CreateAccountResponseModel;
import com.br.sellers.fitbank.mock.service.ServiceBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateAccountServiceTest {

    private static final Gson GSON = new Gson();
    private static final String SIMULATE_SCENARIO = "SIMULATE_SCENARIO";

    private final ServiceBase createAccountService = new CreateAccountService();

    @Test
    void shouldReturnSuccessGivenAValidRequestBody() throws JsonProcessingException {
        final BasicResponseModel response = createAccountService.execute(GSON.toJson(request()), SIMULATE_SCENARIO);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(CreateAccountResponseModel.class, response.getClass());
        Assertions.assertNull(response.getValidation());
    }

    private CreateAccountRequestModel request() {
        final CreateAccountRequestModel request = new CreateAccountRequestModel();
        request.setMethod("CreateAccount");
        request.setPartnerId(12345L);
        request.setBusinessUnitId(1234567890L);

        request.setMail("adrian@gmail.com");
        request.setPhone(11952468542L);
        request.setNickname("Adrian");
        request.setName("Adrian Mackenzie");
        request.setTaxNumber("05648546548");
        request.setBank("0542");
        request.setBankBranch("042");
        request.setBankAccount("0985422");
        request.setBankAccountDigit("2");

        return request;
    }
}
