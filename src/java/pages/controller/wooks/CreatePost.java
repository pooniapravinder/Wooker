package pages.controller.wooks;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Posts;
import hibernate.query.post.PostQuery;
import hibernate.query.wooks.WookQuery;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class CreatePost {

    @RequestMapping(value = "/wooks/explore/data/m/u/ab/sh/asgr/post/", method = RequestMethod.POST)
    public String makePost(@RequestParam("sqq") String getId, MakePost makePost, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        if ((id == null) || (!pattern.matcher(id).matches())) {
            return "redirect:../../../../../../../../../home/";
        }
        WookQuery getQuery = new WookQuery();
        PostQuery postQuery = new PostQuery();
        if (getQuery.getWook(Long.valueOf(id)) == null) {
            throw new ResourceNotFoundException();
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        long timestamp = System.currentTimeMillis();
        Posts postData = new Posts(Long.valueOf(id), deviceId, timestamp, user, makePost.getTextData().trim(), false, false, null, null, null, null);
        postQuery.insertPost(postData);
        return "redirect:../?sqq=" + crypto.encodeURL(getId);
    }

}
