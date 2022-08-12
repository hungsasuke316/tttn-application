package ptit.example.tttnapplication.services;

import org.springframework.web.multipart.MultipartFile;
import ptit.example.tttnapplication.dto.response.FileUploadResponse;

public interface CloudinaryService {
    FileUploadResponse upload(MultipartFile multipartFile);
}
