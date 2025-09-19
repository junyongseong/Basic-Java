"use client"
import axios from "axios";
import Link from "next/link";
import { useParams } from "next/navigation";
import { useEffect, useState } from "react";

export default function Page(){
    const {idx} =useParams();
    // const {idx} =params;
    const api_url =`/api/bbs/${idx}`;

    //서버로부터 넘어오는 자원을 저장할 곳
    const [bbs,setBbs] =useState({});

    //비동기식 통신을 하는 함수
    function getBbs(){
        axios.get(api_url).then(function(json){
            if(json.data.totalCount>0)
                setBbs(json.data.data);
        });
    }

    //현재페이지에서 idx값이 변경될 때마다
    //비동기식 통신을 수행하는 함수를 호출한다.
    useEffect(()=>{
        getBbs();
    },[idx])
    return(
        <div style={{ width: "90%", margin: "10px auto" }}>
      <h2>보기</h2>
      <hr />
      <table className="t1">
        <tbody>
            <tr>
                <th>번호</th>
                <td colSpan={3}>{idx}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td colSpan={3}>{bbs.title}</td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td>{bbs.writer}</td>
                <th>조회수</th>
                <td>{bbs.hit}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td colSpan={3}>{bbs.write_date}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colSpan={3}>{bbs.content}</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colSpan={4}>
                    <Link href="/bbs">
                        <button type="button">뒤로</button>
                    </Link>
                </td>
            </tr>
        </tfoot>
      </table>
    </div>
    );
}