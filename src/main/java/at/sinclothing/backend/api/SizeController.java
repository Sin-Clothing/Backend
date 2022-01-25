package at.sinclothing.backend.api;

import at.sinclothing.backend.pojos.Size;
import at.sinclothing.backend.repo.SizeRepository;
import at.sinclothing.backend.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT})

public class SizeController {

    @Autowired
    private SizeService sizeService;

    @GetMapping()
    public List<Size> sizes(@RequestParam Long productId){
        return sizeService.getSizesByProductId(productId);
    }
    @GetMapping("testSize")
    String test() {
        return "Sünden sind periodisch und wiederkehrend. Sizes";
    }

    @GetMapping("sizes")
    public List<Size> getAllSizes(){
        return sizeService.getAllSizes();
    }

}
