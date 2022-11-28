package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.entities.VoitureEntity;
import de.tekup.jpademo.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures/ui")
@AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;
//    @GetMapping("/")
//    public String displayAllCars(Model model){
//        model.addAttribute("voitures",voitureService.getAllVoitures());
//        return "car";
//    }

    @GetMapping("/")
    public String displayAllCarsByPage(Model model,@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<VoitureEntity> voiturePage = voitureService.getPageVoitures(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("voiturePage", voiturePage);

        int totalPages = voiturePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "car";
    }

    @GetMapping("/add")
    public String clientAdd(Model model){
        model.addAttribute("voiture",new VoitureEntity());
        return "car-add";
    }

    @PostMapping("/add")
    public String clientAddPost(@Valid @ModelAttribute("voiture") VoitureEntity voiture,
                                BindingResult result, @RequestParam("fileImg")MultipartFile multipartFile){

        if(result.hasErrors()){
            return "car-add";
        }
        voitureService.insertIntoDB(voiture);
        if (!multipartFile.isEmpty()){
            String orgFileName = multipartFile.getOriginalFilename();
            String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
            String fileName = "voiture-"+voiture.getId()+ext;
            String uploadFolder = "src/main/resources/static/uploads/voitures";
            try {
                Path path = Path.of(uploadFolder, fileName);
                Files.write(path,multipartFile.getBytes());
                voiture.setImagePath("/uploads/voitures/"+fileName);
                voitureService.insertIntoDB(voiture);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return "redirect:/voitures/ui/";
    }
}
