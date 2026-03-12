public class NestedIfAdvanced {

    static String shipmentStatus(double weight, String destination, boolean paid) {
        if (!paid) {
            return "HOLD: Payment required";
        }
        if (destination.equals("Domestic")) {
            if (weight <= 5)        return "Domestic Standard (3 days)";
            else if (weight <= 20)  return "Domestic Freight (5 days)";
            else                    return "Domestic Heavy Freight (7 days)";
        } else if (destination.equals("International")) {
            if (weight <= 2)        return "International Express (5 days)";
            else if (weight <= 10)  return "International Standard (14 days)";
            else                    return "International Freight (21 days)";
        }
        return "Unknown destination";
    }

    static String loanDecision(int creditScore, double income, double requestedAmount) {
        if (creditScore < 580) {
            return "DENIED — credit score too low";
        }
        if (income < 20_000) {
            return "DENIED — insufficient income";
        }
        double ratio = requestedAmount / income;
        if (creditScore >= 750) {
            if (ratio <= 5.0)  return "APPROVED — Premium rate 3.5%";
            else               return "APPROVED — Premium rate 4.0% (high ratio)";
        } else if (creditScore >= 650) {
            if (ratio <= 3.0)  return "APPROVED — Standard rate 6.0%";
            else               return "CONDITIONAL — reduce amount by 20%";
        } else {
            if (ratio <= 1.5)  return "APPROVED — Subprime rate 9.5%";
            else               return "DENIED — too risky at this amount";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Shipment Routing ===");
        System.out.println(shipmentStatus(1.5, "Domestic", true));
        System.out.println(shipmentStatus(25,  "Domestic", true));
        System.out.println(shipmentStatus(3.0, "International", true));
        System.out.println(shipmentStatus(5.0, "International", false));

        System.out.println("\n=== Loan Decision Engine ===");
        System.out.println(loanDecision(800, 75_000, 200_000));
        System.out.println(loanDecision(700, 50_000, 100_000));
        System.out.println(loanDecision(620, 40_000, 200_000));
        System.out.println(loanDecision(550, 30_000,  50_000));
        System.out.println(loanDecision(660, 15_000,  20_000));
    }
}
