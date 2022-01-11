package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Size;
import at.sinclothing.backend.repo.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SizeServiceImpl implements SizeService{

    SizeRepository sizeRepository;

    List<Size> sizes = new ArrayList<>();

    public SizeServiceImpl(@Autowired SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
        fetchSizes();
    }

    @Override
    public void fetchSizes() {
        sizes = sizeRepository.findAll();
    }

    @Override
    public List<Size> getAllSizes() {
        return sizes;
    }

    @Override
    public List<Size> getSizesByProductId(Long productId) {
        return sizeRepository.findSizeByProductID(productId);
    }
}
