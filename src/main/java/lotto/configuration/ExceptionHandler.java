package lotto.configuration;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T retryOrGet(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
