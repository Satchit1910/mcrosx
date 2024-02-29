package com.mcrosx.players.serviceImpl;

import com.mcrosx.players.dto.PlayerDto;
import com.mcrosx.players.entity.Player;
import com.mcrosx.players.exception.ResourceNotFoundException;
import com.mcrosx.players.mapper.PlayerMapper;
import com.mcrosx.players.repository.PlayerRepository;
import com.mcrosx.players.service.IPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service @AllArgsConstructor
public class PlayerServiceImplementation implements IPlayerService {
    private PlayerRepository playerRepository;

    /**
     *
     * @param playerDto - create Player
     */
    @Override
    public void createPlayer(PlayerDto playerDto) {
        Player player = PlayerMapper.mapToplayer(playerDto,new Player());
        player.setCreatedAt(LocalDateTime.now());
        player.setCreatedBy("Satchit");
        Player savedPlayer = playerRepository.save(player);
    }

    /**
     *
     * @param playerId
     * @return
     */
    @Override
    public PlayerDto fetchPlayer(long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player","player Id",Long.toString(playerId))
        );
        return PlayerMapper.mapToPlayerDto(player, new PlayerDto());
    }

    /**
     *
     * @param playerDto
     * @return
     */
    @Override
    public boolean updatePlayer(PlayerDto playerDto) {
        boolean isUpdated = false;
        if(playerDto!=null) {
            Player player = playerRepository.findById(playerDto.getPlayerId()).orElseThrow(
                    () -> new ResourceNotFoundException("Player","playerId",Long.toString(playerDto.getPlayerId()))
            );
            PlayerMapper.mapToplayer(playerDto,player);
            player = playerRepository.save(player);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deletePlayer(long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player","playerId",Long.toString(playerId))
        );
        playerRepository.deleteById(player.getPlayerId());
        return true;
    }
}
