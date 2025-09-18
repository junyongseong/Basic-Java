"use client"
import Link from "next/link";
import styles from '../../page.module.css'
import { useState } from "react";
import { useRouter } from "next/navigation";
export default function Page() {

    const {member,setMember} = useState({});
    const router =useRouter();

    function handleChange(e){
        //사용자가 입력한 값들을 객체로 변경하는 함수
        let {name,value} =e.target;
        setMember({...member,[name]:value});
    }
    //Link는 정적인 얘들을 보낼때고 이런 동적인 놈들은 Router.push를 이용해야함
    function signIn(){
        //비동기식 통신
        //여기서 유효성 검사 토큰 유무 같은거
        //즉 정상적으로 서버로부터 처리가 되었는지? 확인
        //받은 토큰을 저장!(store개념)
        router.push("/");
    }
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
                    <input type="password" id="u_pw" name="mpw" onChange={handleChange}/>
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
