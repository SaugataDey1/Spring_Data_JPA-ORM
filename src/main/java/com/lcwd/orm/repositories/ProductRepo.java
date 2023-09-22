package com.lcwd.orm.repositories;

import com.lcwd.orm.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, String>
{
    /*

      //  1. Custom(Finder) Method
      // Rules :

    Optional<Product> findByProductName(String productName);
    Product findById(int pid);

    // Product findByProductNameIs(String productName);
    // Product findByProductNameEquals(String productName);
    Product findByProductNameIsNot(String productName);
    List<Product> findByProductNameIsNull();

    List<Product> findByActiveTrue();

  //  List<Product> findByActiveTrue(Pageable pageable);

    List<Product> findByActiveFalse();

    List<Product> findByProductNameStartingWith(String prefix);
    List<Product> findByProductNameEndingWith(String suffix);
    List<Product> findByProductNameContaining(String infix);

    String pattern="Samsung%";
    List<Product> findByProductNameLike(String pattern);

    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceLessThanEqual(double price);
    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByProductNameIn(Collection<String> names);
    List<Product> findByProductNameAndPrice(String name, double price);

    List<Product> findByProductNameOrPrice(String name, double price);

    Product findByProductNameOrderByProductNameAsc(String productName);
    Product findByProductNameOrderByProductNameDesc(String productName);


     */

  //  2. Query Methods

    // Query -->
       //  1.  JPQL (Java Persistent Query Language).
      //   2.  Native Query.

    // Select all Products with query
    // JPQL --> database independent query
    @Query(value = "SELECT p FROM Product p")
    List<Product> getAllProductWhileLearningJPA();


    @Query("SELECT p FROM Product p WHERE p.active = 1")
    List<Product> getAllActiveProducts();

    @Query("SELECT p FROM Product p WHERE p.pId = ?1 AND p.productName = ?2")
    Product getSingleProductByIdAndName1(int pId, String productName);


    // @Modifying  --> for updating
    @Query("SELECT p FROM Product p WHERE p.pId=:productId AND p.productName=:productName")
    Product getSingleProductByIdAndName2(@Param("productId") int productId,@Param("productName") String productName);


    // Native Queries ----------------------------------------------------------------------------------

    @Query(value = "select * from jpa_product where product_name=:productName", nativeQuery = true)
    Product getProductByIdAndNameNative(@Param("productName") String productName);
}
