package by.mvas.sprgr.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mvas
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceLoader resourceLoader;
    
    @RequestMapping("")
    public String page() {
        return "resourceDemo";
    }

    @RequestMapping("pic")
    @ResponseBody
    public byte[] pic() throws IOException {
        InputStream is = resourceLoader.getResource("file:c:/Users/mvas/logo11w.png").getInputStream();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384]; // portion

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

}
