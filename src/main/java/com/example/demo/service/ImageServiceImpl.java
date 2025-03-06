package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import com.example.demo.entity.Image;
import com.example.demo.entity.Item;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ImageServiceImpl implements ImageService{

    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;
    private final FileService fileService;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override // 등록
    public ImageDTO imageRegister(Long item_id, String repimgYn, MultipartFile multipartFile) throws IOException {

        ImageDTO imgDTO = fileService.uploadFile(multipartFile);

        Image image = modelMapper.map(imgDTO, Image.class);

        Item item = itemRepository.findById(item_id).orElseThrow(EntityNotFoundException::new);

        Image img = null;

        if (repimgYn != null){
            img = imageRepository.findByItemIdAndRepimgYn(item.getId(), repimgYn);
        }

        if (img != null){
            String path = img.getIurl() + img.getImgName();
            fileService.del(path);

            img.setIurl(imgDTO.getIurl());
            img.setImgName(imgDTO.getImgName());
            img.setOrimgName(imgDTO.getOrimgName());
        }else {
            image.setRepimgYn(repimgYn);
            image.setItem(item);

            image = imageRepository.save(image);
            imgDTO = modelMapper.map(image , ImageDTO.class);
        }
        return imgDTO;
    }

}
