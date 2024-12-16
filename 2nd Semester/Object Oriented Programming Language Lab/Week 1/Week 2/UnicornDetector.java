public class UnicornDetector {
    public static void main(String[] args) {
        boolean isUnicorn = true; // Assume it's a unicorn by default

        // Check for rainbow presence
        boolean hasRainbow = true; // You can't have a unicorn without rainbows!
        if (!hasRainbow) {
            isUnicorn = false;
        }

        // Check for sparkles
        boolean hasSparkles = true; // Essential unicorn feature
        if (!hasSparkles) {
            isUnicorn = false;
        }

        // Final verdict
        if (isUnicorn) {
            System.out.println("Congratulations! It's a unicorn!");
        } else {
            System.out.println("Hmm, not quite a unicorn. Keep searching!");
        }
    }
}
