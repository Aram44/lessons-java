package test;


/*
Вы — backend-разработчик в интернет-магазине.
Дела идут в гору и магазин решил повысить лояльность покупателей, предоставляя им персональные скидки.
К вам обратился product owner с задачей создать простую систему лояльности, которая предоставляет процентную скидку на корзину.
Размер скидки зависит от покупателя.
Аналитики уже определили, какие скидки должны быть предоставлены покупателям.


## Определения

Корзина - список покупок покупателя.

Покупка:
- id товара
- цена
- итоговая стоимость c учетом скидки

Скидка. Для покупателя может быть задан % скидки (целое число).


## Задача
Написать часть новой системы лояльности, которая:
- на вход получает id покупателя и корзину
- вычисляет и применяет скидки
- возвращает корзину, в которой учтены скидки. Скидка учитывается в стоимости покупки

*/


import java.util.UUID;

public class Products {
    private UUID id;
    private double price;
    private double finalPrice;

    public Products(double price) {
        if (price < 0 ) {
            throw new RuntimeException("price.is.negative");
        }
        this.price = price;
        this.finalPrice = price;
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
