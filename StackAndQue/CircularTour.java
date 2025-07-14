public class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Function to find the starting pump index
    public static int findStartingPump(PetrolPump[] pumps) {
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, currSurplus = 0;

        for (int i = 0; i < pumps.length; i++) {
            totalPetrol += pumps[i].petrol;
            totalDistance += pumps[i].distance;

            currSurplus += pumps[i].petrol - pumps[i].distance;

            // If at any point current surplus is negative, reset start
            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }

        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int startIndex = findStartingPump(pumps);

        if (startIndex != -1) {
            System.out.println("Start at pump index: " + startIndex);
        } else {
            System.out.println("No valid starting point exists.");
        }
    }
}
