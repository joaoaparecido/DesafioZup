package com.ProjetoZup.ProjetoZup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ProjetoZup.ProjetoZup.Models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
	


