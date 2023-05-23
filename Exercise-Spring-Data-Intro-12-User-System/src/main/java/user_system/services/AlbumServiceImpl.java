package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Album;
import user_system.entities.User;
import user_system.repositories.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public void createAlbum(String name, String backgroundColor, boolean isPublic, User user) {
        Album album = new Album(name, backgroundColor, isPublic, user);
        this.albumRepository.save(album);
    }
}
