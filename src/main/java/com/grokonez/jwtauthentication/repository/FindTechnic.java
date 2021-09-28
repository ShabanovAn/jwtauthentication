package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FindTechnic<T> extends JpaRepository<T, Long> {
    public List<T> findByEar(int ear);
    public List<T> findByModel(String model);
    public List<T> findByUser(User user);
    void deleteById(Long id);

    //#Имя класса
//    @Query(value = "select x from #{#entityName} as x where x.id > ?1")
//    public List<T> findAllOrderByModel(Long id);

//    @Query(value = "select x from #{#entityName} as x where x.id > :id")
//    public List<T> findAllOrderByModel(@Param("id") Long id);


}
