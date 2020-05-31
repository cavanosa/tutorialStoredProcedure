package com.tutorial.crudprocedure.repository;

import com.tutorial.crudprocedure.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    @Query(value = "{call lista_procedure()}", nativeQuery = true)
    List<Coche> listaProcedure();

    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Optional<Coche> idProcedure(@Param("idIn") int idIn);

    @Query(value = "{call marca_procedure(:marcaIn)}", nativeQuery = true)
    List<Coche> marcaProcedure(@Param("marcaIn") String marcaIn);

    @Query(value = "{call save_procedure(:marcaIn, :modeloIn, :anyoIn, :kmIn)}", nativeQuery = true)
    void saveProcedure(
            @Param("marcaIn")String marcaIn,
            @Param("modeloIn")String modeloIn,
            @Param("anyoIn")int anyoIn,
            @Param("kmIn")int kmIn
    );

    @Query(value = "{call media_procedure()}", nativeQuery = true)
    float mediaKm();

    @Query(value = "{call borrar_procedure(:idIn)}", nativeQuery = true)
    void borrarProcedure(@Param("idIn") int idIN);
}
