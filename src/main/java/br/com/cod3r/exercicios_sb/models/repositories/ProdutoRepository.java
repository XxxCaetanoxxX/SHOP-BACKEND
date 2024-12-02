package br.com.cod3r.exercicios_sb.models.repositories;

import br.com.cod3r.exercicios_sb.models.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto,Integer>, JpaRepository<Produto,Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);

    //findByNomeStartsWith
    //findByNomeEndsWith
    //findByNomeNotContaining

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public Iterable<Produto> searchByNameLike(String nome);
}
