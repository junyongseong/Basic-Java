<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //요청시 한글처리
  request.setCharacterEncoding("utf-8");

  //인자 받기
  String cPath= request.getParameter("cPath");//파일이 존재하는 서버의 위치
  String f_name = request.getParameter("f_name");//파일명

  //위의 값들을 절대경로로 만들자!
  String realPath = application.getRealPath("/members/" +
    cPath+"/"+f_name);

  File f =new File(realPath);

  if (f.exists()){
    //다운로드는 사용자 입장에서는 받기만 하면 되지만 서버 입장에선
    //읽기 한 후 보내야 하므로 InputStream과 OupStream을 모두 사용해야한다.
    BufferedInputStream bis =null;
    FileInputStream fis=null;
    BufferedOutputStream bos =null;
    ServletOutputStream sos=null;//*******중요******
    //요청자에게 응답으로 스트림을 줘야 다운로드가 된다. -response를 통해 얻을 수 있는
    //output스트림이기때문에 ServletOutputStream밖에 없다.

    byte[] buf = new byte[2048*2];
    int size=-1;
    try {
      //접속자 화면에 다운로드 창을 보여준다.
      response.setContentType("application/x-msdownload");
      response.setHeader("Content-Disposition",
              "attachment;filename="+new String(f_name.getBytes(),"8859_1"));
      //-------------------------------------------------------------------
      //다운로드 할 File과 연결되는 스트림 생성
      fis = new FileInputStream(f);
      bis = new BufferedInputStream(fis);//inputStream 준비 끝

      //response를 통해 이미 out이라는 이름으로 스트림이 존재하므로
      //충돌이 발생 할 수 있다. 기존것을 잠시 없앤다.

      //응답 스트림 생성
      sos= response.getOutputStream();
      bos=new BufferedOutputStream(sos);

      //파일의 자원들을 읽어서 바로 보내기 하면 된다.
      while ((size= bis.read(buf))!=-1){
        //읽은 자원은buf에 저장되어, 읽은 바이트 수는 size가 기억하고 있는 상태다.
        bos.write(buf,0,size);
        bos.flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if (fis!=null)
          fis.close();
        if(bis!=null)
          bis.close();
        if(sos!=null)
          sos.close();
        if(bos!=null)
          bos.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
%>