package br.com.challenge.pix.itau.services;

import br.com.challenge.pix.itau.dto.PixRegisterRequest;
import br.com.challenge.pix.itau.entity.PixRegister;

import java.util.List;


public interface ValidationService {

    void validateUserFirstName(String userFirstName);

    void validateUserLastName(String userLastName);

    void validateRequest(PixRegisterRequest request);

    void validatePatchRequest(PixRegisterRequest request);

    void keyTypeValidation(String keyValue);

    void cpfValidations(String cpf);

    void cnpjValidations(String cnpj);

    void emailValidations(String email);

    void accountTypeValid(String accountType);

    void accountNumberValid(Integer accountNumber);

    void agencyNumberValid(Integer agencyNumber);

    void validateIfAccountReachedMaxRegisters(Integer accountNumber, Integer agencyNumber, String accountType);

}
