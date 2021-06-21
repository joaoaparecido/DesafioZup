package com.ProjetoZup.ProjetoZup.controller;

import com.ProjetoZup.ProjetoZup.Models.Veiculo;
import com.ProjetoZup.ProjetoZup.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @PostMapping("/usuario/{usuarioId}/veiculo")
    public ResponseEntity<Veiculo> postVeiculo(@PathVariable Long usuarioId, @RequestBody Veiculo veiculo){
        return new ResponseEntity<Veiculo>(this.veiculoService.adicionarVeiculo(usuarioId, veiculo), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}/veiculo")
    public ResponseEntity<List<Veiculo>> getUsuarios(@PathVariable(value = "usuarioId") Long usuarioId){
        diaRodizio();


        return new ResponseEntity<List<Veiculo>>(this.veiculoService.getVeiculosByUser(usuarioId), HttpStatus.OK);
    }

    private void diaRodizio() {
    }

}
