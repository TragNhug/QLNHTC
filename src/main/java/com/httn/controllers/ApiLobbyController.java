/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.controllers;

import com.httn.pojo.Lobby;
import com.httn.service.LobbyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/api")
public class ApiLobbyController {
    @Autowired
    private LobbyService lobbyService;
    
    @GetMapping("/lobbies")
    public ResponseEntity<List<Lobby>> getLobbies() {
        return new ResponseEntity<>(this.lobbyService.getLobbies(null, 0), HttpStatus.OK);
    }
    @DeleteMapping("/lobbies/{lobbyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "lobbyId") int id) {
        this.lobbyService.deleteLobby(id);
    }
    
    @PostMapping(value= "/updateLobby/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lobby> getLobby(@PathVariable(value="id") int id ) {
        return new ResponseEntity<>(this.lobbyService.getLobbyById(id), HttpStatus.OK);
    }
    
}