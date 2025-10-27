package racingcar.model.firstclasscollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarDto;
import java.util.List;
import java.util.function.Supplier;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.RacingGameStrategy.FINISHLINE_POSITION;

class RaceParticipantsTest {

    private static final int FINISH_LINE = FINISHLINE_POSITION;

    private Car pobi;
    private Car woni;
    private Car jun;
    private Car sam;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi", 5);
        woni = new Car("woni", 3);
        jun = new Car("jun", 5);
        sam = new Car("sam", FINISHLINE_POSITION);
    }

    @Test
    void 결승선_통과한_차가_없으면_false를_반환한다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni, jun));
        assertFalse(participants.crossFinishline());
    }

    @Test
    void 결승선_통과한_차가_있으면_true를_반환한다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni, sam));
        assertTrue(participants.crossFinishline());
    }

    @Test
    void 모든_차가_전진_조건을_만족하면_모두_움직인다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni));
        Supplier<Integer> alwaysMoveStrategy = () -> 4;

        participants.tryMove(alwaysMoveStrategy);
        List<CarDto> expected = List.of(
                CarDto.from(new Car("pobi", 6)), // pobi 5 -> 6
                CarDto.from(new Car("woni", 4))  // woni 3 -> 4
        );

        assertThat(participants.getParticipantsDto()).containsExactlyElementsOf(expected);
    }

    @Test
    void 어떤_차도_전진_조건을_만족하지_못하면_아무도_움직이지_않는다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni));
        Supplier<Integer> alwaysStopStrategy = () -> 3;

        participants.tryMove(alwaysStopStrategy);
        List<CarDto> expected = List.of(
                CarDto.from(new Car("pobi", 5)), // pobi 5 -> 5
                CarDto.from(new Car("woni", 3))  // woni 3 -> 3
        );

        assertThat(participants.getParticipantsDto()).containsExactlyElementsOf(expected);
    }

    @Test
    void 일부_차만_전진_조건을_만족하면_해당_차만_움직인다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni));
        Supplier<Integer> mixedStrategy = new Supplier<>() {
            private int count = 0;
            @Override
            public Integer get() {
                return (count++ == 0) ? 4 : 3; // 첫 호출 4, 두번째 호출 3
            }
        };

        participants.tryMove(mixedStrategy);

        List<CarDto> expected = List.of(
                CarDto.from(new Car("pobi", 6)), // pobi 5 -> 6
                CarDto.from(new Car("woni", 3))  // woni 3 -> 3
        );
        assertThat(participants.getParticipantsDto()).containsExactlyElementsOf(expected);
    }

    @Test
    void 현재_참가자_상태를_DTO_리스트로_올바르게_반환한다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni));
        List<CarDto> dtos = participants.getParticipantsDto();

        List<CarDto> expected = List.of(
                CarDto.from(pobi), // CarDto.of("pobi", 5)와 같음
                CarDto.from(woni)  // CarDto.of("woni", 3)와 같음
        );

        assertThat(dtos).containsExactlyElementsOf(expected);
    }

    @Test
    void 단독_우승자가_있을_경우_해당_우승자_DTO만_반환한다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni));
        List<CarDto> winners = participants.getRoundWinnersDto();
        List<CarDto> expected = List.of(CarDto.from(pobi));
        assertThat(winners).containsExactlyElementsOf(expected);
    }

    @Test
    void 공동_우승자가_있을_경우_모든_우승자_DTO를_반환한다() {
        RaceParticipants participants = new RaceParticipants(List.of(pobi, woni, jun));
        List<CarDto> winners = participants.getRoundWinnersDto();
        List<CarDto> expected = List.of(
                CarDto.from(pobi),
                CarDto.from(jun)
        );

        assertThat(winners).containsExactlyInAnyOrderElementsOf(expected);
    }
}
