import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        WebConnection webConnection = new WebConnection();
        List<Double> iteration = new ArrayList<>();
        List<Double> price = new ArrayList<>();

        price.add(48502.8083);
        price.add(50422.1683);
        price.add(48365.145);
        price.add(48780.96);
        price.add(48887.0233);
        price.add(50985.9417);
        price.add(52393.36);

        iteration.add(0.0);
        iteration.add(1.0);
        iteration.add(2.0);
        iteration.add(3.0);
        iteration.add(4.0);
        iteration.add(5.0);
        iteration.add(6.0);
        iteration.add(7.0);
        Extrapolation extrapolation = new Extrapolation(iteration, price);

        price.add(extrapolation.extrapolate(0.6));
        System.out.println(price.toString());

        SwingUtilities.invokeLater(() -> GraphPanel.createAndShowGui(price));
    }
}
