package ua.dp.levelup.web;

import com.oracle.tools.packager.IOUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alexandr Shegeda (http://luxoft.com)
 */
@Controller
public class ImageController {

  @Value("${file.storage.path}")
  private String fileStorage;

  @RequestMapping(value = "/image/{name}", produces = "image/jpeg")
  public ResponseEntity<byte[]> getImageByName(@PathVariable String name) throws IOException {
    File parent = new File(fileStorage);
    File[] files = parent.listFiles((f) -> f.getName().startsWith(name));
    if (files != null && files.length == 1) {
      return new ResponseEntity<byte[]>(IOUtils.readFully(files[0]), HttpStatus.OK);
    }
    throw new FileNotFoundException();
  }
}
