package racingcar.domain.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidTextException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.data.Name.validateName;

class NameTest {
    int maxLength = 5;

    @Test
    public void 이름에_공백이_들어가면_자동_제거() {
        Name name = new Name("pobi ");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "brown"})
    public void 정상_입력_시(String name) {
        validateName(name, maxLength);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi#", "bro."})
    public void 문자_외의_입력_시_예외처리(String name) {
        assertThatThrownBy(() -> validateName(name, maxLength))
                .isInstanceOf(InvalidTextException.class);
    }
}