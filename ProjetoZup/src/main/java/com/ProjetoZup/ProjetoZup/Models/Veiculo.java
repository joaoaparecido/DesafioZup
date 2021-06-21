package com.ProjetoZup.ProjetoZup.Models;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.text.DateFormatSymbols;
import java.util.*;

@Entity
@Table(name="veiculo")
public class Veiculo {

	private static final HashMap<Integer,Integer> diasRodizia2DiaSemana = new HashMap<Integer, Integer>(){{
		put(0, Calendar.MONDAY);
		put(1, Calendar.MONDAY);

		put(2, Calendar.TUESDAY);
		put(3, Calendar.TUESDAY);

		put(4, Calendar.WEDNESDAY);
		put(5, Calendar.WEDNESDAY);

		put(6, Calendar.THURSDAY);
		put(7, Calendar.THURSDAY);

		put(8, Calendar.FRIDAY);
		put(9, Calendar.FRIDAY);
	}};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message= "favor preencher a marca.")
    private String marca;

    @Column
    @NotEmpty(message= "favor preencher o modelo.")
    private String modelo;

    @Column
    @NotEmpty(message = "favor preencher o ano.")
    @Size(min=4, max=4, message="O ano deve possuir 4 digitos")
    private String ano;

    private String valor;

    @ManyToOne(cascade = CascadeType.REMOVE)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Transient
	public String getDiaRodizio() {
		if (this.ano.isEmpty()){
			return "ano do veículo não foi definido definido!";

		}

		int diaDaSemana = diasRodizia2DiaSemana.get(this.getUltimoDigitoAno());
		DateFormatSymbols symbols = new DateFormatSymbols(new Locale("pt", "BR") );
		return symbols.getWeekdays()[diaDaSemana];
	}

	@Transient
	public Boolean getRodizioAtivo() {
		if (this.ano.isEmpty()){
			return false;
		}

		int diaAtual = new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
		return diaAtual == diasRodizia2DiaSemana.get(this.getUltimoDigitoAno());
	}

	@Transient
	private int getUltimoDigitoAno() {
		return Character.getNumericValue(this.ano.charAt(this.ano.length()-1));
	}
}
