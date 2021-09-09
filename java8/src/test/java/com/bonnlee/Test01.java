package com.bonnlee;

import com.bonnlee.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {

    @Test
    public void test01(){
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student("张三",20));
        studentList1.add(new Student("李四",30));

        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(new Student("王五",40));
        studentList2.add(new Student("赵六",50));
        List<List<Student>> allList = new ArrayList<>();
        allList.add(studentList1);
        allList.add(studentList2);

        List<Integer> collect = allList.parallelStream().flatMap(list -> list.stream().map(Student::getAge)).collect(Collectors.toList());
        System.out.println(collect);

    }

}
