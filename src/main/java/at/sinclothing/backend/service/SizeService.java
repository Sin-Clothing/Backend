package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Size;

import java.util.List;

public interface SizeService {

    void fetchSizes();

    List<Size> getAllSizes();

    List<Size> getSizesByProductId(Long productId);
}
