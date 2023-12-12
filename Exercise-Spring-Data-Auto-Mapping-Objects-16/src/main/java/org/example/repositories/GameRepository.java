package org.example.repositories;

import org.example.entities.games.Game;
import org.example.entities.games.GameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE Game g " +
//            " SET g.price = g.price + :gamePrice " +
//            " WHERE g.id = :gameId")
//    int updatePriceById(
//            @Param("gameId") int id,
//            @Param("gamePrice") BigDecimal gamePrice);

}
