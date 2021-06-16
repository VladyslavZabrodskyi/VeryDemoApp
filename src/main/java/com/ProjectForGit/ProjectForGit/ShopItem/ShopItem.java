package com.ProjectForGit.ProjectForGit.ShopItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShopItem {
    @Id
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String itemClass;

    @Column(columnDefinition = "TEXT")
    private String imagePath;

    @Column(columnDefinition = "TEXT")
    private String itemName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private Integer price;

    public ShopItem(Integer id, String itemClass, String imagePath, String itemName, String description, Integer price) {
        this.id = id;
        this.itemClass = itemClass;
        this.imagePath=imagePath;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }
}
