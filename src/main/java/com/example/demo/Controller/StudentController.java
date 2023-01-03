package com.example.demo.Controller;

import com.example.demo.Model.BEAN.Class;
import com.example.demo.Model.BEAN.Student;
import com.example.demo.Model.BO.ClassService;
import com.example.demo.Model.BO.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;
    @GetMapping("/ListStudent")
    public String home(Model model,@RequestParam(name = "idClass", required = false,defaultValue = "0") Integer idClass){
        model.addAttribute("ListStudent",idClass!=0?studentService.FindStudentByIDClass(idClass):studentService.FindAllStudent());
        model.addAttribute("ListClass",classService.findAll());
        return "ListStudent";
    }
    @GetMapping("/DetailClass")
    public String DetailClass(Model model, @RequestParam(name = "class") Integer IDClass ){
        model.addAttribute("ListStudent",studentService.FindStudentByIDClass(IDClass));
        return "DetailClass";
    }
    @GetMapping("/AddStudent")
    public String AddStudent(Model model){
        model.addAttribute("ListClass",classService.findAll());
        return "AddStudent";
    }
    @PostMapping("/AddStudent")
    public String AddStudent1(Model model, @RequestParam Map<String, Objects> params){
        int idClass = (Integer.parseInt(String.valueOf(params.get("class"))));

        studentService.AddStudent(String.valueOf(params.get("name")),classService.findByIDClass(idClass));
        return home(model,0);
    }
    @GetMapping("/UpdateStudent")
    public String UpdateStudent(Model model, @RequestParam(name = "id")Integer id){
        model.addAttribute("Student",studentService.findById(id));
        model.addAttribute("ListClass",classService.findAll());
        return "UpdateStudent";
    }
    @PostMapping("/UpdateStudent")
    public String Update(Model model, @RequestParam Map<String, Objects> params){
        Student temp = new Student();
        temp.setId(Integer.parseInt(String.valueOf(params.get("id"))));
        temp.setName(String.valueOf(params.get("name")));
        temp.setAclass(classService.findByIDClass(Integer.parseInt(String.valueOf(params.get("class")))));
        studentService.UpdateStudent(temp);
        return home(model,0);
    }
    @GetMapping("/DeleteStudent")
    public String Delete(Model model, @RequestParam(name="listID") String ListId){

        List<String> listID = Arrays.stream(ListId.split(",")).toList();
        listID.forEach(p->{studentService.DeleteStudent(Integer.parseInt(p));});
        return home(model,0);
    }
}
