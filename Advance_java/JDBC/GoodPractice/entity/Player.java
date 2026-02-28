package com.capge.entity;

public class Player {
    private int player_id;
    private String player_name;
    private String player_country;

    public Player(int player_id, String player_name, String player_country) {
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_country = player_country;
    }

    public int getPlayerId() {
        return player_id;
    }

    public String getPlayerName() {
        return player_name;
    }

    public String getPlayerCountry() {
        return player_country;
    }
}
