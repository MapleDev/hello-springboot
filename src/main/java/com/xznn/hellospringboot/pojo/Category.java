package com.xznn.hellospringboot.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Entity 注解表示这是个实体类
 * @Table(name = "category_") 表示这个类对应的表名是 category_ ，注意有下划线哦
 * @Id 表明主键
 * @GeneratedValue(strategy = GenerationType.IDENTITY) 表明自增长方式
 * @Column(name = "id") 表明对应的数据库字段名
 */
@Entity
@Table(name = "category_")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
