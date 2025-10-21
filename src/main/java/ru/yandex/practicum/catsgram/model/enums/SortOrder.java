package ru.yandex.practicum.catsgram.model.enums;

public enum SortOrder {
    ASCENDING,
    DESCENDING;

    // Преобразует строку в элемент перечисления
    public static SortOrder from(String order) {
        if (order == null) {
            return DESCENDING; // значение по умолчанию
        }
        return switch (order.toLowerCase()) {
            case "ascending", "asc" -> ASCENDING;
            case "descending", "desc" -> DESCENDING;
            default -> throw new IllegalArgumentException(
                    "Некорректное значение sort: " + order + ". Используйте asc или desc."
            );
        };
    }
}
