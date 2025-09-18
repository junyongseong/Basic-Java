"use client"
import Link from "next/link";
import { useState } from "react";

export default function Page() {

    //서버 URL

    //사용자가 입력한 값들을 객체로 저장할 곳!!
    const [bbs,setBbs] = useState({});
    
    function handleChange(e){
        const {name,value}=e.target;//title과 내가 입력한 값이 들어감
        setBbs({...bbs, [name]:value})
        console.log({...bbs, [name]:value});
    }
    function sendBbs(){
        //비동기식 통신 스트링 부트 서버 호출
    }
    return (
    <div style={{ width: "90%", margin: "10px auto" }}>
      <h2>글쓰기</h2>
      <hr />
      <table className="t1">
        <tbody>
            <tr>
                <th>제목</th>
                <td colSpan={3}>
                    <input type="text" id="title" name="title"onChange={handleChange}/>
                </td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td colSpan={3}>
                    <input type="text" id="writer" name="writer"onChange={handleChange}/>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td colSpan={3}>
                    <textarea cols={40} rows={5} id="content" name="content"onChange={handleChange}>
                    </textarea>
                </td>
            </tr>
            <tr>
                <td colSpan={4}>1</td>
                    <Link href="/bbs">
                        <button type="button">뒤로</button>
                    </Link>
                    &nbsp;&nbsp;
                    <Link href="">
                        <button type="button" onClick={sendBbs}>저장</button>
                    </Link>
            </tr>
        </tbody>
      </table>
    </div>
  );
};