package com.kaspperAcademy.banco.repositories;

import com.kaspperAcademy.banco.models.Apontamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApontamentoRepository extends JpaRepository <Apontamento, Long> {

}
