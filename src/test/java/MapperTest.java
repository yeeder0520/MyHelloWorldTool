import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapstruct.Cat;
import com.mapstruct.Dog;
import com.mapstruct.CatDogMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/17 上午 10:09
 **/
public class MapperTest {

    @Test
    public void test(){
        Dog dog = new Dog();
        dog.setDogName("justin");
        dog.setAge(18);
        dog.setTestListDog(Arrays.asList("a","b","c"));
        Cat cat = CatDogMapper.INSTANCE.toCat(dog);
        System.out.println("cat.toString() = " + cat.toString());
    }

    @Test
    public void test_toCatList() throws IOException {
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog();
        dog.setDogName("justin");
        dog.setAge(18);
        dog.setTestListDog(Arrays.asList("a","b","c"));
        dogs.add(dog);
        dog = new Dog();
//        dog.setDogName("justin2");
        dog.setAge(19);
        dog.setTestListDog(Arrays.asList("x","y","z"));
        dogs.add(dog);

        List<Cat> cats = CatDogMapper.INSTANCE.toCatList(dogs);

        ObjectMapper mapper = new ObjectMapper();
        String catList = mapper.writeValueAsString(cats);
        System.out.println("catList = " + catList);
        List<Cat> o = mapper.readValue(catList, new TypeReference<List<Cat>>() {
        });
        System.out.println("o = " + o);

        String dogJsonString = mapper.writeValueAsString(dog);
        System.out.println("dogJsonString = " + dogJsonString);
        Dog dog1 = mapper.readValue(dogJsonString, Dog.class);
        System.out.println("dog1 = " + dog1);
    }
}
