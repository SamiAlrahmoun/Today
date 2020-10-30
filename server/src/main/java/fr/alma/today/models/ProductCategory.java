package fr.alma.today.models;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

