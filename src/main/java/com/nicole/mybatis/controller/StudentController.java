package com.nicole.mybatis.controller;

import com.nicole.mybatis.entity.Student;
import com.nicole.mybatis.rest.Restful;
import com.nicole.mybatis.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Student 控制器
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MessageSource messageSource;

    // request来保存数据
    @RequestMapping("/jsontaglib")
    public String testJsonTaglib(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        //Only get one id this time, not much judge
        long id = 0L;
        if( request.getParameter("id") != null )
            id = Long.parseLong(request.getParameter("id"));
        student.setId(id);
        student.setName("testingJsonTaglib");
        student.setCreateAt(1289808L);
        student.setUpdateAt(23979237923L);
        student.setStudentId("stu"+id);
        Student student2 = new Student();
        id = 222L;
        student2.setId(id);
        student2.setName("testingJsonTaglib2");
        student2.setCreateAt(12898082L);
        student2.setUpdateAt(239792379232L);
        student2.setStudentId("stu"+id);
        students.add(student);
        students.add(student2);
        request.setAttribute("students", students);

        return "jsontaglib";
    }

    //@ResponseBody回复。@RequestBody接收
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addStudent(@RequestBody Student student){
        //StringUtils judge blank
        if (StringUtils.isBlank(student.getName())) {
            return Restful.set(400, messageSource.getMessage("name.null", null, null));
        } else {
            //auto increased id
            studentService.addStudent2(student);
            return Restful.set(200,  messageSource.getMessage("addSuccess",
                    null, null), student);
        }
    }

    //使用model来保存数据到前台.@PathVariable获取路径参数。即url/{id}这种形式
    @RequestMapping (value = "/getbyid/{id}", method = RequestMethod.GET)
    public String getStudentById(Model model, @PathVariable(name = "id") long id){
        Student student = studentService.getStudent( id );
        model.addAttribute("student", student);
        return "model";
    }

    //@RequestParam gets id。获取查询参数。即url?id=这种形式. return restful
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteStudent(@RequestParam(value = "id", defaultValue="0") long id) {
        System.out.println( id );
        if (null == studentService.getStudent( id )) {
            return Restful.set(400, messageSource.getMessage("id.null", null, null));
        } else {
            studentService.deleteStudent( id );
            return Restful.set(200, "deletedSuccessfully");
        }
    }

    @RequestMapping("/mav")
    public ModelAndView mav(Long id) {
        ModelAndView mav = new ModelAndView("model");
        id = 1L;
        Student student = studentService.getStudent(id);
        mav.addObject("student", student);
        return mav;
    }

    //@ResponseBody返回数据。@RequestBody接收
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateStudent(@RequestBody Student student) {
        //student cannot be null
        if (null == studentService.getStudent(student.getId())) {
            return Restful.set(400, messageSource.getMessage("id.null", null, null));
        } else {
            studentService.updateStudentById(student.getId());
            return Restful.set(200, "updated successfully", student);
        }
    }
}

