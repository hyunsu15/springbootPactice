package com.example.demo.todo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.todo.domain.ToDo;
import com.example.demo.todo.dto.CreateTodoRequestDto;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserTest;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

class TodoMapperTest {

  @Test
  public void what_mapperTest(){
    Car car = new Car("hyun",2);
    CarDto res = Mappers.getMapper(CarMapper.class).carToCarDto(car,"a");

    assertEquals(car.getMake(),res.getMake());
    assertEquals(car.getNumberOfSeats(),res.getSeatCount());
    assertEquals("a",res.getType());
  }
  @Test
  public void createTodoMapperTest(){
    User user=UserTest.testUser();
    CreateTodoRequestDto createTodoRequestDto = new CreateTodoRequestDto("1","2");
    ToDo res=new TodoMapperImpl().createRequestToDo(createTodoRequestDto,user);
    assertEquals(user.getEmail(),res.getUser().getEmail());
    assertEquals(createTodoRequestDto.getTitle(),res.getTitle());
    assertEquals("1",res.getTitle());
  }





}
class Car {

  private String make;
  private int numberOfSeats;

  public Car() {
  }

  public Car(String make, int numberOfSeats) {
    this.make = make;
    this.numberOfSeats = numberOfSeats;
  }

  public String getMake() {
    return make;
  }
  public int getNumberOfSeats() {
    return numberOfSeats;
  }
}
class CarDto {

  private String make;
  private int seatCount;
  private String type;

  public String getMake() {
    return make;
  }

  public int getSeatCount() {
    return seatCount;
  }

  public String getType() {
    return type;
  }

  public CarDto() {}
  public CarDto(String make, int seatCount, String type) {
    this.make = make;
    this.seatCount = seatCount;
    this.type = type;
  }
  //constructor, getters, setters etc.
}
@Mapper
interface CarMapper {
  @Mapping(source = "numberOfSeats", target = "seatCount")
  CarDto carToCarDto(Car car);
  @Mapping(source = "car.numberOfSeats", target = "seatCount")
  CarDto carToCarDto(Car car,String type);
}

