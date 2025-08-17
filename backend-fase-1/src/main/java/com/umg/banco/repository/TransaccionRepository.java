package com.umg.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.banco.entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

}
