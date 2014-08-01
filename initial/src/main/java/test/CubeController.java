package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CubeController {

	@Autowired
    private CubesService cubesService;
	
    @RequestMapping("/cubes")
    public String greeting(@RequestParam(value="size1") int size1, 
    		@RequestParam(value="x1") int x1, 
    		@RequestParam(value="y1") int y1, 
    		@RequestParam(value="z1") int z1, 
    		@RequestParam(value="size2") int size2, 
    		@RequestParam(value="x2") int x2, 
    		@RequestParam(value="y2") int y2, 
    		@RequestParam(value="z2") int z2,
    		Model model) {
    	
    	Cube cube1 = new Cube(size1, x1,y1,z1);
    	Cube cube2 = new Cube(size2, x2,y2,z2);
    	
        model.addAttribute("cube1", cube1);
        model.addAttribute("cube2", cube2);
        
        model.addAttribute("areIntersected", cubesService.areIntersected(cube1, cube2));
        model.addAttribute("sharedVolume", cubesService.getSharedVolume(cube1, cube2));
        
        return "cubes";
    }
}