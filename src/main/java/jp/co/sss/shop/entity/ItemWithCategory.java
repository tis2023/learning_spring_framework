package jp.co.sss.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

    @Entity
    @Table(name="item_with_categories")
    @NamedQuery(name="findByIdNamedQuery", query="SELECT i FROM ItemWithCategory i WHERE i.id = :id")
public class ItemWithCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items_with_categories_gen")
    @SequenceGenerator(name = "seq_items_with_categories_gen", sequenceName = "seq_items_with_categories", allocationSize = 1)
    private Integer id;
    
    @Column
    private String name;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public Integer getPrice() {
    return price;
    }

    public void setPrice(Integer price) {
    this.price = price;
    }

    public Category getCategory() {
    return category;
    }
    
    public void setCategory(Category category) {
    this.category = category;
    }
}