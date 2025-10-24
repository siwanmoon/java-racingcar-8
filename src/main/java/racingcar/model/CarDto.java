package racingcar.model;

public record CarDto(String carName, int position) {

    public static CarDto from(Car car) {
        return new CarDto(car.getCarName(), car.getPosition());
    }
}
