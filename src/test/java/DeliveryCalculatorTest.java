import org.example.DeliveryCalculator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("DeliveryCalculatorTests")
public class DeliveryCalculatorTest {

    @Test
    public void testCalculateDeliveryCost() {

        int distance = 35;
        boolean largeSize = true;
        boolean fragile = false;
        double loadFactor = 1.4;

        int actualCost = DeliveryCalculator.calculateDeliveryCost(distance, largeSize, fragile, loadFactor);

        assertEquals(740, actualCost);
    }

    @ParameterizedTest
    @CsvSource({
            "35, true, false, 1.4, 740",
            "25, false, true, 1.4, 720",
            "5, true, false, 1.4, 640",
            "2, false, false, 1.4, 560",
            "35, true, true, 1.4, 1040",
            "35, true, true, 1.6, 1120"
    })
    public void testCalculateDeliveryCost_Parametrized(int distance, boolean largeSize, boolean fragile, double loadFactor, int expectedCost) {

        int actualCost = DeliveryCalculator.calculateDeliveryCost(distance, largeSize, fragile, loadFactor);

        assertEquals(expectedCost, actualCost);
    }
}

