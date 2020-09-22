package com.example.es.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhwu(zhwu @ tmindtech.com)
 */
public class CoinExcel implements Serializable {
    @Excel(name = "用户账号")
    private String userName;
    @Excel(name = "调账金额", type = 10)
    private Long changeAmount;
    @Excel(name = "时间")
    private Date createTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(Long changeAmount) {
        this.changeAmount = changeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CoinExcel{" +
                "userName='" + userName + '\'' +
                ", changeAmount=" + changeAmount +
                ", createTime=" + createTime +
                '}';
    }
}
