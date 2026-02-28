package com.capge.dao;

import com.capge.entity.Player;
import com.capge.repository.PlayerRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlayerDAOImpl implements PlayerDAO{
    public void insertPlayer(Player player) {
        String sql = "INSERT INTO player VALUES(?, ?, ?)";

        try(Connection conn = PlayerRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, player.getPlayerId());
            pstmt.setString(2, player.getPlayerName());
            pstmt.setString(3, player.getPlayerCountry());

            pstmt.executeUpdate();
            System.out.println("Player Inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer(Player player) {
        String sql = "UPDATE player SET player_name = ?, player_country = ? WHERE player_id = ?";

        try (Connection conn = PlayerRepository.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, player.getPlayerName());
            pstmt.setString(2, player.getPlayerCountry());
            pstmt.setInt(3, player.getPlayerId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Player Updated Successfully");
            } else {
                System.out.println("Player Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(int playerId) {

        String sql = "DELETE FROM player WHERE player_id = ?";

        try (Connection conn = PlayerRepository.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, playerId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Player Deleted Successfully");
            } else {
                System.out.println("Player Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
