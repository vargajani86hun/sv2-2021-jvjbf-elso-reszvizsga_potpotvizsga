package redlion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RedLion {
    private String name;
    private List<Cup> cups = new ArrayList<>();
    private LocalTime openTime, closeTime;

    public RedLion(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        cups.add(new Cup("Kamillavirágzat", 1256, Sort.HERBAL_TEA));
        cups.add(new Cup("Cseresznyés álom", 1745, Sort.FRUIT_TEA));
    }

    public void addCup(Cup cup) {
        cups.add(cup);
    }

    public void setActionPrices(Sort sort, int percent) {
        for (Cup c: cups) {
            if (c.getSort() == sort) {
                c.setPrice((int) (c.getPrice() - (c.getPrice() * percent / 100.)));
            }
        }
    }

    public double getAveragePrice() {
        int sum = 0;
        for (Cup c: cups) {
            sum += c.getPrice();
        }
        return sum / (double) cups.size();
    }

    public String getName() {
        return name;
    }

    public List<Cup> getTeas() {
        return new ArrayList<>(cups);
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
