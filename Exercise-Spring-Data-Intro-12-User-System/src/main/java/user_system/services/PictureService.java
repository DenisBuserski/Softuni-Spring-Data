package user_system.services;

import user_system.entities.Album;

public interface PictureService {
    void createPicture(String title, String caption, String path, Album album);
}
