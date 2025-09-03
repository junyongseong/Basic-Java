package com.sist.ex0903_kakaologin;

import mybatis.vo.MemberVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LoginControl {

    @Autowired
    private HttpSession session;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login/kakao")
    public ModelAndView loginkakao(String code){//카카오 서버가 호출하여 코드를 준다.
        ModelAndView mv = new ModelAndView();

        //카카오 서버가 인자로 전달해준 "인증 코드"가 code라는
        //변수로 들어온다.
//        System.out.println("CODE:"+code);

        //받은 인증코드를 가지고 2번째 카카오서버와 통신을 하기 위해 준비해서
        //토큰을 요청하여 받아야한다.

        String access_Token =null;
        String refresh_Token = null;

        String req_url="https://kauth.kakao.com/oauth/token";
        try {
            //웹 상의 경로(URL)를 객체화 시킨다.
            URL url = new URL(req_url);

            //웹상의 경로와 연결하는 객체   강제 형변환
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            //카카오 서버쪽에서 POST방식의 요청을 원하므로 method를 POST로 지정!
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //연결된 카카오서버로 파라미터들을 전달하기 위해 스트림 생성 writer로 해야하기때문에
            //writer로 바꿔주는 OutputStreamWriter 로 새로 생성
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            //카카오 API문서에 있는 4개의 파라미터들을 정의하기 위해
            // 문자열 편집이 필요하다.
            //ex) grant_type = abcdefg&client_iod=qweasd~~
            StringBuffer sb = new StringBuffer();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=b44bea8498c9657861f5bdbe71501d47");
            sb.append("&redirect_uri=http://localhost:8080/login/kakao");
            sb.append("&code=").append(code);

            bw.write(sb.toString());//준비된 파라미터들을 카카오서버에 보낸다.
            bw.flush();

            //카카오서버에 요청을 보낸 후 응답결과가 성공적인 경우(200)일 때만 토큰을 받아낸다.
            int res_code = conn.getResponseCode();
//            System.out.println("RES_CODE: "+res_code);

            if (res_code==200){
                //요청을 통해 얻은 결과는 JSON타입의 결과 메세지를 읽어온다.
                //그 결괄르 받기 위해 스트림 준비            다시한번 InputstreamReader로 바꿔서 가져옴
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuffer result = new StringBuffer();
                String line = null;
                //한줄 단위로 읽어서 result라는 StringBuffer에 적재한다.
                while ((line = br.readLine()) !=null) {
                    result.append(line);
                }

//                System.out.println("Result(toString) :" + result.toString());

                //Json파싱 처리: "access_token과 refresh_token
                JSONParser parser = new JSONParser();
                //위 객체는 json-simple라이브러리가 가지고 있으며
                //문자열이지만 Json형식의 결과를 JSON객체로 만들어주는 파서다.

//                Object obj =parser.parse(result.toString());
//                JSONObject json = (JSONObject) obj;
                JSONObject json = (JSONObject)parser.parse(result.toString());

                access_Token = (String) json.get("access_token");
                refresh_Token = (String) json.get("refresh_token");

//                System.out.println("access_Token :" +access_Token);
//                System.out.println("refresh_token :" +refresh_Token);

                //이제 받은 토큰을 가지고 마지막 세번째 요청으로 사용자 정보를 가져온다.
                String apiURL = "https://kapi.kakao.com/v2/user/me";
//              Bearer 다음 한칸 띄워야함
                String header ="Bearer "+access_Token;

                url = new URL(apiURL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                //카카오 API문서상에 조건이 access토큰을 header에 담아 보내야한다.
                //그래서 헤더 설정을 해야함
                conn.addRequestProperty("Authorization",header);

                res_code = conn.getResponseCode();
//                System.out.println("RES_CODE : "+res_code);
//                System.out.println("Http_ok : "+HttpURLConnection.HTTP_OK);
                if (res_code == HttpURLConnection.HTTP_OK){//위의  200과 같음
                    //요청에 성공 했을 때
                    BufferedReader brdm = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

                    StringBuffer res = new StringBuffer();
                    String line2 = null;
                    while ((line2=brdm.readLine())!=null){
                        res.append(line2);
                    }
//                    System.out.println(res.toString());
                    //받은 json형식의 결과 문자열을 JSON객체로 변환해야한다.
                    json = (JSONObject) parser.parse(res.toString());

                    //원하는 정보 nickname과 profile_image가 있는 properties라는
                    //키의 객체를 얻어내자
                    JSONObject props = (JSONObject) json.get("properties");
                    String nickname = (String) props.get("nickname");
                    String p_img = (String) props.get("profile_image");
                    JSONObject kakao = (JSONObject) json.get("kakao_account");
                    String email = (String) kakao.get("email");

//                    System.out.println("nickname :"+nickname+"profile_image: "+p_img + "email: "+email);
//                    System.out.println("profile_image: "+p_img);

                    MemberVO mvo = new MemberVO();
                    mvo.setEmail(email);
                    mvo.setP_img(p_img);
                    mvo.setNickname(nickname);

                    //DB에 저장되어 있던 사용자인지 판단!
//                    if (mvo.getEmail().equals(email))
                    mv.addObject("mvo",mvo);

                    mv.setViewName("registry");
                }
            }//if의 끝

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;

    }

}
