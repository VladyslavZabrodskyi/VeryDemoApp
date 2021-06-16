package com.ProjectForGit.ProjectForGit.ShopItem;

import com.ProjectForGit.ProjectForGit.Repositories.ShopItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopItemService {
    private static List<ShopItem> shopItems;
    private  final ShopItemsRepository shopItemsRepository;

    public ShopItemService(ShopItemsRepository shopItemsRepository) {
        this.shopItemsRepository = shopItemsRepository;
        findAll();
    }

    public List<ShopItem> findAll(){
        shopItems=shopItemsRepository.findAll();
        System.out.println(shopItemsRepository.findAll());
        return shopItems;
    }

    public static void addItem(ShopItem shopItem){
        shopItems.add(shopItem);
    }


    public static List<ShopItem> getShopItems() {
        return shopItems;
    }
}
