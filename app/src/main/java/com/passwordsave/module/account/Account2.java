package com.passwordsave.module.account;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
//本地room数据库实体类
@Entity
public class Account2  {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String account;
    public String password;
    public String remark;
    public boolean isCollect;

    @Ignore
    public transient boolean isShow = false;

    @Ignore
    @Override
    public String toString() {
        return "Account2{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", isCollect=" + isCollect +
                ", isShow=" + isShow +
                '}';
    }
}
