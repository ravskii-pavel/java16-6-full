package ua.dp.levelup.web;

import com.oracle.tools.packager.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.dao.UserDao;
import ua.dp.levelup.model.User;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@Controller
public class UserController {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserDao userDao;

  @Value("${file.storage.path}")
  private String fileStorage;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * /create  --> Create a new user and save it in the database.
   *
   * @param email User's email
   * @param name User's name
   * @return A string describing if the user is succesfully created or not.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String email, String name) {
    User user = null;
    try {
      user = new User(email, name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + user.getId() + ")";
  }

  /**
   * /delete  --> Delete the user having the passed id.
   *
   * @param id The id of the user to delete
   * @return A string describing if the user is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }

  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   *
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  /**
   * /update  --> Update the email and the name for the user in the database
   * having the passed id.
   *
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(long id, String email, String name) {
    try {
      User user = userDao.findOne(id);
      user.setEmail(email);
      user.setName(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

  @ResponseBody
  @RequestMapping("/users")
  public List<User> getUserList() {
    return Arrays.asList(
      new User(1, "user1@yopmail.com", "user1"),
      new User(2, "user2@yopmail.com", "user2"),
      new User(3, "user3@yopmail.com", "user3"),
      new User(4, "user4@yopmail.com", "user4"),
      new User(5, "user5@yopmail.com", "user5")
    );
  }

  @RequestMapping("user/avatar")
  public ResponseEntity<HttpStatus> uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");
    System.out.println(file.getContentType());
    try {
      byte[] data = file.getBytes();
      String filePath = fileStorage + "/" + file.getOriginalFilename();
      File f = new File(fileStorage, file.getOriginalFilename());
      FileOutputStream writer = new FileOutputStream(f);
      writer.write(data);
      System.out.println("File was saved to " + filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @RequestMapping("/user")
  public ModelAndView getUserInfoPage() throws IOException {
    ModelAndView modelAndView = new ModelAndView("user-info");
    File file = new File(fileStorage + "/ironman.jpg");
    byte[] arr = IOUtils.readFully(file);

    modelAndView.addObject("image", arr);
    modelAndView.addObject("user", new User(1, "user1@yopmail.com", "user1"));

    return modelAndView;
  }

} // class UserController
