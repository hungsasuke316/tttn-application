package ptit.example.tttnapplication.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ptit.example.tttnapplication.dto.response.FileUploadResponse;
import ptit.example.tttnapplication.exceptions.BadRequestException;
import ptit.example.tttnapplication.exceptions.InternalServerException;
import ptit.example.tttnapplication.services.CloudinaryService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public FileUploadResponse upload(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) throw new BadRequestException("File is not exist!!");
        try {
            File file = convert(multipartFile);
            Map<?, ?> resultMap = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return FileUploadResponse.builder()
                    .message("Upload to Cloudinary success")
                    .url(resultMap.get("url").toString())
                    .build();
        } catch (IOException ioException) {
            throw new InternalServerException(ioException.getMessage(), ioException);
        }

    }

    private File convert(MultipartFile multipartFile) {
        try {
            File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileOutputStream fOutputStream = new FileOutputStream(file);
            fOutputStream.write(multipartFile.getBytes());
            fOutputStream.close();
            return file;
        } catch (IOException ioException) {
            throw new InternalServerException(ioException.getMessage(), ioException);
        }
    }
}
