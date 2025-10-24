package racingcar.model;

import java.util.Objects;
import static racingcar.common.constant.RacingGameStrategy.MINIMUM_MOVE_VALUE;
import static racingcar.common.constant.Validator.RACINGCAR_NAME_MAX_LENGTH;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_LENGTH_OVERFLOW;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName, int position) {

        if(carName.length() > RACINGCAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(RACINGCAR_NAME_LENGTH_OVERFLOW.getMessage());
        }

        this.carName = carName;
        this.position = position;
    }

    public void tryMoveForward(int inputNumber) {
        if (inputNumber >= MINIMUM_MOVE_VALUE) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public boolean isPositionGreaterOrEqualThan(int base) {
        return position >= base;
    }

    // Car객체에 대한 equal의 개념을 재정의
    @Override
    public boolean equals(Object o) {

        // 메모리 주소가 같으면 같음
        if (this == o) {
            return true;
        }

        // 클래스가 다르거나, null이면 다름
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 3. name과 position이 같으면 같은 객체
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }
}
