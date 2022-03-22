package com.gabrielsantos.notificationsapi.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Product {

    PLAY_STATION_5(0, "PlayStation 5"),
    PLAY_STATION_4(1, "PlayStation 4"),
    XBOX_ONE(2, "Xbox One"),
    XBOX_SERIES_X(3, "Xbox Series X"),
    XBOX_SERIES_S(4, "Xbox Series S"),
    NINTENDO_SWITCH(5, "Nintendo Switch");

    private final Integer id;

    private final String description;

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

}
