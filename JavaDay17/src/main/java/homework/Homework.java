package homework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/11 18:12
 * @Version 1.0
 */
public class Homework {
//    1. 请将dom4j包导入到项目中。
//	2. 使用dom4j读取1.1的books.xml文件，解析每条数据，并打印。

    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("JavaDay17/src/main/resources/books.xml"));

        Element root = document.getRootElement();
        root.elements()
                .forEach(element ->{
                    element.elements().forEach(e ->{
                        System.out.println(e.getText());
                    });
                });
    }



}
