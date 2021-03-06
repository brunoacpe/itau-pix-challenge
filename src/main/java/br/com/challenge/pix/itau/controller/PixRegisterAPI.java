package br.com.challenge.pix.itau.controller;

import br.com.challenge.pix.itau.dto.PixRegisterRequest;
import br.com.challenge.pix.itau.dto.PixRegisterResponse;
import br.com.challenge.pix.itau.dto.PixRegisterResponsePatch;
import br.com.challenge.pix.itau.dto.UUIDRegisterDTO;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/v1/api/register")
public interface PixRegisterAPI {


    @ApiOperation(
            value = "Cadastra novo registro pix.",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = UUIDRegisterDTO.class
    )
    @RequestMapping(
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST
    )
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<UUIDRegisterDTO> createPixRegister(
             @RequestBody PixRegisterRequest request
    );


    @ApiOperation(
            value = "Desativa um registro pix.",
            produces = "application/json",
            httpMethod = "DELETE",
            response = PixRegisterResponse.class
    )
    @RequestMapping(
            value = "/{register_id}",
            produces = "application/json",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PixRegisterResponse> deactivateRegister(
            @PathVariable(value = "register_id") String registerId
    );


    @ApiOperation(
            value = "Busca um registro pix pelo ID.",
            produces = "application/json",
            httpMethod = "GET",
            response = PixRegisterResponse.class
    )
    @RequestMapping(
            value = "/{register_id}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    ResponseEntity<PixRegisterResponse> findRegisterById(
            @PathVariable(value = "register_id") String registerId
    );


    @ApiOperation(
            value = "Busca registros pix baseado em filtros.",
            produces = "application/json",
            httpMethod = "GET",
            response = PixRegisterResponse.class
    )
    @RequestMapping(
            value = "/filter",
            produces = "application/json",
            method = RequestMethod.GET
    )
    ResponseEntity<Page<PixRegisterResponse>> filterRegisters(
            @RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String keyType,
            @RequestParam(required = false) Integer agencyNumber,
            @RequestParam(required = false) Integer accountNumber,
            @RequestParam(required = false) String userFirstName
    );


    @ApiOperation(
            value = "Atualiza um registro pix.",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "PATCH",
            response = PixRegisterResponsePatch.class
    )
    @RequestMapping(
            value = "/{register_id}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.PATCH
    )
    ResponseEntity<PixRegisterResponsePatch> patchPixRegister(
            @PathVariable(value = "register_id") String registerId,
            @RequestBody PixRegisterRequest request
    );
}
