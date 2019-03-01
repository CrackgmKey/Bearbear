package com.lingjuan.app.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 历史搜索记录
 * Created by TaoHui on 2018/10/17.
 */
@Entity
public class HistoryRzy {
   @Id(autoincrement = true)
    private Long id;
    private String userId;
    private String message;
    @Generated(hash = 947808256)
    public HistoryRzy(Long id, String userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }
    @Generated(hash = 217001168)
    public HistoryRzy() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
