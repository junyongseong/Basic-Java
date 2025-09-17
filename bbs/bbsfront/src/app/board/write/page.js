"use client";

import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableRow } from "@mui/material";
import axios from "axios";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function Write() {

    const router =useRouter();
    const api_url ="/api/board/add";
    //서버로 보낼 파라미터 값들을 객체로 준비 초기값 빈 json준비
    const [vo,setVO]=useState({
        subject:"",
        writer:"",
        content:""
    });
    // 이 아래가 수행될때 빽에있는 컨트롤러 add가 실행됨
    //이때 vo가 만들어짐 자료형은 알아서 이름으로 매칭되서 들어가짐
    function saveData(){
        //비동기식 통신 수행
        axios.post(
            api_url,
            {
                subject:vo.subject,
                writer:vo.writer,
                content:vo.content,
                bname: "BBS"
            }
        ).then(function(json){
            if(json.data.cnt ==1)//1이면 cnt이고 값이 들어왔다는소리
                router.push("/");//리스트로 이동 메인으로는 ("/") 이케 한다
        });
    }
    // 이 안에 만약 subject를 바꿨다면 subject가 e라는 이벤트에 담김
    function changeVO(e){
        //목적은 useState의 vo객체를 내가 변경하는게 목적임 *********중요*********
        //그렇다면 vo를 복사해야 한다.
        let bbs = {...vo}; //복사 list면 배열로 이건 어쩌피 하나니...vo
        let value =e.target.value; //subject면 subject writer면 writer의 값 즉 사용자가 입력한 값
        let name =e.target.name; //사용자가 입력한 input의 name임 어디를 썼는지 알 수 있음
        // console.log(name+":"+value); 이걸로 확인 가능@@
        // bbs['subject']='test입니다.';
        bbs[name] =value;
        //현재는 복사본에만 담긴거니 vo에 담아야함
        setVO(bbs);//useState의 값을 최종적으로 변경하자!! ********* 중요*********
    }
  return (
    <div style={{ width: "90%", margin: "auto", padding: "20px" }}>
        <TableContainer component={Paper}>
            <Table sx={{minWidth:650}}>
                <TableBody>
                    <TableRow>
                    <TableCell>제목</TableCell>
                    <TableCell>
                        {/* 값이 바뀌었을때 changeVO함수 호출 */}
                        <input type="text" name="subject" onChange={changeVO}
                        placeholder="제목을 입력하세요..."/>
                    </TableCell>
                    </TableRow>
                    <TableRow>
                    <TableCell>글쓴이</TableCell>
                    <TableCell>
                        <input type="text" name="writer" onChange={changeVO}
                        placeholder="글쓴이를 입력하세요..."/>
                    </TableCell>
                    </TableRow>
                    <TableRow>
                    <TableCell>내용</TableCell>
                    <TableCell>
                        <textarea name="content" rows={7} cols={50} onChange={changeVO}
                        placeholder="내용을 입력하세요...">
                        </textarea>
                    </TableCell>
                    </TableRow>
                    <TableRow>
                    <TableCell colSpan={2}>
                        <Button variant="contained" color="primary" onClick={saveData}>
                            저장
                        </Button>
                    </TableCell>
                    </TableRow>
                </TableBody>
            </Table>
        </TableContainer>
    </div>
  );
}
