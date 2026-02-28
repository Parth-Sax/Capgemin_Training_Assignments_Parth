package com.capge.dao;
import com.capge.entity.Player;

import java.util.List;
public interface PlayerDAO {
    void insertPlayer(Player player);
    void updatePlayer(Player player);
    void deletePlayer(int player_id);

}
