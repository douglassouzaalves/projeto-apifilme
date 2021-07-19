package br.com.projetox.model;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface FilmeMapper {

    @Insert("INSERT INTO filmes(titulo, oscar, produtor, estreia, produtora) "
            + "VALUES (#{titulo},#{oscar},#{produtor},#{estreia},#{produtora})")
    @Options(keyColumn = "filmeid", keyProperty = "filmeid", useGeneratedKeys = true)
    int insert(Filme filme);

    @Update("UPDATE filmes SET titulo=#{titulo}, oscar=#{oscar},"
            + "produtor=#{produtor}, estreia=#{estreia}, produtora=#{produtora} WHERE filmeid=#{filmeid}")
    int update(Filme filme);

    @Select("SELECT filmeid AS filmeid,titulo, oscar, produtor, estreia, produtora FROM filmes")
    List<Filme> select();

    @Delete("DELETE FROM filmes WHERE filmeidd=#{filmeid}")
    int delete(Long filmeId);
}
