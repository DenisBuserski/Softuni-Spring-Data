package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Album;
import user_system.entities.Picture;
import user_system.repositories.PictureRepository;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public void createPicture(String title, String caption, String path, Album album) {
        Picture picture = new Picture(title, caption, path, album);
        this.pictureRepository.save(picture);
    }
}
