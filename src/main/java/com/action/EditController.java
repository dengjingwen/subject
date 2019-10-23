package com.action;

import com.baidu.ueditor.ActionEnter;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@PropertySource(value = "classpath:param.properties",encoding = "UTF-8")
@Controller
public class EditController {

    @RequestMapping(value = "/editor/jsp/EditAction")
    public void initedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        //String rootPath = getServletContext().getRealPath( "/" );
        String rootPath = "D:\\phpfind\\WWW\\subject";
        System.out.println(" rootPath = "+rootPath);
        out.write( new ActionEnter( request, rootPath ).exec() );
        //
        out.flush();
        out.close();
    }

    /*@RequestMapping(value = "/showedit")
    public String showedit(String editorValue){
        String content = editorValue ;

        System.out.println(" content = "+content);

        return "redirect:index.html";
    }*/

    @RequestMapping(value = "/showedit2",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Map<String ,Object> showedit2(String editorValue){
        HashMap<String,Object> mp = new HashMap<>();
        mp.put("content",editorValue);
        System.out.println(" content = " + editorValue);
        return mp;
    }

    @RequestMapping(value="/uploadAjax2",method= RequestMethod.POST,consumes={MediaType.MULTIPART_FORM_DATA_VALUE},produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public HashMap<String,Object> uploadAjax2(@RequestParam(value="files",required=false) MultipartFile[] files, String title) throws Exception{
        HashMap<String,Object> hm = new HashMap(); // 返回的参数
        //文件目录
        String filePath = "E:\\PHPFind\\WWW\\img";
        System.out.println(" filePath = "+filePath);

        String webPath = "http://127.0.0.1/img/";
        System.out.println(" webPath = "+webPath);

        System.out.println(" title = "+title);

        List<String> imglist= new ArrayList();

        // 文件 处理
        if(files != null && files.length > 0){
            // 循环
            for(MultipartFile mf : files){
                System.out.println(" 文件大小：" +mf.getSize());
                System.out.println(" 文件类型：" +mf.getContentType());
                System.out.println(" 文件名称：" +mf.getOriginalFilename());

                String fname = UUID.randomUUID().toString().replace("-", "");
                int index = mf.getOriginalFilename().lastIndexOf(".");
                if(index != -1) {
                    fname += mf.getOriginalFilename().substring(index);
                    File ff = new File(filePath, fname);

                    FileUtils.copyInputStreamToFile(mf.getInputStream(), ff); // 文件copy

                    //
                    imglist.add(webPath + fname);
                }
                //
            }
            //
        }
        //
        if(imglist.size()>0){
            hm.put("imglist", imglist);
        }
        hm.put("code", "success");
        return hm;
    }
}
