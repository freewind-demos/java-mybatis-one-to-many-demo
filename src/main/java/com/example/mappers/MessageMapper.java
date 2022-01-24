package com.example.mappers;

import com.example.entities.Message;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface MessageMapper {

  @Results(value = {
      @Result(column = "id", property = "allMessages", many = @Many(select = "com.example.mappers.MessageMapper.findById2", fetchType = FetchType.EAGER)),
  })
  @Select("SELECT * FROM messages")
  public List<Message> findAll();


  @Select("SELECT * FROM messages WHERE id = #{id}")
  public List<Message> findById2(String id);

  @Select("SELECT * FROM messages WHERE id = #{id}")
  public Message findById(String id);

  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  @Insert("INSERT INTO messages(text) VALUES(#{text})")
  public void create(Message message);

}
