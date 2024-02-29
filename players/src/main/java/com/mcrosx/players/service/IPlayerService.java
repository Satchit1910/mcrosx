package com.mcrosx.players.service;

import com.mcrosx.players.dto.PlayerDto;

public interface IPlayerService {
    /**
     *
     * @param playerDto
     */
    void createPlayer(PlayerDto playerDto);

    /**
     *
     * @param playerId
     * @return
     */
    PlayerDto fetchPlayer(long playerId);

    /**
     *
     * @param playerDto
     * @return
     */
    boolean updatePlayer(PlayerDto playerDto);

    /**
     *
     * @param playerId
     * @return
     */
    boolean deletePlayer(long playerId);
}
