package com.demo.book.repository;

import com.demo.book.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    Book[] getTop4SalesBooksThisWeek();

    Book[] getTopXSalesBooks(Integer amount);

    String[] getCategories();

    Book[] getAllBooks();

    Book[] getSearchBooks(String keyword);

    Integer getBooksCount();

    Book[] getBooksFromX(Integer index);
}
