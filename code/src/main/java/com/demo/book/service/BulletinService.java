package com.demo.book.service;

import com.demo.book.repository.BulletinMapper;
import com.demo.book.model.Bulletin;
import org.springframework.stereotype.Service;

@Service
public class BulletinService {

    private final BulletinMapper bulletinMapper;

    public BulletinService(BulletinMapper bulletinMapper) {
        this.bulletinMapper = bulletinMapper;
    }

    public int deleteByPrimaryKey(Integer bltid) {
        return bulletinMapper.deleteByPrimaryKey(bltid);
    }

    public int insertSelective(Bulletin record) {
        return bulletinMapper.insertSelective(record);
    }

    public Bulletin selectByPrimaryKey(Integer bltid) {
        return bulletinMapper.selectByPrimaryKey(bltid);
    }

    public Bulletin[] getTop3Bulletins() {
        return bulletinMapper.getTop3Bulletins();
    }

    public Bulletin[] getAllBulletins() {
        return bulletinMapper.getAllBulletins();
    }

    public void changeBulletin(Integer bltid, String content, Boolean valid) {
        Bulletin bulletin = bulletinMapper.selectByPrimaryKey(bltid);
        bulletin.setContent(content);
        bulletin.setValid(valid);
        bulletinMapper.updateByPrimaryKey(bulletin);
    }
}
