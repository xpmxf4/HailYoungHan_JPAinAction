package jpabook.jpashop.domain.Item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //===생성자 메서드===//
    public void removeStock(int count) {
        this.stockQuantity -= count;
    }

    public void addStock(int count) {
        this.stockQuantity += count;
    }
}