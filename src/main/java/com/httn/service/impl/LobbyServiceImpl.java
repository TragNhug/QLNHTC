/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.httn.service.impl;

import com.httn.pojo.Lobby;
import com.httn.repository.LobbyRepository;
import com.httn.service.LobbyService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class LobbyServiceImpl implements LobbyService {

    @Autowired
    private LobbyRepository lobbyRepository;

    @Override
    public List<Lobby> getLobbies(Map<String, String> params, int page) {
        return this.lobbyRepository.getLobbies(params, page);
    }

    @Override
    public int countLobby() {
        return this.lobbyRepository.countLobby();
    }

    @Override
    public boolean addLobby(Lobby l) {

        l.setImage("https://asiana-plaza.com/wp-content/uploads/2021/03/trang-tri-sanh-tiec-cuoi-dep-3.jpg");

        return this.lobbyRepository.addLobby(l);
    }

    @Override
    public boolean deleteLobby(int id) {
        return this.lobbyRepository.deleteLobby(id);
    }

    @Override
    public Lobby getLobbyById(int id) {
        return this.lobbyRepository.getLobbyById(id);
    }

    @Override
    public Boolean updateLobby(Lobby l) {
        l.setImage("https://asiana-plaza.com/wp-content/uploads/2021/03/trang-tri-sanh-tiec-cuoi-dep-3.jpg");
         return this.lobbyRepository.updateLobby(l);
    }
}
