package com.umg.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.banco.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
