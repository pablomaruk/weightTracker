import java.util.ArrayList;
import java.util.Scanner;

class WeightEntry {
    private String date;
    private double weight;

    public WeightEntry(String date, double weight) {
        this.date = date;
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | Weight: " + weight + " kg";
    }
}

class WeightTracker {
    private ArrayList<WeightEntry> weightEntries;

    public WeightTracker() {
        this.weightEntries = new ArrayList<>();
    }

    public void addWeightEntry(WeightEntry entry) {
        weightEntries.add(entry);
    }

    public void displayWeightEntries() {
        System.out.println("----- Weight Entries -----");
        for (WeightEntry entry : weightEntries) {
            System.out.println(entry);
        }
        System.out.println("--------------------------");
    }

    public double getCurrentWeight() {
        if (!weightEntries.isEmpty()) {
            return weightEntries.get(weightEntries.size() - 1).getWeight();
        } else {
            return -1; // Default value indicating no entries yet
        }
    }

    public double getWeightChange() {
        if (weightEntries.size() >= 2) {
            double initialWeight = weightEntries.get(0).getWeight();
            double currentWeight = getCurrentWeight();
            return initialWeight - currentWeight;
        } else {
            return 0; // Default value indicating no significant change
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeightTracker weightTracker = new WeightTracker();

        while (true) {
            System.out.println("1. Add Weight Entry");
            System.out.println("2. Display Weight Entries");
            System.out.println("3. View Current Weight");
            System.out.println("4. View Weight Change");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter date (e.g., YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter weight (in kg): ");
                    double weight = scanner.nextDouble();
                    WeightEntry newEntry = new WeightEntry(date, weight);
                    weightTracker.addWeightEntry(newEntry);
                    System.out.println("Weight entry added: " + newEntry);
                    break;

                case 2:
                    weightTracker.displayWeightEntries();
                    break;

                case 3:
                    double currentWeight = weightTracker.getCurrentWeight();
                    if (currentWeight != -1) {
                        System.out.println("Current weight: " + currentWeight + " kg");
                    } else {
                        System.out.println("No weight entries yet.");
                    }
                    break;

                case 4:
                    double weightChange = weightTracker.getWeightChange();
                    if (weightChange != 0) {
                        System.out.println("Weight change: " + weightChange + " kg");
                    } else {
                        System.out.println("No significant weight change.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Weight Loss Progress Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
