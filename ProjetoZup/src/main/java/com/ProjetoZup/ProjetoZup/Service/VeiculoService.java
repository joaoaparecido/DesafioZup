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

        List<FipeResponseModel> marcas = this.fipeService.buscaMarcas();
        Optional<FipeResponseModel> marcaDoVeiculo  = marcas.stream().filter(
                elemento -> elemento.getNome().toLowerCase()
                        .contains(veiculo.getMarca().toLowerCase())).findFirst();

        FipeRespostaModelo modelos = this.fipeService.buscaModelos(marcaDoVeiculo.get().getCodigo());
        Optional<FipeResponseModel> modeloDoVeiculo  = modelos.getModelos().stream().filter(
                responseModel -> responseModel.getNome().toLowerCase()
                        .contains(veiculo.getModelo().toLowerCase())).findFirst();

        List<FipeResponseModel> fipeListAnos = this.fipeService.buscaAnos(
                marcaDoVeiculo.get().getCodigo(), modeloDoVeiculo.get().getCodigo());

        Optional<FipeResponseModel> anoDoVeiculo  = fipeListAnos.stream().filter(
                responseModel -> responseModel.getNome().toLowerCase()
                        .contains(veiculo.getAno())).findFirst();

        FipeResponseValor respostaValor = this.fipeService.buscaValor(
                marcaDoVeiculo.get().getCodigo(), modeloDoVeiculo.get().getCodigo(), anoDoVeiculo.get().getCodigo());

        veiculo.setValor(respostaValor.getValor());
    }

    public List<Veiculo> getVeiculosByUser(Long usuarioId) {
       return this.veiculoRepository.findAllByUsuarioId(usuarioId);
    }
}
