package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import xml.bean.Student;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName XmlStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/11 9:08
 * @Version 1.0
 */
public class XmlStudy {
    @Test
    public void xmlParse() {

        SAXReader saxReader = new SAXReader();
        //ArrayList<Student> list = new ArrayList<>();
        try {
            final Document doc = saxReader.read(new File("src/main/resources/student.xml"));
            final Element root = doc.getRootElement();
            List<Element> elements = root.elements("student");

            List<Student> studentList = elements.stream()
                    .map(e -> new Student(e.attribute("id").getValue(), e.element("name").getText(), Integer.parseInt(e.elementText("age")),e.elementText("info")))
                    .collect(Collectors.toList());

            System.out.println(studentList);

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
