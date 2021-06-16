package com.ProjectForGit.ProjectForGit.Repositories;


import com.ProjectForGit.ProjectForGit.ShopItem.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemsRepository extends JpaRepository<ShopItem,Integer> {
}

