package com.jnfong.board;

import com.jnfong.cards.*;

/*
    Card ID's:
        0 - Wheat Field
        1 - Ranch
        2 - Forest
        3 - Mine
        4 - Apple Orchard
        5 - Bakery
        6 - Convenience Store
        7 - Cheese Factory
        8 - Furniture Factory
        9 - Fruit and Vegetable Market
        10 - Cafe
        11 - Family Restaurant
        12 - Stadium
        13 - TV Station
        14 - Business Center
 */
public class CardFactory {

    public static Card generate(int cardId) {
        switch (cardId) {
            case 0:
                return new WheatField();
            case 1:
                return new Ranch();
            case 2:
                return new Forest();
            case 3:
                return new Mine();
            case 4:
                return new AppleOrchard();
            case 5:
                return new Bakery();
            case 6:
                return new ConvenienceStore();
            case 7:
                return new CheeseFactory();
            case 8:
                return new FurnitureFactory();
            case 9:
                return new FruitVegetableMarket();
            case 10:
                return new Cafe();
            case 11:
                return new FamilyRestaurant();
            case 12:
                return new Stadium();
            case 13:
                return new TvStation();
            case 14:
                return new BusinessCenter();
            default:
                return new WheatField();
        }
    }
}
