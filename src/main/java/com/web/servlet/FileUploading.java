package com.web.servlet;

import com.web.command.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploading extends HttpServlet {
    private static final String UPLOAD_FILE_PATH = "C:" + File.separator + "Users" + File.separator + "Peachex" + File.separator +
            "IdeaProjects" + File.separator + "web" + File.separator + "uploads" + File.separator;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String uploadFileDir = UPLOAD_FILE_PATH;
        System.out.println(uploadFileDir);
        File fileSaveDir = new File(uploadFileDir);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        request.getParts().stream().forEach(part -> {
            try {
                part.write(UPLOAD_FILE_PATH + part.getSubmittedFileName());//.substring(2)
                String path = part.getSubmittedFileName();
                String randFilename = UUID.randomUUID() + path.substring(path.lastIndexOf("."));//
                part.write(uploadFileDir + randFilename);
                request.setAttribute("upload_result", " upload successfully ");
            } catch (IOException e) {
                request.setAttribute("upload_result", " upload failed ");
            }
        });
        request.getRequestDispatcher(PagePath.SIGN_IN).forward(request, response);
    }
}
