package com.ProjetoZup.ProjetoZup.Service;

import com.ProjetoZup.ProjetoZup.Models.FipeResponseModel;
import com.ProjetoZup.ProjetoZup.Models.FipeResponseValor;
import com.ProjetoZup.ProjetoZup.Models.FipeRespostaModelo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/", value= "fipe")
public interface FipeService {

    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas", produces = "application/json")
    List<FipeResponseModel> buscaMarcas();

    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{marcaId}/modelos", produces = APPLICATION_JSON_VALUE)
    FipeRespostaModelo buscaModelos(@PathVariable(value = "marcaId") String marcaId);

    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{marcaId}/modelos/{modeloId}/anos", produces = APPLICATION_JSON_VALUE)
    List<FipeResponseModel> buscaAnos(@PathVariable(value = "marcaId") String marcaId, @PathVariable(value = "modeloId") String modeloId);

    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}", produces = APPLICATION_JSON_VALUE)
    FipeResponseValor buscaValor(@PathVariable(value = "marcaId") String marcaId, @PathVariable(value = "modeloId") String modeloId, @PathVariable(value = "anoId") String anoId);

}
