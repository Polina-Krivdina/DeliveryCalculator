package org.example;

public class DeliveryCalculator {

    public static void main(String[] args) {
        int distance = 35; // Расстояние до пункта назначения в километрах
        boolean largeSize = true; // Признак больших габаритов груза
        boolean fragile = false; // Признак хрупкости груза
        double loadFactor = 1.4; // Коэффициент загруженности службы доставки

        int deliveryCost = calculateDeliveryCost(distance, largeSize, fragile, loadFactor);
        System.out.println("Стоимость доставки: " + deliveryCost + " рублей");
    }

    public static int calculateDeliveryCost(int distance, boolean largeSize, boolean fragile, double loadFactor) {
        int cost = 0;

        // Рассчет стоимости в зависимости от расстояния
        if (distance > 30) {
            cost += 300;
        } else if (distance > 10) {
            cost += 200;
        } else if (distance > 2) {
            cost += 100;
        } else {
            cost += 50;
        }

        // Дополнительная стоимость за большие габариты
        if (largeSize) {
            cost += 200;
        } else {
            cost += 100;
        }

        // Дополнительная стоимость за хрупкий груз
        if (fragile && distance <= 30) {
            cost += 300;
        }

        // Учет загруженности службы доставки
        cost *= loadFactor;

        // Учет минимальной стоимости доставки
        cost = Math.max(cost, 400);

        return cost;
    }
}

