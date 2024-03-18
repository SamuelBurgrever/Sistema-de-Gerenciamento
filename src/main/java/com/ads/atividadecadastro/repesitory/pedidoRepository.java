package com.ads.atividadecadastro.repesitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.atividadecadastro.entities.pedido;

@Repository
public interface pedidoRepository extends JpaRepository <pedido, Integer>{

    
} 

