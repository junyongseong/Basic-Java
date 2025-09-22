"use client"
import Link from "next/link";
import styles from '../../page.module.css'
import { useState } from "react";
import { useRouter } from "next/navigation";
import TokenStore from "@/app/stroe/TokenStore";
import axios from "axios";

export default function Page() {

    const [member,setMember] = useState({});
    const router =useRouter();

    const {accessToken,setToken} = TokenStore();
    let api_url ="/api/members/login"
    function signIn(){
        axios.post(
            api_url,member,
            {
                withCredentials: true, //이거 없으면 쿠키가 안들어온다.
                headers:{
                    "Content-Type":"application/json"
                }
            }
        ).then(function(res){
            if(res.status==200){
                setToken(res.data.data.accessToken);
                router.push("/");//메인화면으로 이동 이렇게 하면 header가 다시 불려짐
                                //이떄 accessToken이 zustand에 들어가있으면 로그아웃이 보임
                                //이건 쿠키에 담은게 아닌 json으로 담아온거임
            }
        });
    }



    function handleChange(e){
        //사용자가 입력한 값들을 객체로 변경하는 함수
        let {name,value} =e.target;
        setMember({...member,[name]:value});
    }
    //Link는 정적인 얘들을 보낼때고 이런 동적인 놈들은 Router.push를 이용해야함 위에 다시만듬
    // function signIn(){
        //비동기식 통신
        //여기서 유효성 검사 토큰 유무 같은거
        //즉 정상적으로 서버로부터 처리가 되었는지? 확인
        //받은 토큰을 저장!(store개념)
    //     router.push("/");
    // }
  return (
    <div style={{ width: "90%", margin: "10px auto" }}>
      <h2>로그인</h2>
      <hr />
      <div style={{width:'250px', margin:'10px auto'}}>
      <table>
        <tbody>
            <tr>
                <td><label htmlFor="u_id">아이디</label></td>
                <td>
                    <input type="text" id="u_id" name="mid" onChange={handleChange}/>
                </td>
            </tr>
            <tr>
                <td><label htmlFor="u_pw">비밀번호</label></td>
                <td>
                    <input type="password" id="u_pw" name="mpwd" onChange={handleChange}/>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colSpan={2} className={styles.txtCenter}>
                    <button type ="button" onClick={signIn}>
                        로그인
                    </button>
                </td>
            </tr>
        </tfoot>
      </table>
      </div>
    </div>
  );
}
