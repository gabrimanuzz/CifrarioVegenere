import static java.lang.IO.println;

void main(String[] args) {
        String text = "ciao sono gay";
        int[] shift = {2, 4, 6, 8};

        String cifrata = cifraTraduci(text, shift, true);
        String decifrata = cifraTraduci(cifrata, shift, false);

        println("Cifrato: " + cifrata);
        println("Decifrato: " + decifrata);
    }


    // mode = true (cifra) | mode = false (traduci)
    static String cifraTraduci(String text, int[] shift, boolean mode) {
        for (int i = 0; i < shift.length; i++) {
            shift[i] = shift[i] % 94;
            shift[i] = mode ? shift[i] : -shift[i];
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int ascii = (int) c;

            ascii = (ascii - 32 + shift[i % shift.length] + 94) % 94 + 32;

            result.append((char) ascii);
        }

        return result.toString();
    }