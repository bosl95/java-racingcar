package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(","); // split 함수가 잘 실행되는 지 확인
        // assertThat(values[0]).isEqualTo("1");
        // assertThat(values[1]).isEqualTo("2");

        assertThat(values).containsExactly("1", "2");   // 한번에 체크하기

        // error
        // assertThat(values[0]).isEqualTo("2");
        // assertThat(values[1]).isEqualTo("1");
    }

    @Test
    void substring() {
        String values = "(1,2)".substring(1, 4);
        assertThat(values).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져오는 메소드")
    @Test
    void valueOfSuccess() {
        int index = 2;  // 3번째 위치의 문자를 가져온다.
        String search = "abc".substring(index, index + 1);
        assertThat(search).isEqualTo("c");
    }

    @DisplayName("잘못된 위치의 문자를 가져오는 경우")
    @Test
    void valueOfFail() {
        int index = 5;  // 5번째 위치의 문자를 가져온다.
        assertThatThrownBy(() -> {
            String search = "abc".substring(index, index + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 6");
    }
}