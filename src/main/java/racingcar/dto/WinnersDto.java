package racingcar.dto;

import java.util.List;

public class WinnersDto {
    List<String> winners;

    public WinnersDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
