package com.mcrosx.players.mapper;

import com.mcrosx.players.dto.PlayerDto;
import com.mcrosx.players.entity.Player;

public class PlayerMapper {
    public static PlayerDto mapToPlayerDto(Player player, PlayerDto playerDto) {
        playerDto.setPlayerId((player.getPlayerId()));
        playerDto.setAge(player.getAge());
        playerDto.setName(player.getName());
        return playerDto;
    }

    public static Player mapToplayer(PlayerDto playerDto,Player player) {
        player.setPlayerId((playerDto.getPlayerId()));
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        return player;
    }
}
