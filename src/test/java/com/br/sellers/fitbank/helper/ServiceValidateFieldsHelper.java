package com.br.sellers.fitbank.helper;

import com.br.sellers.fitbank.mock.gateway.model.response.BasicResponseModel;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class ServiceValidateFieldsHelper {

    private ServiceValidateFieldsHelper() { }

    public static void executeAssertionsValidateFields(final String field, final BasicResponseModel response) {
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getValidation());
        Assertions.assertEquals(1, response.getValidation().length);

        final Map<String, String> validation = (Map<String, String>) response.getValidation()[0];
        Assertions.assertTrue(validation.containsKey(field));
        Assertions.assertEquals(String.format("%s é obrigatório", field), validation.get(field));
    }
}
