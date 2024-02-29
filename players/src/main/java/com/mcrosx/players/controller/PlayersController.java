package com.mcrosx.players.controller;

import com.mcrosx.players.constants.PlayerConstants;
import com.mcrosx.players.dto.PlayerDto;
import com.mcrosx.players.dto.ResponseDto;
import com.mcrosx.players.service.IPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/api",produces = {"application/json"})
@AllArgsConstructor
public class PlayersController {
    private IPlayerService iPlayerService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPlayer(@RequestBody PlayerDto playerDto) {
        iPlayerService.createPlayer(playerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PlayerConstants.STATUS_201,PlayerConstants.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<PlayerDto> fetchPlayerDetails(@RequestParam long playerId) {
        PlayerDto playerDto = iPlayerService.fetchPlayer(playerId);
        return ResponseEntity.status(HttpStatus.OK).body(playerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updatePlayerDetails(@RequestBody PlayerDto playerDto) {
        boolean isUpdated = iPlayerService.updatePlayer(playerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PlayerConstants.STATUS_200,PlayerConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(PlayerConstants.STATUS_417,PlayerConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deletePlayerDetails(@RequestParam Long playerId) {
        boolean isDeleted = iPlayerService.deletePlayer(playerId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PlayerConstants.STATUS_200,PlayerConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(PlayerConstants.STATUS_417,PlayerConstants.MESSAGE_417_DELETE));
        }
    }

}
