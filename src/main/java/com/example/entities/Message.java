package com.example.entities;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class Message {
  public Integer id;

  @NotBlank(message = "Message is not provided")
  @Pattern(regexp = "^\\w+$", message = "必须为常见字符")
  public String text;

  public List<Message> allMessages;
}
