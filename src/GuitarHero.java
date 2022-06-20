public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] gArray = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            gArray[i] = new GuitarString(440.0 * Math.pow(2, (i - 24) / 12.0));
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {

                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    int index = keyboard.indexOf(key);
                    gArray[index].pluck();
                }
            }

            double sample = 0;
            for (GuitarString str : gArray) {
                sample += str.sample();
            }

            StdAudio.play(sample);
            for (GuitarString s : gArray) {
                s.tic();
            }

        }
    }
}
