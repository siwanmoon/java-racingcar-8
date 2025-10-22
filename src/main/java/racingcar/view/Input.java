package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getInput() {
        String input = Console.readLine().trim();
        Console.close();
        return input;
    }
}
