package com.ProjetoZup.ProjetoZup.Service;

import com.ProjetoZup.ProjetoZup.Models.*;
import com.ProjetoZup.ProjetoZup.Repository.UsuarioRepository;
import com.ProjetoZup.ProjetoZup.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FipeService fipeService;

    @Transactional
    public Veiculo adicionarVeiculo(Long usuarioId, Veiculo veiculo) {
        Usuario usuario = this.usuarioRepository.getById(usuarioId);
        veiculo.setUsuario(usuario);

        buscaValor(veiculo);

        return this.veiculoRepository.save(veiculo);
    }

    private void buscaValor(Veiculo veiculo) {

        List<FipeArmazena> marcas = this.fipeService.buscaMarcas();
        Optional<FipeArmazena> marcaDoVeiculo  = marcas.stream().filter(
                elemento -> elemento.getNome().toLowerCase()
                        .contains(veiculo.getMarca().toLowerCase())).findFirst();

        Modelo modelos = this.fipeService.buscaModelos(marcaDoVeiculo.get().getCodigo());
        Optional<FipeArmazena> modeloDoVeiculo  = modelos.getModelos().stream().filter(
                responseModel -> responseModel.getNome().toLowerCase()
                        .contains(veiculo.getModelo().toLowerCase())).findFirst();

        List<FipeArmazena> fipeListAnos = this.fipeService.buscaAnos(
                marcaDoVeiculo.get().getCodigo(), modeloDoVeiculo.get().getCodigo());

        Optional<FipeArmazena> anoDoVeiculo  = fipeListAnos.stream().filter(
                responseModel -> responseModel.getNome().toLowerCase()
                        .contains(veiculo.getAno())).findFirst();

        ValorFinal respostaValor = this.fipeService.buscaValor(
                marcaDoVeiculo.get().getCodigo(), modeloDoVeiculo.get().getCodigo(), anoDoVeiculo.get().getCodigo());

        veiculo.setValor(respostaValor.getValor());
    }

    public List<Veiculo> getVeiculosByUser(Long usuarioId) {
       return this.veiculoRepository.findAllByUsuarioId(usuarioId);
    }
}
