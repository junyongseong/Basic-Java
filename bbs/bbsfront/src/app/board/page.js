"use client";
import BbsList from "@/components/BbsList";
import axios from "axios";
import { useEffect, useState } from "react";

// import styles from "../page.module.css";

export default function Page() {
  const api_url = "/api/board/list";

  // let bname="BBS"; //근데 값이 바뀌면? 그러면 아래처럼 useState사용
  const [bname, setBname] = useState("BBS");
  //스프링 서버에서 전달되는 JSON배열을 저장할 곳이 하나 필요함
  const [list, setList] = useState([]);
  const [cPage, setCpage] = useState(1);
  const [totalPage, setTotalPage] = useState(0);

  //비동기식 통신을 수행하는 함수 하나 정의
  function callData() {
    axios
      .get(
        api_url, //파라미터 받기 위해 아래처럼 bname과 cPage
        {
          params: { bname: bname, cPage: cPage },
        }
      )
      .then(function (json) {
        console.log(json);
        setList(json.data.ar);
        setTotalPage(json.data.totalPage);
      });
  }
  //   호출을 정의하기위해 useEffect 필수@@
  useEffect(
    function () {
      callData();
    },
    [cPage]
  );

  function changePage(e, p) {
    // console.log("ChangePage:" + p);
    //여기는 페이지 번호가 바뀌었을때 수행 되는곳 즉 이곳에서 cPage값을 바꿔주면 됨
    setCpage(p);
  }
  return (
    <div style={{ width: "90%", margin: "auto", padding: "20px" }}>
      <BbsList ar={list} tp={totalPage} cp={changePage}/>
      {/* cp라는 이름으로 changePage함수를 전달한다. */}
    </div>
  );
}
