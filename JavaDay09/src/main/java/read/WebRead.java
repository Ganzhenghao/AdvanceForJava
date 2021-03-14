package read;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * @ClassName WebRead
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 20:50
 * @Version 1.0
 */
public class WebRead {
    public static void main(String[] args) throws IOException {
        //HttpClient httpClient = new DefaultHttpClient(); 过时
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "";
        HttpGet httpGet = new HttpGet("http://www.17k.com/list/493239.html");
        //向百度服务器发送请求，获取网页源码
        HttpResponse response = httpClient.execute(httpGet);
        //EntityUtils工具类把网页实体转换成字符串
        String content = EntityUtils.toString(response.getEntity(), "utf-8");
        Document doc = Jsoup.parse(content);

        //使用元素选择器选择 网页内容
        Elements a = doc.select(".Main .Volume dd a");

        int index = 1;
        for (Element eurl : a) {
            url = "http://www.17k.com/" + eurl.attr("href");
            HttpGet httpGet1 = new HttpGet(url);
            HttpResponse response1 = httpClient.execute(httpGet1);
            String content1 = EntityUtils.toString(response1.getEntity(), StandardCharsets.UTF_8);
            Document doc1 = Jsoup.parse(content1);

            Elements titleElement = doc1.select(".area .read .readArea .readAreaBox h1 ");
            Elements bodyElement = doc1.select(".area .read .readArea .readAreaBox .p p ");
            //正则过滤数据
            String title = titleElement.toString();
            String body = bodyElement.toString();

            String titlePattern = "</?h1>";
            String chapterPattern = "</?h1>\\s*第.+章?更?.*</?h1>";
            String bodyPattern = "</?p>";
            String bottomPattern = "<p\\s+class.*>.*</p>";

            //如果章节名不符合要求 则跳过
            if (!Pattern.compile(chapterPattern).matcher(title).matches()) {
                continue;
            }

            Pattern tPattern = Pattern.compile(titlePattern);
            Pattern b1Pattern = Pattern.compile(bodyPattern);
            Pattern b2Pattern = Pattern.compile(bottomPattern);

            String name = tPattern.matcher(title).replaceAll("").replace(" ", "");

            title = tPattern.matcher(title).replaceAll("\t\t");
            body = b2Pattern.matcher(body).replaceAll("\t");
            body = b1Pattern.matcher(body).replaceAll("\t");

            File file = new File("D:" + File.separator + "smalltalk"
                    + File.separator + index + "-" + name + ".txt");
            OutputStreamWriter writer =
                    new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8);

            writer.write(title + "\r\n" + body + "\r\n");
            writer.close();
            System.out.println("第" + index + "次爬取完成! --> " + title);
            index++;
        }

        httpClient.close();

    }
}
