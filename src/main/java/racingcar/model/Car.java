package racingcar.model;

import java.util.Objects;

public class Car {

    private final String carName;
    private final int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = 0;
    }

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
