package sist.action;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import sist.vo.DataVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class IndexAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //공공데이터 API를호출하는 경로를 준비
        //https://apis.data.go.kr/B551011/KorService2/searchFestival2?serviceKey=4Dp%2FVjC7AR4VLcx17F9Y0401KHM52eusOiNoB1m5ZLpRP%2FxczdQg5ilgbaStfSmmRYn8M68%2BGYWJYN9iU8fJKw%3D%3D&MobileApp=AppTest&MobileOS=ETC&pageNo=1&numOfRows=100&eventStartDate=20250501&arrange=C&areaCode=1&_type=xml
        StringBuffer sb =new StringBuffer("http://apis.data.go.kr/B551011/KorService2/searchFestival2?");

        String key= "4Dp%2FVjC7AR4VLcx17F9Y0401KHM52eusOiNoB1m5ZLpRP%2FxczdQg5ilgbaStfSmmRYn8M68%2BGYWJYN9iU8fJKw%3D%3D";
        String areaCode =null;
        String code =request.getParameter("areaCode");
        if (code==null)
            areaCode="1";

        String cPage= request.getParameter("cPage");
        if (cPage==null)
            cPage="1";
        String startDate =request.getParameter("startDate");
        if (startDate ==null){
            //25250725 이런 형식을 얻기 위해 형식 객체가 필요함!
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            Calendar now =Calendar.getInstance();

            startDate =sf.format(now.getTime());
        }

        sb.append("serviceKey=");
        sb.append(key);
        sb.append("&MobileApp=AppTest");
        sb.append("&MobileOS=ETC");
        sb.append("&pageNo=");
        sb.append(cPage);
        sb.append("&numOfRows=100");
        sb.append("&eventStartDate=");
        sb.append(startDate);
        sb.append("&arrange=C&areaCode=1&_type=xml");

        try {
            //브라우저 창에서 경로(URL)를 입력하고 요청하듯이 프로그램 상에서
            //요청 할때는 URL객체를 만들어야한다.
            URL url = new URL(sb.toString());

            //경로를 연결하는 객체
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //응답 받을 데이터의 형식을 지정
            conn.setRequestProperty("Content-Type","application/xml");

            //연결 - 요청!
            conn.connect();

            //JDOM라이브러리에 있는 SAXBuilder를 통해 응답메세지를
            // XML문서화 시키기 위해 준비해야한다.
            SAXBuilder builder = new SAXBuilder();

            //응답되는 내용을 하나의 XML의 문서(Document)로 인식해야한다.
            Document doc = builder.build(conn.getInputStream());


            //얻어낸 Document에서 root 엘리먼트를 얻어낸다.
            Element root = doc.getRootElement();
            //System.out.println(root.getName()); //response 찍히면 OK

            //루트안에 있는 body만 얻어낸다.
            Element body = root.getChild("body");//body라는 자식만 얻어냄

            //bodt안에 있는 items라는 자식요소를 얻어낸다.
            Element items =body.getChild("items");

            //items안에 존재하는 모든 item이라는 자식요소를 얻어낸다.
            List<Element> item_list =items.getChildren("item");

            //item들을 JSP에서 표현하기 위해 배열로 변환하여 request에 저장하려 한다.
            DataVO[] ar = new DataVO[item_list.size()];
            int i=0;
            for (Element item: item_list){
                String title = item.getChildText("title");//페스티벌 이름
                String addr1 = item.getChildText("addr1");//서울시
                String addr2 = item.getChildText("addr2");//서울시
                String firstimage = item.getChildText("firstimage");
                String firstimage2 = item.getChildText("firstimage2");
                String eventstartdate = item.getChildText("eventstartdate");
                String eventenddate = item.getChildText("eventenddate");
                String mapx = item.getChildText("mapx");
                String mapy = item.getChildText("mapy");
                String tel = item.getChildText("tel");

                DataVO vo = new DataVO(title,mapx,mapy,addr1,addr2,
                        firstimage,firstimage2,tel,eventstartdate,eventenddate);

                ar[i++] = vo;
            }//for의 끝

            //배열에 모든 item들이 vo객체로 생성되어 저장된 상태다.
            //jsp에서 표현 할 수 있도록 request에 저장하자!
            request.setAttribute("ar",ar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index.jsp";
    }
}
