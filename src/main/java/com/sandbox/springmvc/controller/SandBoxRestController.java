package com.sandbox.springmvc.controller;

import com.sandbox.springmvc.model.RegisteredUser;
import com.sandbox.springmvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


/**
 * The Class SandBoxRestController.
 */
@RestController
public class SandBoxRestController {

  /** The user service. */
  @Autowired
  UserService userService; // Service which will do all data retrieval/manipulation work

  // -------------------Retrieve All
  // Users--------------------------------------------------------

  /**
   * List all users.
   *
   * @return the response entity
   */
  @RequestMapping(value = "/user/", method = RequestMethod.GET)
  public ResponseEntity<List<RegisteredUser>> listAllUsers() {
    List<RegisteredUser> users = userService.findAllUsers();
    if (users.isEmpty()) {
      return new ResponseEntity<List<RegisteredUser>>(HttpStatus.NO_CONTENT);// You
                                                                             // many
                                                                             // decide
                                                                             // to
                                                                             // return
                                                                             // HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<RegisteredUser>>(users, HttpStatus.OK);
  }

  // -------------------Retrieve Single
  // User--------------------------------------------------------

  /**
   * Gets the user.
   *
   * @param id the id
   * @return the user
   */
  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RegisteredUser> getUser(@PathVariable("id") long id) {
    System.out.println("Fetching User with id " + id);
    RegisteredUser user = userService.findById(id);
    if (user == null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<RegisteredUser>(user, HttpStatus.OK);
  }

  // -------------------Create a
  // User--------------------------------------------------------

  /**
   * Creates the user.
   *
   * @param user the user
   * @param ucBuilder the uc builder
   * @return the response entity
   */
  @RequestMapping(value = "/user/", method = RequestMethod.POST)
  public ResponseEntity<Void> createUser(@RequestBody RegisteredUser user,
      UriComponentsBuilder ucBuilder) {
    System.out.println("Creating User " + user.getUsername());

    if (userService.isUserExist(user)) {
      System.out.println("A User with name " + user.getUsername() + " already exist");
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    userService.saveUser(user);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  // ------------------- Update a User
  // --------------------------------------------------------

  /**
   * Update user.
   *
   * @param id the id
   * @param user the user
   * @return the response entity
   */
  @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
  public ResponseEntity<RegisteredUser> updateUser(@PathVariable("id") long id,
      @RequestBody RegisteredUser user) {
    System.out.println("Updating User " + id);

    RegisteredUser currentUser = userService.findById(id);

    if (currentUser == null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
    }

    currentUser.setUsername(user.getUsername());
    currentUser.setAddress(user.getAddress());
    currentUser.setEmail(user.getEmail());

    userService.updateUser(currentUser);
    return new ResponseEntity<RegisteredUser>(currentUser, HttpStatus.OK);
  }

  // ------------------- Delete a User
  // --------------------------------------------------------

  /**
   * Delete user.
   *
   * @param id the id
   * @return the response entity
   */
  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<RegisteredUser> deleteUser(@PathVariable("id") long id) {
    System.out.println("Fetching & Deleting User with id " + id);

    RegisteredUser user = userService.findById(id);
    if (user == null) {
      System.out.println("Unable to delete. User with id " + id + " not found");
      return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
    }

    userService.deleteUserById(id);
    return new ResponseEntity<RegisteredUser>(HttpStatus.NO_CONTENT);
  }

  // ------------------- Delete All Users
  // --------------------------------------------------------

  /**
   * Delete all users.
   *
   * @return the response entity
   */
  @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
  public ResponseEntity<RegisteredUser> deleteAllUsers() {
    System.out.println("Deleting All Users");

    userService.deleteAllUsers();
    return new ResponseEntity<RegisteredUser>(HttpStatus.NO_CONTENT);
  }

}
