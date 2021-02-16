package racingcar.domain.data;

import racingcar.utils.exception.InvalidTimeException;

import java.util.regex.Pattern;

public class Time {
    private final int value;

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public Time(final String value) {
        validateTime(value);
        this.value = Integer.parseInt(value);
    }

    public boolean isOver(final int value) {
        return this.value == value;
    }

    public static void validateTime(String value) {
        if (value.equals("0") || !NUMBER_PATTERN.matcher(value).matches()) {
            throw new InvalidTimeException();
        }
    }
}
