package com.demo.book.repository;

import com.demo.book.model.Bulletin;
import org.springframework.stereotype.Repository;


@Repository
public interface BulletinMapper {
    int deleteByPrimaryKey(Integer bltid);

    int insert(Bulletin record);

    int insertSelective(Bulletin record);

    Bulletin selectByPrimaryKey(Integer bltid);

    int updateByPrimaryKeySelective(Bulletin record);

    int updateByPrimaryKey(Bulletin record);

    Bulletin[] getTop3Bulletins();

    Bulletin[] getAllBulletins();
}
