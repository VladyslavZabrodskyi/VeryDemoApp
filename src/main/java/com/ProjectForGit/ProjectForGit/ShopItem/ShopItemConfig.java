package com.ProjectForGit.ProjectForGit.ShopItem;


import com.ProjectForGit.ProjectForGit.Repositories.ShopItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShopItemConfig {


    @Bean
    CommandLineRunner commandLineRunner(ShopItemsRepository shopItemsRepository){
        ShopItemService.addItem(new ShopItem( 1,
                "Easter",
                "style/box13east.JPG",
                "Весняний комплімент",
                "з ароматним чаєм і смаколиками",
                195));
        ShopItemService.addItem(new ShopItem(  2,
                "Easter",
                "style/box15east.JPG",
                "Ніжні барви",
                "з тематичними деталями і смаколиками",
                175));
        ShopItemService.addItem(new ShopItem( 3,
                "Easter",
                "style/box8east.JPG",
                "Весняний пакунок",
                "чай, тематичні пряники, смаколики",
                225));
        return args -> {
            shopItemsRepository.saveAll(
                    List.of(
                            new ShopItem( 1,
                                    "Easter",
                                    "style/box13east.JPG",
                                    "Весняний комплімент",
                                    "з ароматним чаєм і смаколиками",
                                    195),
                            new ShopItem(  2,
                                    "Easter",
                                    "style/box15east.JPG",
                                    "Ніжні барви",
                                    "з тематичними деталями і смаколиками",
                                    175),
                            new ShopItem( 3,
                                    "Easter",
                                    "style/box8east.JPG",
                                    "Весняний пакунок",
                                    "чай, тематичні пряники, смаколики",
                                    225)
                    )
            );
        };
    }
}
