package ee.sergei.lemmikloomad.controller;

import ee.sergei.lemmikloomad.entities.Owner;
import ee.sergei.lemmikloomad.service.OwnerService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("owner/add") // localhost:8080/owner/add?name=Omanik
    public void addOwner(
            @RequestParam("name") String name) {
        ownerService.addOwner(name);
    }

}
