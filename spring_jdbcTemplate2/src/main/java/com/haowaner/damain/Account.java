package com.haowaner.damain;

/**
 * 账户实体类
 */
public class Account {
    private int id;//账户主键
    private String name;//账户名字
    private Double money;//账户金额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
