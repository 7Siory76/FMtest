package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.Upload;
import servlet.annotations.Controller;
import servlet.annotations.GetMapping;
import servlet.annotations.Json;
import servlet.annotations.PostMapping;
import servlet.annotations.RequestParam;
import servlet.annotations.UploadConfig;

import java.util.List;
import java.util.Map;

@Controller
public class FileUploadController {

    @GetMapping("/upload-test")
    public String uploadPage() {
        return "/pages/upload_form.jsp";
    }

    // 1. Reception automatique sous forme de Map<String, List<Upload>> avec dossier d'upload specifique
    @UploadConfig(directory = "uploads/documents")
    @PostMapping("/upload-map")
    public ModelView handleUploadMap(Map<String, List<Upload>> filesMap) {
        ModelView mv = new ModelView();
        mv.setView("/pages/upload_result.jsp");
        mv.addItem("title", "Upload reussi (Map<String, List<Upload>>)");
        mv.addItem("filesMap", filesMap);
        return mv;
    }

    // 2. Reception d'un seul fichier Upload
    @UploadConfig(directory = "uploads/avatars")
    @PostMapping("/upload-single")
    public ModelView handleUploadSingle(@RequestParam("avatar") Upload avatar) {
        ModelView mv = new ModelView();
        mv.setView("/pages/upload_result.jsp");
        mv.addItem("title", "Upload fichier unique (Upload)");
        if (avatar != null) {
            mv.addItem("singleFile", avatar);
        }
        return mv;
    }

    // 3. Reception de fichiers multiples sous forme de List<Upload>
    @UploadConfig(directory = "uploads/batch")
    @PostMapping("/upload-list")
    public ModelView handleUploadList(@RequestParam("docs") List<Upload> docs) {
        ModelView mv = new ModelView();
        mv.setView("/pages/upload_result.jsp");
        mv.addItem("title", "Upload fichiers multiples (List<Upload>)");
        mv.addItem("fileList", docs);
        return mv;
    }

    // 4. API REST @Json renvoyant les metadata des fichiers uploadees
    @Json
    @UploadConfig(directory = "uploads/api")
    @PostMapping("/upload-api")
    public Map<String, List<Upload>> handleUploadApi(Map<String, List<Upload>> filesMap) {
        return filesMap;
    }
}
