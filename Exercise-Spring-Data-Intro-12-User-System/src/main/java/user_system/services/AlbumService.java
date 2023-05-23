package user_system.services;

import org.springframework.stereotype.Service;
import user_system.entities.User;


public interface AlbumService {
    void createAlbum(String name, String backgroundColor, boolean isPublic, User user);
}
